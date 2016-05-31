/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service;

import lifetime.backend.service.controller.AccountController;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import lifetime.backend.persistence.jooq.tables.Account;
//import lifetime.backend.persistence.jooq.tables.Contact;
//import lifetime.backend.persistence.jooq.tables.Photo;
//import lifetime.backend.persistence.jooq.tables.User;
//import lifetime.backend.service.controller.UserController;

/**
 * The Lifetime Account Management Service. It provides services for users to
 * register, and manage their accounts.
 *
 * @author <a href="mailto:zuacaldeira@gmail.com">Alexandre Caldeira</a>
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class LifetimeAccountService {

    /**
     * Account controller.
     */
    @EJB
    private AccountController accountController;

    /**
     * Registers a new user into the system. Given a set of assumed input data,
     * creates a new account related entities and persist them un the underlying
     * database. At least instances of {@link Account} and {@link Users} will be
     * created.
     *
     * <p>
     * @param birthPlace
     * @return After the end returns without error the new transaction should be
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
    public boolean register(String firstname,
            String lastname,
            String email,
            String password,
            String language,
            Date birthdate,
            String birthPlace) {
        return accountController.register(firstname, lastname, email, password, language, birthdate, birthPlace);
    }

}
