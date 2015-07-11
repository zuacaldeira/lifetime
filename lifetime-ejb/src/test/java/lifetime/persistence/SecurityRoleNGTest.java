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
public class SecurityRoleNGTest {

    public SecurityRoleNGTest() {
    }

    /**
     * Test of getRoleName method, of class SecurityRole.
     */
    @Test
    public void testGetRoleName() {
        System.out.println("getRoleName");
        /* 
         * Creates a new security role and check that it has the rolename 
         * initiated with null values.
         */
        SecurityRole role = new SecurityRole();
        assertNull(role.getRoleName());

        /*
         * Check updates to the security role name
         */
        role.setRoleName(Roles.USER);
        assertEquals(role.getRoleName(), Roles.USER);
    }

    /**
     * Test of setRoleName method, of class SecurityRole.
     */
    @Test
    public void testSetRoleName() {
        System.out.println("setRoleName");
        testGetRoleName();
    }

    /**
     * Test of getId method, of class SecurityRole.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Integer id = 1;
        /* 
         * Creates a new security role and check that it has both
         * the id and the rolename initiated with null values.
         */
        SecurityRole role = new SecurityRole();
        assertNull(role.getId());

        /*
         * Check updates to the security id
         */
        role.setId(id);
        assertEquals(role.getId(), id);
    }

    /**
     * Test of setId method, of class SecurityRole.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        testGetId();
    }

    /**
     * Test of hashCode method, of class SecurityRole.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");

        //
        Integer id = 1;
        String roleName = Roles.USER;

        // First role
        SecurityRole role = new SecurityRole(id, roleName);
        role.setRoleName(Roles.USER);

        // Second role
        SecurityRole role2 = new SecurityRole(id, roleName);
        role2.setRoleName(Roles.USER);

        // Check for equality
        assertEquals(role.hashCode(), role2.hashCode());
    }

    /**
     * Test of equals method, of class SecurityRole.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Integer id = 1;
        String roleName = Roles.USER;

        // First role
        SecurityRole role = new SecurityRole(id, roleName);
        role.setRoleName(Roles.USER);

        // Second role
        SecurityRole role2 = new SecurityRole(id, roleName);
        role2.setRoleName(Roles.USER);

        // Check for equality
        assertEquals(role, role2);
    }

}
