/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import java.util.Date;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lifetime.persistence.Account;
import lifetime.persistence.Roles;
import lifetime.persistence.Users;
import lifetime.util.SecurityRole;

/**
 * The Lifetime Account Management Service. It provides services for users to
 * register, and manage their accounts.
 *
 * @author zua
 */
@Stateless
@Remote(LifetimeAccountBusiness.class)

@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Interceptors({LoggerInterceptor.class, ExceptionHandlerInterceptor.class})
public class LifetimeAccountService implements LifetimeAccountBusiness {

    @PersistenceContext(name = "jdbc/lifetime", unitName = "lifetimePU")
    private EntityManager em;

    /**
     * Registers a new user into the system. Given a set of assumed input data,
     * creates a new account related entities and persist them un the underlying
     * database. At least instances of {@link UserAccount} and {@link User} will
     * be created.
     *
     * <p>
     * @todo After the end returns without error the new transaction should be
     * persisted: Check if the client transaction must be refreshed.
     * </p>
     *
     * @param firstname The user's first name.
     * @param lastname The user's last name
     * @param email The user's email
     * @param password The user's password
     * @param motherLanguage The user's default language
     * @param birthdate The user's birth date
     */
    @Override
    @Interceptors({RegisterInterceptor.class})
    public boolean register(String firstname,
            String lastname,
            String email,
            String password,
            String motherLanguage,
            Date birthdate,
            String birthPlace) {
        // Create a new Account entity, and set it's security role

        // Create a new user and associate it with the new accpount
        Users user = new Users(null, firstname, lastname, birthdate, birthPlace, motherLanguage);
        Account account = new Account(null, email, password);
        account.setOwner(user);
        account.setPlayingRole(findRoleByName(SecurityRole.USER.name()));
        // Request saving teh account in the db
        em.persist(user);
        return true;
    }

    /**
     * Deletes the account associated with the given email.
     *
     * @param email account email
     * @return true if terminates
     */
    @Override
    public boolean deleteAccount(String email) {
        Account account = findAccountByEmail(email);
        em.remove(account);
        return true;
    }

    private Account findAccountByEmail(String email) {
        try {
            Query q = em.createNamedQuery("Account.findByEmail", Account.class);
            q.setParameter("email", email);
            return (Account) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    private Roles findRoleByName(String roles) {
        Query q = em.createNamedQuery("Roles.findByName", Roles.class);
        q.setParameter("name", roles);
        return (Roles) q.getSingleResult();
    }

    @Override
    public boolean existsAccount(String email) {
        return findAccountByEmail(email) != null;
    }

}
