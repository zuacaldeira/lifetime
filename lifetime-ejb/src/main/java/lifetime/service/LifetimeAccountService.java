/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lifetime.persistence.Account;
import lifetime.persistence.User;

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
public class LifetimeAccountService implements LifetimeAccountBusiness {

    @Resource
    private SessionContext ctx;
    /**
     * Persistence Context.
     */
    @PersistenceContext(unitName = "lifetimePU")
    private EntityManager em;

    /**
     * Registers a new user into the system. Given a set of assumed input data,
     * creates a new account related entities and persist them un the underlying
     * database. At least instances of {@link Account} and {@link Users} will be
     * created.
     *
     * <p>
     * @return @todo After the end returns without error the new transaction
     * should be persisted: Check if the client transaction must be refreshed.
     * </p>
     *
     * @param firstname The user's first name.
     * @param lastname The user's last name
     * @param email The user's email
     * @param password The user's password
     * @param language The user's default language
     * @param birthdate The user's birth date
     */
    @Override
    public boolean register(String firstname,
            String lastname,
            String email,
            String password,
            String language,
            Date birthdate,
            String birthPlace) {
        if (!hasAccount(email)) {
            User user = new User(null, firstname, lastname, birthdate, birthPlace, language);
            Account account = new Account(null, email, password);
            account.setUser(user);
            try {
                em.persist(account);
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Deletes the account associated with the given email.
     *
     * @param email
     * @return true if terminates
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean deleteAccount(String email) {
        if (hasAccount(email)) {
            try {
                em.remove(getAccount(email));
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean hasAccount(String email) {
        return getAccount(email) != null;
    }

    private Account getAccount(String email) {
        try {
            Query q = em.createNamedQuery("Account.findByEmail", Account.class);
            q.setParameter("email", email);
            return (Account) q.getSingleResult();
        } catch (Exception ex) {
            //Logger.getLogger("Test").
            return null;
        }
    }

}
