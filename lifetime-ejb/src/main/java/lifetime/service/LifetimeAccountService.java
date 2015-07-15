/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lifetime.persistence.UserRole;
import lifetime.persistence.LifetimeUser;
import lifetime.persistence.UserAccount;

/**
 * The Lifetime Account Management Service. It provides services for users to
 * register, and manage their accounts.
 *
 * @author zua
 */
@Stateless
public class LifetimeAccountService implements LifetimeAccountBusiness {

    /**
     * The entity manager managing our entities. It is associated with the
     * server-specific resource @{literal "jdbc/lifetime"}
     */
    @PersistenceContext(name = "jdbc/lifetime", unitName = "lifetimePU")
    private EntityManager em;

    /**
     * Registers a new user into the system. Given a set of assumed input data,
     * creates a new account related entities and persist them un the underlying
     * database. At least instances of {@link UserAccount} and
     * {@link LifetimeUser} will be created.
     *
     * @param firstname The user's first name.
     * @param lastname The user's last name
     * @param email The user's email
     * @param password The user's password
     * @param language The user's default language
     * @param birthdate The user's birth date
     * @throws lifetime.service.LifetimeSecurityException
     */
    @Override
    public void register(String firstname, String lastname, String email, String password, String language, Date birthdate) throws LifetimeSecurityException {
        // Creates the user
        LifetimeUser user = new LifetimeUser(null, firstname, lastname, email, birthdate, null, language);
        // Initialize the user account entity
        UserAccount account = new UserAccount(null, email, password);
        account.setLifetimeUser(user);

        UserRole lRole = new UserRole();
        lRole.setRoleName(Roles.USER);
        lRole.setUsername(user.getUsername());

        // Persist the user account object graph
        try {
            em.persist(lRole);
            em.persist(account);
        } catch (EntityExistsException eex) {
            throw new LifetimeSecurityException("Account already exists");
        } catch (Exception ex) {
            throw new LifetimeSecurityException(ex.getMessage());
        }
    }

    /**
     * Checks if a user with the given email exists.
     *
     * @param email The user email and username
     * @return {@code true } if the user exists, {@code false} otherwise
     */
    @Override
    public boolean existsUser(String email) {
        return getUserAccount(email) != null && getUser(email) != null;
    }

    @Override
    public void delete(String email) {
        if (getUserAccount(email) != null) {
            em.remove(getUserAccount(email));
            em.remove(getUserRole(email));
        }
    }

    /**
     * Returns the account associated with the given email.
     *
     * @param email The user's email
     * @return
     */
    private UserAccount getUserAccount(String email) {
        Query q = em.createNamedQuery("UserAccount.findByEmail", UserAccount.class);
        q.setParameter("email", email);
        List<UserAccount> accounts = q.getResultList();
        if(accounts.isEmpty()) {
            return null;
        }
        return accounts.get(0);
    }

    /**
     * Returns the user with the given username, from the database.
     *
     * @param username The user's username
     * @return
     */
    @Override
    public LifetimeUser getUser(String username) {
        Query q = em.createNamedQuery("LifetimeUser.findByUsername", LifetimeUser.class);
        q.setParameter("username", username);
        List<LifetimeUser> users = q.getResultList();
        if(users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    private UserRole getUserRole(String username) {
        Query q = em.createNamedQuery("UserRole.findByUsername", UserRole.class);
        q.setParameter("username", username);
        UserRole role = (UserRole) q.getSingleResult();
        return role;
    }

}
