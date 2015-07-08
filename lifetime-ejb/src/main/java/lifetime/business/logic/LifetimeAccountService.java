/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.business.logic;

import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lifetime.business.persistence.User;
import lifetime.business.persistence.UserAccount;

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
     * database. At least instances of {@link UserAccount} and {@link User} will
     * be created.
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
        User user = new User(null, firstname, lastname, password, email, email);
        user.setBirthdate(birthdate);
        // Initialize the user account entity
        UserAccount account = new UserAccount(null);
        account.setEmail(email);
        account.setPassword(password);
        account.setUser(user);
        // Persist the user account object graph
        em.persist(account);
    }

}
