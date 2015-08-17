/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service.controller;

import java.util.Date;
import java.util.logging.Level;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import lifetime.TestConfig;
import lifetime.backend.persistence.User;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class UserControllerNGTestIT {

    private UserController userController;
    private Context context;

    @BeforeTest
    private void setUp() {
        context = TestConfig.getContainer().getContext();
        try {
            userController = (UserController) context.lookup("java:global/classes/UserController");
        } catch (NamingException ex) {
            java.util.logging.Logger.getLogger(AddressControllerNGTestIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UserControllerNGTestIT() {
    }

    /**
     * Test of create method, of class UserController.
     */
    @Test(groups = {"CREATE"})
    public void testCreate() throws Exception {
        System.out.println("create");
        assertTrue(userController.create(new User(null, "username", "lastname", new Date(), "birth place", "pt")));
    }

    /**
     * Test of read method, of class UserController.
     */
    @Test(groups = {"READ"}, dependsOnGroups = {"CREATE"})
    public void testRead() throws Exception {
        System.out.println("read");
        User user = userController.read("username");
    }

    /**
     * Test of update method, of class UserController.
     */
    @Test(groups = {"UPADTE"}, dependsOnGroups = {"CREATE", "READ"})
    public void testUpdate() throws Exception {
        System.out.println("update");
        User user = userController.read("username");
        user.setBirthPlace("UNKNOWN");
        assertTrue(userController.update(user));

    }

    /**
     * Test of delete method, of class UserController.
     */
    @Test(dependsOnGroups = {"CREATE", "READ", "UPDATE"})
    public void testDelete() throws Exception {
        System.out.println("delete");
        assertTrue(userController.delete("username"));
    }

}
