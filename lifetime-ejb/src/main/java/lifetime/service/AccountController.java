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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lifetime.exceptions.CreateEntityException;
import lifetime.persistence.Account;
import lifetime.persistence.User;

/**
 *
 * @author zua
 */
@Stateless
public class AccountController {

    private static final String EMAIL = "email";
    private static final String USERNAME = "username";

    @EJB
    private RoleController roleController;
    /**
     * Persistence Context.
     */
    @PersistenceContext(unitName = "lifetimePU")
    private EntityManager em;

    public boolean register(String firstname, String lastname, String email, String password, String language, Date birthdate, String birthPlace) {
        try {
            if (!hasAccount(email)) {
                User user = new User(null, firstname, lastname, birthdate, birthPlace, language);
                Account account = new Account(null, email, password);
                account.setUser(user);
                account.setRole(roleController.getRole(SecurityRoles.USER));
                em.persist(account);
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            throw new CreateEntityException(ex);
        }
    }

    /**
     * Deletes the account associated with the given email.
     *
     * @param email
     * @return true if terminates
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean deleteAccount(String email) {
        if (hasAccount(email)) {
            em.remove(getAccount(email));
            return true;
        } else {
            return false;
        }
    }

    public boolean hasAccount(String email) {
        return getAccount(email) != null;
    }

    private Account getAccount(String email) {
        Query q = em.createNamedQuery("Account.findByEmail", Account.class);
        q.setParameter(EMAIL, email);
        return (Account) q.getSingleResult();
    }

    public String getFullName(String username) {
        if (hasAccount(username)) {
            Account a = getAccount(username);
            User u = a.getUser();
            return u.getFirstname() + " " + u.getLastname();
        }
        return null;
    }

    public Date getBirthdate(String username) {
        if (hasAccount(username)) {
            User u = getAccount(username).getUser();
            return u.getBirthDate();
        }
        return null;
    }

    public String getBirthPlace(String username) {
        if (hasAccount(username)) {
            User u = getAccount(username).getUser();
            return u.getBirthPlace();
        }
        return null;
    }

}
