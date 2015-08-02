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
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lifetime.interceptors.RegisterInterceptor;
import lifetime.persistence.Account;
import lifetime.persistence.Address;
import lifetime.persistence.Contact;
import lifetime.persistence.Photo;

/**
 * The Lifetime Account Management Service. It provides services for users to
 * register, and manage their accounts.
 *
 * @author zua
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class LifetimeAccountService {

    /**
     * Persistence Context.
     */
    @PersistenceContext(unitName = "lifetimePU")
    private EntityManager em;

    /**
     * Account controller.
     */
    @EJB
    private AccountController accountController;
    @EJB
    private PhotoController photoController;
    @EJB
    private AddressController addressController;
    @EJB
    private ContactController contactController;

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
    @Interceptors({RegisterInterceptor.class})
    public boolean register(String firstname,
            String lastname,
            String email,
            String password,
            String language,
            Date birthdate,
            String birthPlace) {
        return accountController.register(firstname, lastname, email, password, language, birthdate, birthPlace);
    }

    public boolean hasAccount(String email) {
        return accountController.hasAccount(email);
    }

    public boolean deleteAccount(String email) {
        return accountController.deleteAccount(email);
    }

    public String getFullName(String username) {
        return accountController.getFullName(username);
    }

    public String getBirthPlace(String username) {
        return accountController.getBirthPlace(username);
    }

    public Date getBirthdate(String username) {
        return accountController.getBirthdate(username);
    }

    public Contact getContact(String username) {
        return contactController.getContact(username);
    }

    public Address getAddress(String username) {
        return addressController.getAddress(username);
    }

    public void addPhoto(String username, byte[] image) {
        photoController.addPhoto(username, image);
    }

    public Photo getPhoto(String username) {
        return photoController.getPhoto(username);
    }
}
