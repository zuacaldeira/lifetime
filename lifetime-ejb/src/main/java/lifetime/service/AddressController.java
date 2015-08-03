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
import lifetime.persistence.Address;

/**
 *
 * @author zua
 */
@Stateless
public class AddressController extends CrudController<Address> {

    private static final String USERNAME = "username";
    /**
     * Persistence Context.
     */
    @PersistenceContext(unitName = "lifetimePU")
    private EntityManager em;

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

    @Override
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean create(Address address) {
        em.persist(address);
        return true;
    }

    @Override
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean update(Address t) {
        em.merge(t);
        return true;
    }

    @Override
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean delete(String email) {
        if (hasAddress(email)) {
            em.remove(read(email));
            return true;
        }
        return false;
    }

    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean hasAddress(String email) {
        return read(email) != null;
    }

}
