/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import java.io.Serializable;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import lifetime.persistence.LifetimeUser;

/**
 *
 * @author zua
 */
@Stateless
@LocalBean
public class LifetimeUserJpaController implements Serializable {

    /**
     * The entity manager managing our entities. It is associated with the
     * server-specific resource @{literal "jdbc/lifetime"}
     */
    @PersistenceContext(name = "jdbc/lifetime", unitName = "lifetimePU")
    private transient EntityManager em;

    public void create(LifetimeUser lifetimeUser) {
        em.persist(lifetimeUser);
    }

    public void edit(LifetimeUser lifetimeUser) {
        em.merge(lifetimeUser);
    }

    public void destroy(Integer id) {
        LifetimeUser lifetimeUser = em.getReference(LifetimeUser.class, id);
        lifetimeUser.getId();
        em.remove(lifetimeUser);
    }

    public List<LifetimeUser> findLifetimeUserEntities() {
        return findLifetimeUserEntities(true, -1, -1);
    }

    public List<LifetimeUser> findLifetimeUserEntities(int maxResults, int firstResult) {
        return findLifetimeUserEntities(false, maxResults, firstResult);
    }

    private List<LifetimeUser> findLifetimeUserEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq
                .select(cq.from(LifetimeUser.class
                        ));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }

        return q.getResultList();
    }

    public LifetimeUser findLifetimeUser(Integer id) {
        return em.find(LifetimeUser.class, id);
    }

    public int getLifetimeUserCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<LifetimeUser> rt = cq.from(LifetimeUser.class
        );
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public void delete(String email) {
        Integer id = getUserId(email);
        destroy(id);
    }

    private Integer getUserId(String email) {
        Query q = em.createNamedQuery("LifetimeUser.findByUsername", LifetimeUser.class
        );
        q.setParameter(
                "username", email);
        LifetimeUser user = (LifetimeUser) q.getSingleResult();

        if (user
                == null) {
            return null;
        } else {
            return user.getId();
        }
    }

}
