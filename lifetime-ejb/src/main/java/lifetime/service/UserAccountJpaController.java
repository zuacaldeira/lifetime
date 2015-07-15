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
import lifetime.persistence.UserAccount;
import lifetime.persistence.exceptions.NonexistentEntityException;

/**
 *
 * @author zua
 */
@Stateless
@LocalBean
public class UserAccountJpaController implements Serializable {

    /**
     * The entity manager managing our entities. It is associated with the
     * server-specific resource @{literal "jdbc/lifetime"}
     */
    @PersistenceContext(name = "jdbc/lifetime", unitName = "lifetimePU")
    private EntityManager em;

    public UserAccountJpaController() {
    }

    public void create(UserAccount userAccount) {
        em.persist(userAccount);
    }

    public void edit(UserAccount userAccount) throws NonexistentEntityException, Exception {
        try {
            userAccount = em.merge(userAccount);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = userAccount.getId();
                if (findUserAccount(id) == null) {
                    throw new NonexistentEntityException("The userAccount with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        try {
            UserAccount userAccount = em.getReference(UserAccount.class, id);
            userAccount.getId();
            em.remove(userAccount);
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The userAccount with id " + id + " no longer exists.");
        }
    }

    public List<UserAccount> findUserAccountEntities() {
        return findUserAccountEntities(true, -1, -1);
    }

    public List<UserAccount> findUserAccountEntities(int maxResults, int firstResult) {
        return findUserAccountEntities(false, maxResults, firstResult);
    }

    private List<UserAccount> findUserAccountEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(UserAccount.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public UserAccount findUserAccount(Integer id) {
        return em.find(UserAccount.class, id);
    }

    public int getUserAccountCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<UserAccount> rt = cq.from(UserAccount.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public void delete(String email) throws NonexistentEntityException {
        Integer id = getAccountId(email);
        destroy(id);
    }

    private Integer getAccountId(String email) {
        Query q = em.createNamedQuery("UserAccount.findByEmail", UserAccount.class);
        q.setParameter("email", email);

        UserAccount account = (UserAccount) q.getSingleResult();

        if (account
                == null) {
            return null;
        } else {
            return account.getId();
        }
    }

}
