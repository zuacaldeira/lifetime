/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lifetime.interceptors.BooleanExceptionInterceptor;
import lifetime.interceptors.ObjectExceptionInterceptor;
import lifetime.persistence.Contact;

/**
 *
 * @author zua
 */
@Stateless
public class ContactController extends CrudController<Contact> {

    private static final String USERNAME = "username";
    /**
     * Persistence Context.
     */
    @PersistenceContext(unitName = "lifetimePU")
    private EntityManager em;

    @Override
    @Interceptors({ObjectExceptionInterceptor.class})
    public Contact read(String username) {
        Query q = em.createNamedQuery("Contact.findByUsername", Contact.class);
        q.setParameter(USERNAME, username);
        List<Contact> contacts = q.getResultList();
        if (!contacts.isEmpty()) {
            return contacts.get(contacts.size() - 1);
        } else {
            return null;
        }
    }

    @Override
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean delete(String email) {
        if (hasContact(email)) {
            em.remove(read(email));
            return true;
        }
        return false;
    }

    @Override
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean create(Contact contact) {
        em.persist(contact);
        return true;
    }

    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean hasContact(String email) {
        return read(email) != null;
    }

    @Override
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean update(Contact t) {
        em.merge(t);
        return true;
    }

}
