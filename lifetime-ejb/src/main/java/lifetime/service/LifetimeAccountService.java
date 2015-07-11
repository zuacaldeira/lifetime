/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lifetime.persistence.LifetimeUser;
import lifetime.persistence.UserAccount;

/**
 * The Lifetime Account Management Service. It provides services for users to
 * register, and manage their accounts.
 *
 * @author zua
 */
@Stateless
@LocalBean
public class LifetimeAccountService {

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
     */
    public void register(String firstname, String lastname, String email, String password, String language, Date birthdate) {
        // Creates the user
        LifetimeUser user = new LifetimeUser(null, firstname, lastname, email, birthdate, null, language);
        // Initialize the user account entity
        UserAccount account = new UserAccount(null);
        account.setEmail(email);
        account.setPassword(password);
        account.setUser(user);
        // Persist the user account object graph
        try {
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
    public boolean existsUser(String email) {
        return getUserAccount(email) != null && getUser(email) != null;
    }

    public void delete(String email) {
        em.remove(getUser(email));
        em.remove(getUserAccount(email));
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
        UserAccount account = (UserAccount) q.getSingleResult();
        return account;
    }

    /**
     * Returns the user with the given username, from the database.
     *
     * @param username The user's username
     * @return
     */
    public LifetimeUser getUser(String username) {
        Query q = em.createNamedQuery("LifetimeUser.findByUsername", LifetimeUser.class);
        q.setParameter("username", username);
        LifetimeUser user = (LifetimeUser) q.getSingleResult();
        return user;
    }

}
