/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import lifetime.persistence.LifetimeUser;

/**
 *
 * @author lifetime
 */
@Stateless
@LocalBean
public class TodoManager {

    @EJB
    private LifetimeService service;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Schedule(minute = "*")
    public void updateUserTodos() {
        List<LifetimeUser> users = service.getAllUsers();
        for (LifetimeUser u : users) {
            System.out.println("********** " + u);
            List<Todo> todos = service.getAllTodos();
            for (Todo t : todos) {
                System.out.println("\t********** " + t);
                UserTodo userTodo = service.getUserTodo(u.getId(), t.getId());
                System.out.println("\t********** " + userTodo);
                if (userTodo == null) {
                    userTodo = new UserTodo(null, u.getId(), t.getId());
                    System.out.println("\t********** New " + userTodo);
                    service.addUserTodo(userTodo);
                }
            }
        }
    }
}