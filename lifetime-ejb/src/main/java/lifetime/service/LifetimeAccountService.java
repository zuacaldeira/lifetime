/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import lifetime.persistence.LifetimeUser;
import lifetime.persistence.UserAccount;
import org.slf4j.Logger;

/**
 * The Lifetime Account Management Service. It provides services for users to
 * register, and manage their accounts.
 *
 * @author zua
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class LifetimeAccountService implements LifetimeAccountBusiness {

    /**
     * JPA Controller.
     */
    @EJB
    private UserAccountJpaController accountController;

    /**
     * sl4j Logger
     */
    private Logger logger = org.slf4j.LoggerFactory.getLogger(LifetimeAccountService.class);

    /**
     * Registers a new user into the system. Given a set of assumed input data,
     * creates a new account related entities and persist them un the underlying
     * database. At least instances of {@link UserAccount} and
     * {@link LifetimeUser} will be created.
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
        UserAccount account = new UserAccount(null, email, password);
        LifetimeUser user = new LifetimeUser(null, firstname, lastname, email, birthdate, birthPlace, language);
        account.setLifetimeUser(user);
        accountController.create(account);
        logger.info("New user resgistered: " + email);
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
        accountController.delete(email);
        logger.info("User account removed: " + email);
        return true;
    }

}
