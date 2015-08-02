/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import lifetime.exceptions.ReadEntityException;
import lifetime.exceptions.DeleteEntityException;
import lifetime.exceptions.CreateEntityException;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lifetime.interceptors.RegisterInterceptor;
import lifetime.persistence.Account;
import lifetime.persistence.Address;
import lifetime.persistence.Contact;
import lifetime.persistence.Photo;
import lifetime.persistence.Role;
import lifetime.persistence.User;

/**
 * The Lifetime Account Management Service. It provides services for users to
 * register, and manage their accounts.
 *
 * @author zua
 */
@Stateless
@Remote(LifetimeAccountBusiness.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class LifetimeAccountService implements LifetimeAccountBusiness {

    private static final String USERNAME = "username";
    private static final String EMAIL = "email";
    private static final String NAME = "name";
    /**
     * Persistence Context.
     */
    @PersistenceContext(unitName = "lifetimePU")
    private EntityManager em;

    /**
     * Registers a new user into the system. Given a set of assumed input data,
     * creates a new account related entities and persist them un the underlying
     * database. At least instances of {@link Account} and {@link Users} will be
     * created.
     *
     * <p>
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
    @Override
    @Interceptors({RegisterInterceptor.class})
    public boolean register(String firstname,
            String lastname,
            String email,
            String password,
            String language,
            Date birthdate,
            String birthPlace) {
        try {
            if (!hasAccount(email)) {
                User user = new User(null, firstname, lastname, birthdate, birthPlace, language);
                Account account = new Account(null, email, password);
                account.setUser(user);
                account.setRole(getRole(SecurityRoles.USER));
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
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean deleteAccount(String email) {
        try {
            if (hasAccount(email)) {
                em.remove(getAccount(email));
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            throw new DeleteEntityException(ex);
        }
    }

    @Override
    public boolean hasAccount(String email) {
        return getAccount(email) != null;
    }

    private Account getAccount(String email) {
        try {
            Query q = em.createNamedQuery("Account.findByEmail", Account.class);
            q.setParameter(EMAIL, email);
            return (Account) q.getSingleResult();
        } catch (Exception ex) {
            throw new ReadEntityException(ex);
        }
    }

    private Role getRole(SecurityRoles role) {
        try {
            Query q = em.createNamedQuery("Role.findByName", Role.class);
            q.setParameter(NAME, role.name());
            return (Role) q.getSingleResult();
        } catch (Exception ex) {
            throw new ReadEntityException(ex);
        }
    }

    @Override
    public Photo getPhoto(String username) {
        try {
            Query q = em.createNamedQuery("Photo.findByUsername", Photo.class);
            q.setParameter(USERNAME, username);
            List<Photo> photos = q.getResultList();
            if (!photos.isEmpty()) {
                return photos.get(0);
            }
            return null;
        } catch (Exception ex) {
            throw new ReadEntityException(ex);
        }

    }

    @Override
    public String getFullName(String username) {
        try {
            if (hasAccount(username)) {
                Account a = getAccount(username);
                User u = a.getUser();
                return u.getFirstname() + " " + u.getLastname();
            }
            return null;
        } catch (Exception ex) {
            throw new ReadEntityException(ex);
        }
    }

    @Override
    public void addPhoto(String username, byte[] b) {
        try {
            Account a = getAccount(username);
            if (a != null) {
                Photo p = new Photo();
                p.setImage(b);
                p.setUsername(username);
                deleteAllPhotos(username);
                em.persist(p);
            }
        } catch (Exception ex) {
            throw new CreateEntityException(ex);
        }
    }

    @Override
    public Contact getContact(String username) {
        try {
            Query q = em.createNamedQuery("Contact.findByUsername", Contact.class);
            q.setParameter(USERNAME, username);
            return (Contact) q.getSingleResult();
        } catch (Exception ex) {
            throw new CreateEntityException(ex);
        }
    }

    @Override
    public Address getAddress(String username) {
        try {
            Query q = em.createNamedQuery("Address.findByUsername", Address.class);
            q.setParameter(USERNAME, username);
            return (Address) q.getSingleResult();
        } catch (Exception ex) {
            throw new CreateEntityException(ex);
        }
    }

    private void deleteAllPhotos(String username) {
        try {
            Query q = em.createNamedQuery("Photo.findByUsername", Photo.class);
            q.setParameter(USERNAME, username);
            List<Photo> photos = q.getResultList();
            for (Photo p : photos) {
                em.remove(p);
            }
        } catch (Exception ex) {
            throw new DeleteEntityException(ex);
        }
    }

    @Override
    public Date getBirthdate(String username) {
        try {
            if (hasAccount(username)) {
                User u = getAccount(username).getUser();
                return u.getBirthDate();
            }
            return null;
        } catch (Exception ex) {
            throw new CreateEntityException(ex);
        }
    }

    @Override
    public String getBirthPlace(String username) {
        try {
            if (hasAccount(username)) {
                User u = getAccount(username).getUser();
                return u.getBirthPlace();
            }
            return null;
        } catch (Exception ex) {
            throw new CreateEntityException(ex);
        }
    }

}
