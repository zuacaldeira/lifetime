/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import java.util.Date;
import lifetime.persistence.Accounts;

/**
 * This interface defines the contract between the clients and the account
 * service.
 *
 * @author Alexandre Caldeira
 */
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
     */
    public boolean register(String firstname, String lastname, String email, String password, String language, Date birthdate, String birthPlace);

    /**
     * Delete all user data from the system.
     *
     * @param account
     * @return {@code true} if the account data is successfully removed
     */
    public boolean deleteAccount(Accounts account);

}
