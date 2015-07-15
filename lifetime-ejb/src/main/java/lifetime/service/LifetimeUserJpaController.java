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
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import lifetime.persistence.LifetimeUser;
import lifetime.persistence.exceptions.NonexistentEntityException;

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
    private EntityManager em;

    public LifetimeUserJpaController() {
    }

    public void create(LifetimeUser lifetimeUser) {
        em.persist(lifetimeUser);
    }

    public void edit(LifetimeUser lifetimeUser) throws NonexistentEntityException, Exception {
        try {
            lifetimeUser = em.merge(lifetimeUser);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = lifetimeUser.getId();
                if (findLifetimeUser(id) == null) {
                    throw new NonexistentEntityException("The lifetimeUser with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        try {
            LifetimeUser lifetimeUser = em.getReference(LifetimeUser.class, id);
            lifetimeUser.getId();
            em.remove(lifetimeUser);
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The lifetimeUser with id " + id + " no longer exists.");
        }
    }

    public List<LifetimeUser> findLifetimeUserEntities() {
        return findLifetimeUserEntities(true, -1, -1);
    }

    public List<LifetimeUser> findLifetimeUserEntities(int maxResults, int firstResult) {
        return findLifetimeUserEntities(false, maxResults, firstResult);
    }

    private List<LifetimeUser> findLifetimeUserEntities(boolean all, int maxResults, int firstResult) {
        try {
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
        } finally {
            em.close();
        }
    }

    public LifetimeUser
            findLifetimeUser(Integer id) {
        try {
            return em.find(LifetimeUser.class, id);
        } finally {
            em.close();
        }
    }

    public int getLifetimeUserCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<LifetimeUser> rt = cq.from(LifetimeUser.class
        );
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public void delete(String email) throws NonexistentEntityException {
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
