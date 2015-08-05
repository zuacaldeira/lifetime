/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service.controller;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lifetime.backend.interceptors.BooleanExceptionInterceptor;
import lifetime.backend.interceptors.ObjectExceptionInterceptor;
import lifetime.backend.persistence.Account;
import lifetime.backend.persistence.User;
import lifetime.backend.util.SecurityRoles;

/**
 *
 * @author <a href="mailto:zuacaldeira@gmail.com">Alexandre Caldeira</a>
 */
@Stateless
public class AccountController {

    private static final String EMAIL = "email";

    @EJB
    private RoleController roleController;
    /**
     * Persistence Context.
     */
    @PersistenceContext(unitName = "lifetimePU")
    private EntityManager em;

    /**
     *
     * @param firstname
     * @param lastname
     * @param email
     * @param password
     * @param language
     * @param birthdate
     * @param birthPlace
     * @return
     */
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean register(String firstname, String lastname, String email, String password, String language, Date birthdate, String birthPlace) {
        User user = new User(null, firstname, lastname, birthdate, birthPlace, language);
        Account account = new Account(null, email, password);
        account.setUser(user);
        account.setRole(roleController.getRole(SecurityRoles.USER));
        em.persist(account);
        return true;
    }

    /**
     * Deletes the account associated with the given email.
     *
     * @param email
     * @return true if terminates
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean deleteAccount(String email) {
        em.remove(getAccount(email));
        return true;
    }

    /**
     *
     * @param email
     * @return
     */
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean hasAccount(String email) {
        return getAccount(email) != null;
    }

    @Interceptors({ObjectExceptionInterceptor.class})
    private Account getAccount(String email) {
        Query q = em.createNamedQuery("Account.findByEmail", Account.class);
        q.setParameter(EMAIL, email);
        List<Account> accounts = q.getResultList();
        if (!accounts.isEmpty()) {
            return accounts.get(0);
        }
        return null;
    }

    /**
     *
     * @param username
     * @return
     */
    @Interceptors({ObjectExceptionInterceptor.class})
    public String getFullName(String username) {
        if (hasAccount(username)) {
            Account a = getAccount(username);
            User u = a.getUser();
            return u.getFirstname() + " " + u.getLastname();
        }
        return null;
    }

    /**
     *
     * @param username
     * @return
     */
    @Interceptors({ObjectExceptionInterceptor.class})
    public Date getBirthdate(String username) {
        if (hasAccount(username)) {
            User u = getAccount(username).getUser();
            return u.getBirthDate();
        }
        return null;
    }

    /**
     *
     * @param username
     * @return
     */
    @Interceptors({ObjectExceptionInterceptor.class})
    public String getBirthPlace(String username) {
        if (hasAccount(username)) {
            User u = getAccount(username).getUser();
            return u.getBirthPlace();
        }
        return null;
    }

}
