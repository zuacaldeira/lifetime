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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lifetime.persistence.Users;
import lifetime.persistence.Accounts;
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

    /**
     * Persistence Context.
     */
    @PersistenceContext(name = "jdbc/lifetime")
    private EntityManager em;

    /**
     * Registers a new user into the system. Given a set of assumed input data,
     * creates a new account related entities and persist them un the underlying
     * database. At least instances of {@link Accounts} and {@link Users} will
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
     * @param language The user's default language
     * @param birthdate The user's birth date
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean register(String firstname,
            String lastname,
            String email,
            String password,
            String language,
            Date birthdate,
            String birthPlace) {
        logger.info("Creating new account for " + email);
        Users users = createUser(firstname, lastname, birthdate, birthPlace, language);
        em.persist(new Accounts(null, email, password, SecurityRoles.USER.name(), users.getId()));
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
    public boolean deleteAccount(Accounts account) {
        em.remove(account);
        logger.info("User account removed: " + account);
        return true;
    }

    private Users createUser(String firstname, String lastname, Date birthdate, String birthPlace, String language) {
        Users user = new Users(null, firstname, lastname, birthdate, birthPlace, language);
        em.persist(user);
        return em.merge(user);
    }

}
