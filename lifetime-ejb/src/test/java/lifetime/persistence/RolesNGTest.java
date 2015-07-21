/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.persistence;

import lifetime.util.SecurityRole;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class RolesNGTest {

    public RolesNGTest() {
    }

    /**
     * Test of getRoleName method, of class Roles.
     */
    @Test
    public void testGetRoleName() {
        System.out.println("getRoleName");
        Roles instance = new Roles();
        assertNull(instance.getName());
        instance.setName(SecurityRole.USER.name());
        assertEquals(instance.getName(), SecurityRole.USER.name());
    }

    /**
     * Test of setRoleName method, of class Roles.
     */
    @Test
    public void testSetRoleName() {
        System.out.println("setRoleName");
        testGetRoleName();
    }


    /**
     * Test of getId method, of class Roles.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Roles instance = new Roles();
        assertNull(instance.getId());
        instance.setId(1);
        assertEquals(instance.getId(), new Integer(1));
    }

    /**
     * Test of setId method, of class Roles.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        testGetId();
    }

    /**
     * Test of hashCode method, of class Roles.
     *
     * @param role
     * @param role2
     */
    @Test(dataProvider = "equality")
    public void testHashCode(Roles role, Roles role2) {
        System.out.println("hashCode");
        assertEquals(role.hashCode(), role2.hashCode());
    }

    /**
     * Test of equals method, of class Roles.
     *
     * @param role
     * @param role2
     */
    @Test(dataProvider = "equality")
    public void testEquals(Roles role, Roles role2) {
        System.out.println("equals");
        assertTrue(role.equals(role2));
    }

    @DataProvider(name = "equality")
    public Object[][] provideEqualityData() {
        Object[][] data = new Object[][]{
            {new Roles(1, SecurityRole.USER.name()), new Roles(1, SecurityRole.USER.name())},
            {new Roles(2, SecurityRole.ADMIN.name()), new Roles(2, SecurityRole.ADMIN.name())}
        };

        return data;
    }

    /**
     * Test of equals method, of class Roles.
     *
     * @param role
     * @param role2
     */
    @Test(dataProvider = "inequality")
    public void testNotEquals(Roles role, Object role2) {
        System.out.println("!equals");
        assertFalse(role.equals(role2));
    }

    @DataProvider(name = "inequality")
    public Object[][] provideInequalityData() {
        Object[][] data = new Object[][]{
            {new Roles(1, SecurityRole.USER.name()), new Roles(1, SecurityRole.ADMIN.name())},
            {new Roles(1, SecurityRole.USER.name()), new Roles(1, SecurityRole.DEVELOPER.name())},
            {new Roles(1, SecurityRole.ADMIN.name()), new Roles(1, SecurityRole.DEVELOPER.name())},
            {new Roles(1, SecurityRole.USER.name()), null}
        };

        return data;
    }

    /**
     * Test of toString method, of class Roles.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Roles instance = new Roles(1, SecurityRole.USER.name());
        Roles instance2 = new Roles(1, SecurityRole.USER.name());
        assertEquals(instance.toString(), instance2.toString());
    }

}
