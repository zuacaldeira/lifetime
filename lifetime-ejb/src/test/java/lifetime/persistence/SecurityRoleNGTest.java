/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.persistence;

import lifetime.service.Roles;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
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
     *
     * @param role1
     * @param role2
     */
    @Test(dataProvider = "equality")
    public void testHashCode(SecurityRole role1, SecurityRole role2) {
        System.out.println("hashCode");
        // Check for equality
        assertEquals(role1.hashCode(), role2.hashCode());
    }

    /**
     * Test of equals method, of class SecurityRole.
     *
     * @param role1
     * @param role2
     */
    @Test(dataProvider = "equality")
    public void testEquals(SecurityRole role1, SecurityRole role2) {
        System.out.println("equals");
        assertTrue(role1.equals(role2));
    }

    @DataProvider(name = "equality")
    public Object[][] provideEqualityData() {
        Object[][] data = new Object[][]{
            {new SecurityRole(1, Roles.USER), new SecurityRole(1, Roles.USER)},
            {new SecurityRole(null, Roles.USER), new SecurityRole(null, Roles.USER)},
            {new SecurityRole(1, null), new SecurityRole(1, null)},
            {new SecurityRole(null, null), new SecurityRole(null, null)}
        };

        return data;
    }

    /**
     * Test of equals method, of class SecurityRole.
     *
     * @param role1
     * @param role2
     */
    @Test(dataProvider = "non-equality")
    public void testNotEquals(SecurityRole role1, Object role2) {
        System.out.println("equals");
        assertFalse(role1.equals(role2));
    }

    @DataProvider(name = "non-equality")
    public Object[][] provideNonEqualityData() {
        Object[][] data = new Object[][]{
            {new SecurityRole(1, Roles.USER), null},
            {new SecurityRole(1, Roles.USER), new SecurityRole(2, Roles.USER)},
            {new SecurityRole(1, Roles.USER), new SecurityRole(null, Roles.USER)},
            {new SecurityRole(1, Roles.USER), new SecurityRole(1, null)},
            {new SecurityRole(1, Roles.USER), new UserRole(1, "a", "b")}
        };

        return data;
    }

    /**
     * Test of toString method, of class SecurityRole.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Integer id = 1;
        String roleName = Roles.USER;

        // First role
        SecurityRole role = new SecurityRole(id, roleName);

        // Second role
        SecurityRole role2 = new SecurityRole(id, roleName);

        // Check for equality
        assertEquals(role.toString(), role2.toString());
    }
}
