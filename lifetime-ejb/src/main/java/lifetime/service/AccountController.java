/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

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
import lifetime.interceptors.BooleanExceptionInterceptor;
import lifetime.interceptors.ObjectExceptionInterceptor;
import lifetime.persistence.Account;
import lifetime.persistence.User;

/**
 *
 * @author zua
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

    @Interceptors({ObjectExceptionInterceptor.class})
    public String getFullName(String username) {
        if (hasAccount(username)) {
            Account a = getAccount(username);
            User u = a.getUser();
            return u.getFirstname() + " " + u.getLastname();
        }
        return null;
    }

    @Interceptors({ObjectExceptionInterceptor.class})
    public Date getBirthdate(String username) {
        if (hasAccount(username)) {
            User u = getAccount(username).getUser();
            return u.getBirthDate();
        }
        return null;
    }

    @Interceptors({ObjectExceptionInterceptor.class})
    public String getBirthPlace(String username) {
        if (hasAccount(username)) {
            User u = getAccount(username).getUser();
            return u.getBirthPlace();
        }
        return null;
    }

}
