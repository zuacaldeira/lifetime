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
import lifetime.persistence.Account;
import lifetime.persistence.User;
import org.slf4j.Logger;

/**
 * The Lifetime Account Management Service. It provides services for users to
 * register, and manage their accounts.
 *
 * @author zua
 */
@Stateless(name = "LifetimeAccountService")
@Remote(LifetimeAccountBusiness.class)

@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class LifetimeAccountService implements LifetimeAccountBusiness {

    /**
     * sl4j Logger
     */
    private Logger logger = org.slf4j.LoggerFactory.getLogger(LifetimeAccountService.class);

    @Resource
    private SessionContext ctx;
    /**
     * Persistence Context.
     */
    @PersistenceContext(name = "jdbc/lifetime")
    private EntityManager em;

    /**
     * Registers a new user into the system. Given a set of assumed input data,
     * creates a new account related entities and persist them un the underlying
     * database. At least instances of {@link Account} and {@link Users} will be
     * created.
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
        logger.info("Creating new account for " + email);
        User users = new User(null, firstname, lastname, birthdate, birthPlace, language);
        Account account = new Account(null, email, password);
        em.persist(account);
        logger.info("Registration successfull for: " + email);
        return true;
    }

    /**
     * Deletes the account associated with the given email.
     *
     * @return true if terminates
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean deleteAccount(Account account) {
        em.remove(account);
        logger.info("User account removed: " + account);
        return true;
    }

}
