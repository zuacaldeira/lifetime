/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lifetime.exceptions.CreateEntityException;
import lifetime.persistence.Address;

/**
 *
 * @author zua
 */
@Stateless
public class AddressController {

    private static final String USERNAME = "username";
    /**
     * Persistence Context.
     */
    @PersistenceContext(unitName = "lifetimePU")
    private EntityManager em;

    public Address getAddress(String username) {
        try {
            Query q = em.createNamedQuery("Address.findByUsername", Address.class);
            q.setParameter(USERNAME, username);
            return (Address) q.getSingleResult();
        } catch (Exception ex) {
            throw new CreateEntityException(ex);
        }
    }

}
