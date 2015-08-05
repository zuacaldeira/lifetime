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
import lifetime.backend.persistence.Address;

/**
 *
 * @author <a href="mailto:zuacaldeira@gmail.com">Alexandre Caldeira</a>
 */
@Stateless
public class AddressController extends CrudController<Address> {

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
    public Address read(String username) {
        Query q = em.createNamedQuery("Address.findByUsername", Address.class);
        q.setParameter(USERNAME, username);
        List<Address> addresses = q.getResultList();
        if (!addresses.isEmpty()) {
            return addresses.get(addresses.size() - 1);
        }
        return null;
    }

    /**
     *
     * @param address
     * @return
     */
    @Override
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean create(Address address) {
        em.persist(address);
        return true;
    }

    /**
     *
     * @param t
     * @return
     */
    @Override
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean update(Address t) {
        em.merge(t);
        return true;
    }

    /**
     *
     * @param email
     * @return
     */
    @Override
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean delete(String email) {
        if (hasAddress(email)) {
            em.remove(read(email));
            return true;
        }
        return false;
    }

    /**
     *
     * @param email
     * @return
     */
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean hasAddress(String email) {
        return read(email) != null;
    }

}
