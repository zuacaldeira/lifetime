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
import lifetime.exceptions.ReadEntityException;
import lifetime.persistence.Role;

/**
 *
 * @author zua
 */
@Stateless
public class RoleController {

    private static final String NAME = "name";
    /**
     * Persistence Context.
     */
    @PersistenceContext(unitName = "lifetimePU")
    private EntityManager em;

    public Role getRole(SecurityRoles role) {
        try {
            Query q = em.createNamedQuery("Role.findByName", Role.class);
            q.setParameter(NAME, role.name());
            return (Role) q.getSingleResult();
        } catch (Exception ex) {
            throw new ReadEntityException(ex);
        }
    }

}
