/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service;

import lifetime.backend.service.controller.AccountController;
import lifetime.backend.service.controller.AddressController;
import lifetime.backend.service.controller.PhotoController;
import lifetime.backend.service.controller.ContactController;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import lifetime.backend.persistence.Account;
import lifetime.backend.persistence.Address;
import lifetime.backend.persistence.Contact;
import lifetime.backend.persistence.Photo;

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
     *
     * @param email
     * @return
     */
    public boolean hasAccount(String email) {
        return accountController.hasAccount(email);
    }

    /**
     *
     * @param email
     * @return
     */
    public boolean deleteAccount(String email) {
        return accountController.deleteAccount(email);
    }

    /**
     *
     * @param username
     * @return
     */
    public String getFullName(String username) {
        return accountController.getFullName(username);
    }

    /**
     *
     * @param username
     * @return
     */
    public String getBirthPlace(String username) {
        return accountController.getBirthPlace(username);
    }

    /**
     *
     * @param username
     * @return
     */
    public Date getBirthdate(String username) {
        return accountController.getBirthdate(username);
    }

    /**
     *
     * @param username
     * @return
     */
    public Contact getContact(String username) {
        return contactController.read(username);
    }

    /**
     *
     * @param username
     * @return
     */
    public Address getAddress(String username) {
        return addressController.read(username);
    }

    /**
     *
     * @param p
     * @return
     */
    public boolean addPhoto(Photo p) {
        return photoController.create(p);
    }

    /**
     *
     * @param username
     * @return
     */
    public Photo getPhoto(String username) {
        return photoController.read(username);
    }

    /**
     *
     * @param email
     * @return
     */
    public boolean hasPhoto(String email) {
        return photoController.hasPhoto(email);
    }

    /**
     *
     * @param contact
     * @return
     */
    public boolean addContact(Contact contact) {
        return contactController.create(contact);
    }

    /**
     *
     * @param email
     * @return
     */
    public boolean hasAddress(String email) {
        return addressController.hasAddress(email);
    }

    /**
     *
     * @param address
     * @return
     */
    public boolean addAddress(Address address) {
        return addressController.create(address);
    }

    /**
     *
     * @param address
     * @return
     */
    public boolean deleteAddress(Address address) {
        return addressController.delete(address.getUsername());
    }

    /**
     *
     * @param contact
     * @return
     */
    public boolean deleteContact(Contact contact) {
        return contactController.delete(contact.getUsername());
    }

    /**
     *
     * @param username
     * @return
     */
    public boolean hasContact(String username) {
        return contactController.hasContact(username);
    }

    /**
     *
     * @param email
     * @return
     */
    public boolean deletePhoto(String email) {
        return photoController.delete(email);
    }

}
