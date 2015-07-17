/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import lifetime.persistence.exceptions.LifetimeSecurityException;
import java.util.Date;
import javax.ejb.Remote;

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
     * @param birthPlace Candidate's birth place
     * @throws lifetime.persistence.exceptions.LifetimeSecurityException
     */
    public boolean register(String firstname, String lastname, String email, String password, String language, Date birthdate, String birthPlace) throws LifetimeSecurityException;

    /**
     * Delete all user data from the system.
     *
     * @param email User's email
     * @throws lifetime.persistence.exceptions.LifetimeSecurityException
     */
    public void deleteAccount(String email) throws LifetimeSecurityException;

}
