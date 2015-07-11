/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import java.util.Date;
import javax.ejb.Remote;
import lifetime.persistence.LifetimeUser;

/**
 * This interface defines the contract between the clients and the account
 * service.
 *
 * @author Alexandre Caldeira
 */
@Remote
public interface LifetimeAccountBusiness {

    /**
     * Register a new user candidate into the system.
     *
     * @param firstname Candidate's first names
     * @param lastname Candidate's last names
     * @param email Candidate's email
     * @param password Candidate's password
     * @param language Candidate's language
     * @param birthdate Candidate's birth date
     */
    public void register(String firstname, String lastname, String email, String password, String language, Date birthdate) throws LifetimeSecurityException;

    /**
     * Checks if the system contains a user with the given email.
     *
     * @param email The user's email
     * @return true if there is a user u, such that,
     * {@code u.getEmail() == email}
     */
    public boolean existsUser(String email);

    /**
     * Delete all user data from the system.
     *
     * @param email User's email
     */
    public void delete(String email);

    /**
     * Returns the user with the given email.
     *
     * @param email The user's email
     * @return
     */
    public LifetimeUser getUser(String email);

}
