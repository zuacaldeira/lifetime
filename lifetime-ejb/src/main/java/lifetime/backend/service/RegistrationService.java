/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service;

import lifetime.backend.service.controller.AccountController;
import java.util.Date;
import javax.ejb.EJB;
import lifetime.backend.persistence.jooq.tables.Account;
import lifetime.backend.persistence.jooq.tables.LifetimeUser;
import lifetime.backend.persistence.jooq.tables.records.AccountRecord;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Lifetime Account Management Service. It provides services for users to
 * register, and manage their accounts.
 *
 * @author <a href="mailto:zuacaldeira@gmail.com">Alexandre Caldeira</a>
 */
@RestController
public class RegistrationService {

    /**
     * Account controller.
     */
    @EJB
    private AccountController accountController;

    /**
     * Registers a new user into the system. Given a set of assumed input data,
     * creates a new account related entities and persist them un the underlying
     * database. At least instances of {@link Account} and {@link LifetimeUser}
     * will be created.
     *
     * @param birthPlace
     * @param firstname The user's first name.
     * @param lastname The user's last name
     * @param email The user's email
     * @param password The user's password
     * @param language The user's default language
     * @param birthdate The user's birth date
     */
    public boolean register(String firstname,
            String lastname,
            String email,
            String password,
            String language,
            Date birthdate,
            String birthPlace) {
        return accountController.register(firstname, lastname, email, password, language, birthdate, birthPlace);
    }

    /**
     * Check if there is an account for the given email and password.
     *
     * @param email email address
     * @param password email's password
     * @return {@code true} if there is an account in the database with this
     * email and password; {@code } otherwise.
     */
    public boolean exists(String email, String password) {
        return read(email) != null;
    }

    public AccountRecord read(String email) {
        return accountController.read(email);
    }

}
