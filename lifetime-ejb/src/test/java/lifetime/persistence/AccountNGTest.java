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
public class AccountNGTest {
    
    public AccountNGTest() {
    }

    /**
     * Test of getId method, of class Account.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Integer id = null;
        Account instance = new AccountImpl();
        instance.setId(id);
        assertEquals(instance.getId(), id);
    }

    /**
     * Test of setId method, of class Account.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        testGetId();
    }

    /**
     * Test of hashCode method, of class Account.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Integer id = 2;
        Account instance1 = new AccountImpl(id);
        Account instance2 = new AccountImpl(id);
        assertEquals(instance1.hashCode(), instance2.hashCode());
    }

    /**
     * Test of equals method, of class Account.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Integer id = 2;
        Account instance1 = new AccountImpl(id);
        Account instance2 = new AccountImpl(id);
        assertTrue(instance1.equals(instance2));
    }

    /**
     * Test of equals method, of class Account.
     */
    @Test
    public void testNotEquals() {
        System.out.println("equals");
        Integer id = 2;
        Account instance1 = new AccountImpl(id);
        Account instance2 = new AccountImpl((int) Math.round((float) Integer.MAX_VALUE*Math.random()));
        assertFalse(instance1.equals(instance2));
    }

        /**
     * Test of equals method, of class Account.
     */
    @Test
    public void testEqualsWithIncompatibleObject() {
        System.out.println("equals");
        Integer id = 2;
        Account instance1 = new AccountImpl(id);
        UserRole instance2 = new UserRole();
        assertFalse(instance1.equals(instance2));
    }

    /**
     * Test of toString method, of class Account.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Integer id = 2;
        Account instance1 = new AccountImpl(id);
        Account instance2 = new AccountImpl(id);
        assertEquals(instance1.toString(), instance2.toString());
    }

    public class AccountImpl extends Account {

        private AccountImpl(Integer id) {
            super(id);
        }
        private AccountImpl() {
        }
    }
    
}
