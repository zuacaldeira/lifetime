/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.persistence;

import lifetime.service.Roles;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class UserRoleNGTest {

    public UserRoleNGTest() {
    }

    /**
     * Test of getRoleName method, of class UserRole.
     */
    @Test
    public void testGetRoleName() {
        System.out.println("getRoleName");
        UserRole instance = new UserRole();
        assertNull(instance.getRoleName());
        instance.setRoleName(Roles.USER);
        assertEquals(instance.getRoleName(), Roles.USER);
    }

    /**
     * Test of setRoleName method, of class UserRole.
     */
    @Test
    public void testSetRoleName() {
        System.out.println("setRoleName");
        testGetRoleName();
    }

    /**
     * Test of getUsername method, of class UserRole.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        UserRole instance = new UserRole();
        assertNull(instance.getUsername());
        instance.setUsername("new_username");
        assertEquals(instance.getUsername(), "new_username");        
    }

    /**
     * Test of setUsername method, of class UserRole.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        testGetUsername();
    }

    /**
     * Test of getId method, of class UserRole.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        UserRole instance = new UserRole();
        assertNull(instance.getId());
        instance.setId(1);
        assertEquals(instance.getId(), new Integer(1));        
    }

    /**
     * Test of setId method, of class UserRole.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        testGetId();
    }

    /**
     * Test of hashCode method, of class UserRole.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UserRole instance = new UserRole();
        UserRole instance2 = new UserRole();
        assertEquals(instance.hashCode(),instance2.hashCode());
    }

    /**
     * Test of equals method, of class UserRole.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        String username = "username";
        UserRole instance = new UserRole(null, username, Roles.USER);
        UserRole instance2 = new UserRole(null, username, Roles.USER);
        assertTrue(instance.equals(instance2));
    }

    /**
     * Test of equals method, of class UserRole.
     */
    @Test
    public void testNotEquals() {
        System.out.println("equals");
        String username1 = "username1";
        String username2 = "username2";
        UserRole instance = new UserRole(1, username1, Roles.USER);
        UserRole instance2 = new UserRole(2, username2, Roles.USER);
        assertFalse(instance.equals(instance2));
    }

    /**
     * Test of equals method, of class UserRole.
     */
    @Test
    public void testEqualsWithIncompatibleObject() {
        System.out.println("equals");
        String username = "username";
        UserRole instance = new UserRole(null, username, Roles.USER);
        LifetimeUser instance2 = new LifetimeUser();
        assertFalse(instance.equals(instance2));
    }

    /**
     * Test of toString method, of class UserRole.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String username = "username";
        UserRole instance = new UserRole(1, username, Roles.USER);
        UserRole instance2 = new UserRole(1, username, Roles.USER);
        assertEquals(instance.toString(),instance2.toString());
    }

}
