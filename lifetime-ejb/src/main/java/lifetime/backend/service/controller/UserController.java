/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service.controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lifetime.backend.persistence.User;

/**
 *
 * @author <a href="mailto:zuacaldeira@gmail.com">Alexandre Caldeira</a>
 */
@Stateless
public class UserController extends CrudController<User> {

    @EJB
    private AccountController accountController;

    /**
     * Persistence Context.
     */
    @PersistenceContext(unitName = "lifetimePU")
    private EntityManager em;

    @Override
    public User read(String username) {
        if (accountController.hasAccount(username)) {
            return accountController.read(username).getUser();
        }
        return null;
    }

    @Override
    public boolean create(User t) {
        em.persist(t);
        return true;
    }

    @Override
    public boolean update(User t) {
        return em.merge(t) != null;
    }

    @Override
    public boolean delete(String username) {
        if (accountController.hasAccount(username)) {
            em.remove(read(username));
        }
        return true;
    }

}
