/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service.controller;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lifetime.backend.interceptors.ObjectExceptionInterceptor;
import lifetime.backend.persistence.Role;
import lifetime.backend.util.SecurityRoles;

/**
 *
 * @author <a href="mailto:zuacaldeira@gmail.com">Alexandre Caldeira</a>
 */
@Stateless
public class RoleController {

    private static final String NAME = "name";
    /**
     * Persistence Context.
     */
    @PersistenceContext(unitName = "lifetimePU")
    private EntityManager em;

    /**
     *
     * @param role
     * @return
     */
    @Interceptors(ObjectExceptionInterceptor.class)
    public Role getRole(SecurityRoles role) {
        Query q = em.createNamedQuery("Role.findByName", Role.class);
        q.setParameter(NAME, role.name());
        return (Role) q.getSingleResult();
    }

}
