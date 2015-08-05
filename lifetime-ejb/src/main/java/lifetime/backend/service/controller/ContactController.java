/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service.controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lifetime.backend.interceptors.BooleanExceptionInterceptor;
import lifetime.backend.interceptors.ObjectExceptionInterceptor;
import lifetime.backend.persistence.Contact;

/**
 *
 * @author <a href="mailto:zuacaldeira@gmail.com">Alexandre Caldeira</a>
 */
@Stateless
public class ContactController extends CrudController<Contact> {

    private static final String USERNAME = "username";
    /**
     * Persistence Context.
     */
    @PersistenceContext(unitName = "lifetimePU")
    private EntityManager em;

    /**
     *
     * @param username
     * @return
     */
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

    /**
     *
     * @param email
     * @return
     */
    @Override
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean delete(String email) {
        if (hasContact(email)) {
            em.remove(read(email));
            return true;
        }
        return false;
    }

    /**
     *
     * @param contact
     * @return
     */
    @Override
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean create(Contact contact) {
        em.persist(contact);
        return true;
    }

    /**
     *
     * @param email
     * @return
     */
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean hasContact(String email) {
        return read(email) != null;
    }

    /**
     *
     * @param t
     * @return
     */
    @Override
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean update(Contact t) {
        em.merge(t);
        return true;
    }

}
