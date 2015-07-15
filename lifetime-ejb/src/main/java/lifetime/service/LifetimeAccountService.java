/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import lifetime.persistence.exceptions.LifetimeSecurityException;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import lifetime.persistence.LifetimeUser;
import lifetime.persistence.UserAccount;
import lifetime.persistence.exceptions.NonexistentEntityException;

/**
 * The Lifetime Account Management Service. It provides services for users to
 * register, and manage their accounts.
 *
 * @author zua
 */
@Stateless
public class LifetimeAccountService implements LifetimeAccountBusiness {

    /**
     * JPA Controller.
     */
    @EJB
    private LifetimeUserJpaController userController;

    /**
     * JPA Controller.
     */
    @EJB
    private UserAccountJpaController accountController;

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
    @Override
    public void register(String firstname, String lastname, String email, String password, String language, Date birthdate, String birthPlace) throws LifetimeSecurityException {
        UserAccount account = new UserAccount(null, email, password);
        LifetimeUser user = new LifetimeUser(null, firstname, lastname, email, birthdate, birthPlace, language);
        account.setLifetimeUser(user);
        accountController.create(account);
        System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
    }

    @Override
    public void deleteAccount(String email) throws NonexistentEntityException {
        accountController.delete(email);
    }

}
