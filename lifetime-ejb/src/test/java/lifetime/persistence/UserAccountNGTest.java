/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.persistence;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class UserAccountNGTest {
    
    public UserAccountNGTest() {
    }

    /**
     * Test of getEmail method, of class UserAccount.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String email = "email";
        UserAccount instance = new UserAccount(1);
        assertNull(instance.getEmail());
        instance.setEmail(email);
        assertEquals(instance.getEmail(), email);
    }

    /**
     * Test of setEmail method, of class UserAccount.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        testGetEmail();
    }

    /**
     * Test of getPassword method, of class UserAccount.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String password = "password";
        UserAccount instance = new UserAccount();
        assertNull(instance.getPassword());
        instance.setPassword(password);
        assertEquals(instance.getPassword(), password);
    }

    /**
     * Test of setPassword method, of class UserAccount.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        testGetPassword();
    }

    /**
     * Test of getUser method, of class UserAccount.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        LifetimeUser user = new LifetimeUser();
        UserAccount instance = new UserAccount();
        assertNull(instance.getLifetimeUser());
        instance.setLifetimeUser(user);
        assertEquals(instance.getLifetimeUser(), user);
    }

    /**
     * Test of setUser method, of class UserAccount.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        testGetUser();
    }
    
}
