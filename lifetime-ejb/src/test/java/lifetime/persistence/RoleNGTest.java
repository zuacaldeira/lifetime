/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.persistence;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class RoleNGTest {

    public RoleNGTest() {
    }

    /**
     * Test of getId method, of class Role. Check id is properly initialized by
     * all the constructors and setters.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        // Default consructor
        Role role = new Role();
        Assert.assertNull(role.getId());
        // Unary constructor with null id
        role = new Role(null);
        Assert.assertNull(role.getId());
        // Unary constructor with non null id
        role = new Role(Integer.MAX_VALUE);
        Assert.assertEquals(role.getId(), (Integer) Integer.MAX_VALUE);
        // Setter
        role.setId(10);
        Assert.assertEquals(role.getId(), new Integer(10));        
    }

    /**
     * Test of setId method, of class Role.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        // A random positive integer
        Integer x = getRandomInteger();
        // A sample null value role
        Role role = new Role();
        // Set the id
        role.setId(x);
        // And should get the same value
        Assert.assertEquals(role.getId(), x);
    }

    /**
     * Test of getName method, of class Role.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        // A random positive integer
        Integer x = getRandomInteger();
        // A random positive integer
        String n = "name";
        // Default consructor
        Role role = new Role();
        Assert.assertNull(role.getName());
        // Binary constructor with null name
        role = new Role(null, null);
        Assert.assertNull(role.getName());
        // Binaryconstructor with non null id
        role = new Role(x, n);
        Assert.assertEquals(role.getName(), n);
        // Setter
        role.setName(n);
        Assert.assertEquals(role.getName(), n);
    }

    /**
     * Test of setName method, of class Role.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        testGetName();
    }

    /**
     * Test of hashCode method, of class Role.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Integer x = getRandomInteger();
        String name = "name";
        Role r1 = new Role(x, name);
        Role r2 = new Role(x, name);
        Role r3 = new Role(x, name+name);
        Assert.assertEquals(r1.hashCode(), r2.hashCode());
        Assert.assertNotEquals(r1.hashCode(), r3.hashCode());
        Assert.assertNotEquals(r2.hashCode(), r3.hashCode());
    }

    /**
     * Test of equals method, of class Role.
     * @param r1
     * @param r2
     */
    @Test(dataProvider = "equals")
    public void testEquals(Role r1, Role r2) {
        System.out.println("equals");
        Assert.assertTrue(r1.equals(r1));
        Assert.assertTrue(r1.equals(r2));
        Assert.assertTrue(r2.equals(r1));
        Assert.assertEquals(r1.hashCode(), r2.hashCode());
    }

    /**
     * Test of equals method, of class Role.
     * @param r1
     * @param r2
     */
    @Test(dataProvider = "not-equals")
    public void testNotEquals(Role r1, Role r2) {
        System.out.println("equals");
        Assert.assertFalse(r1.equals(r1));
        Assert.assertFalse(r1.equals(r2));
        Assert.assertFalse(r2.equals(r1));
    }

    /**
     * Test of toString method, of class Role.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Role role = new Role(getRandomInteger(), "name");
        Assert.assertNotNull(role.toString());
    }

    private Integer getRandomInteger() {
        return (Integer) Math.round((float) Math.random()*Integer.MAX_VALUE);
    }
    
    
    @DataProvider(name = "equals")
    private Object[][] getEqualsTestData() {
        String name = "name";
        Integer x = getRandomInteger();
        Role r1 = new Role(x, name);
        Role r2 = new Role(x, name);
        Role r3 = new Role(x, name);
        return new Object[][]{
            {r1, r1},
            {r1, r2},
            {r1, r3},
            {r2, r3}
        };
    }

    @DataProvider(name = "not-equals")
    private Object[][] getNotEqualsTestData() {
        Integer x1 = getRandomInteger();
        Integer x2 = getRandomInteger();
        String n1 = "name1";
        String n2 = "name2";
        Role r1 = new Role(x1, n1);
        Role r2 = new Role(x2, n2);
        Role r3 = null;
        return new Object[][]{
            {r1, r2},
            {r1, r3},
            {r2, r3},
            {r1, ""}
        };
    }
}
