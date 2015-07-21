/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.persistence;

import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class AccountNGTest {

    public AccountNGTest() {
    }

    /**
     * Test of getEmail method, of class Account.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Integer id = 1;
        Integer id2 = 2;
        Account instance = new Account(id, "email", "password");
        assertEquals(instance.getId(), id);
        instance.setId(id2);
        assertEquals(instance.getId(), id2);
    }

    /**
     * Test of setEmail method, of class Account.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        testGetId();
    }

    /**
     * Test of getEmail method, of class Account.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String email = "email";
        String email2 = "email2";
        Account instance = new Account(1, email, "password");
        assertEquals(instance.getEmail(), email);
        instance.setEmail(email2);
        assertEquals(instance.getEmail(), email2);
    }

    /**
     * Test of setEmail method, of class Account.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        testGetEmail();
    }

    /**
     * Test of getPassword method, of class Account.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String password = "password";
        Account instance = new Account();
        instance.setPassword(password);
        assertEquals(instance.getPassword(), password);
    }

    /**
     * Test of setPassword method, of class Account.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        testGetPassword();
    }

    /**
     * Test user accounts have same hash.
     *
     * @param a1 A user account
     * @param a2 Another user account
     */
    @Test(dataProvider = "equality")
    public void testHash(Account a1, Account a2) {
        assertEquals(a1.hashCode(), a2.hashCode());
    }

    /**
     * Test user accounts are equal.
     *
     * @param a1 A user account
     * @param a2 Another user account
     */
    @Test(dataProvider = "equality")
    public void testEquals(Account a1, Account a2) {
        assertEquals(a1.hashCode(), a2.hashCode());
    }

    /**
     * Test user accounts are not equals.
     *
     * @param a1 A user account
     * @param a2 Another user account
     */
    @Test(dataProvider = "non-equality")
    public void testNotEquals(Account a1, Object a2) {
        assertFalse(a1.equals(a2));
    }

    @DataProvider(name = "non-equality")
    public Object[][] getEqualityNegativeData() {
        Account a1 = new Account(1, "username1", "password1");
        Account a2 = new Account(2, "username2", "password2");
        Account a3 = new Account(3, "username1", "password1");
        Account a4 = new Account(4, "username2", "password2");
        Account a5 = null;

        Object[][] data = new Object[][]{
            {a1, a2},
            {a1, a3},
            {a1, a4},
            {a1, a5},
            {a2, a1},
            {a2, a3},
            {a2, a4},
            {a2, a5},
            {a3, a1},
            {a3, a2},
            {a3, a4},
            {a3, a5},
            {a4, a1},
            {a4, a2},
            {a4, a3},
            {a4, a5}
        };
        return data;
    }

    /**
     * Test user accounts are not equals.
     *
     * @param a1 A user account
     * @param a2 Another user account
     */
    @Test(dataProvider = "equality")
    public void testEquals(Account a1, Object a2) {
        assertTrue(a1.equals(a2));
    }

    @DataProvider(name = "equality")
    public Object[][] getEqualityPositiveData() {
        Account a1 = new Account(1, "username", "password");
        Account a2 = new Account(1, "username", "password");
        Account a3 = new Account(1, "username", "password");

        Object[][] data = new Object[][]{
            {a1, a1},
            {a2, a2},
            {a1, a2},
            {a1, a3},
            {a2, a3},
            {a2, a1},
            {a3, a1},
            {a3, a2},
            {a3, a3}
        };
        return data;
    }

}
