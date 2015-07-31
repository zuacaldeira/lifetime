/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.persistence;

import java.util.Date;
import lifetime.service.SecurityRoles;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;
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
     * Test of getId method, of class Account.
     */
    public void testGetId() {
        Integer id = TestData.getRandomInteger();
        Account account = new Account();
        account.setId(id);
        Assert.assertEquals(account.getId(), id);
    }

    /**
     * Test of setId method, of class Account.
     */
    @Test
    public void testSetId() {
        testGetId();
    }

    /**
     * Test of getEmail method, of class Account.
     */
    @Test
    public void testGetEmail() {
        Integer id = TestData.getRandomInteger();
        String email = "email";
        Account account = new Account(id);
        account.setEmail(email);
        Assert.assertEquals(account.getEmail(), email);
    }

    /**
     * Test of setEmail method, of class Account.
     */
    @Test
    public void testSetEmail() {
        testGetEmail();
    }

    /**
     * Test of getPassword method, of class Account.
     */
    @Test
    public void testGetPassword() {
        Integer id = TestData.getRandomInteger();
        String password = "password";
        Account account = new Account(id, null, null);
        account.setPassword(password);
        Assert.assertEquals(account.getPassword(), password);
    }

    /**
     * Test of setPassword method, of class Account.
     */
    @Test
    public void testSetPassword() {
        testGetPassword();
    }

    /**
     * Test of getUser method, of class Account.
     */
    @Test
    public void testGetUser() {
        Integer id = TestData.getRandomInteger();
        User user = new User();
        Account account = new Account(id, null, null);
        account.setUser(user);
        Assert.assertEquals(account.getUser(), user);
    }

    /**
     * Test of setUser method, of class Account.
     */
    @Test
    public void testSetUser() {
        testGetUser();
    }

    /**
     * Test of hashCode method, of class Account.
     *
     * @param a1
     * @param a2
     */
    @Test(dataProvider = "equals")
    public void testHashCode(Account a1, Account a2) {
        Assert.assertEquals(a1.hashCode(), a2.hashCode());
    }

    /**
     * Test of equals method, of class Account.
     *
     * @param a1
     * @param a2
     */
    @Test(dataProvider = "equals")
    public void testEquals(Account a1, Account a2) {
        Assert.assertTrue(a1.equals(a2));
    }

    /**
     * Test of equals method, of class Account.
     *
     * @param a1
     * @param a2
     */
    @Test(dataProvider = "not-equals")
    public void testNotEquals(Account a1, Object a2) {
        Assert.assertFalse(a1.equals(a2));
    }

    /**
     * Test of toString method, of class Account.
     *
     * @param a
     */
    @Test(dataProvider = "positive")
    public void testToString(Account a) {
        Assert.assertNotNull(a.toString());
    }

    /**
     * DATA PROVIDERS.
     */
    /**
     * Positive data provider
     *
     * @return
     */
    @DataProvider(name = "equals")
    public Object[][] getEqualsData() {
        String username = "username";
        String password = "password";
        String firstname = "firstname";
        String lastname = "lastname";
        Date birthdate = new Date();
        String birthplace = "piri";
        String language = "pt";

        Account a1 = new Account(TestData.getRandomInteger(), username, password);
        User u1 = new User(TestData.getRandomInteger(), firstname, lastname, birthdate, birthplace, language);
        a1.setUser(u1);

        Account a2 = new Account(TestData.getRandomInteger(), username, password);
        User u2 = new User(TestData.getRandomInteger(), lastname, firstname, birthdate, birthplace, language);
        a2.setUser(u2);

        return new Object[][]{
            {a1, a1}, {a2, a2}, {new Account(1), new Account(1)}
        };
    }

    /**
     * Positive data provider
     *
     * @return
     */
    @DataProvider(name = "not-equals")
    public Object[][] getNotEqualsData() {
        String username = "username";
        String password = "password";
        String firstname = "firstname";
        String lastname = "lastname";
        Date birthdate = new Date();
        String birthplace = "piri";
        String language = "pt";

        Integer id = TestData.getRandomInteger();
        User u1 = new User(TestData.getRandomInteger(), firstname, lastname, birthdate, birthplace, language);
        User u2 = null;

        /*
         * a1-a3 fail to compare for distinct id, email and password
         */
        Account a11 = new Account(null, username, password);

        Account a12 = new Account(id, null, password);

        Account a13 = new Account(id, username, null);

        /*
         * A second null argument for clients of this method
         */
        Account a5 = null;

        /*
         * A non comparable object
         */
        Integer a6 = 1;

        return new Object[][]{
            {a11, a12}, {a12, a13}, {a11, a5}, {a11, a6}
        };
    }

    /**
     * Positive data provider
     *
     * @return
     */
    @DataProvider(name = "positive")
    public Object[][] getPositiveData() {
        String username = "username";
        String password = "password";
        String firstname = "firstname";
        String lastname = "lastname";
        Date birthdate = new Date();
        String birthplace = "piri";
        String language = "pt";

        Account a1 = new Account(TestData.getRandomInteger(), username, password);
        User u1 = new User(TestData.getRandomInteger(), firstname, lastname, birthdate, birthplace, language);
        a1.setUser(u1);

        Account a2 = new Account(TestData.getRandomInteger(), username, password);
        User u2 = new User(TestData.getRandomInteger(), lastname, firstname, birthdate, birthplace, language);
        a2.setUser(u2);

        return new Object[][]{
            {a1}, {a2}
        };
    }

    /**
     * Test of getRole method, of class Account.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        // Create account
        Account account = new Account();
        // Create and set account's role
        Role role = new Role(null, SecurityRoles.USER.name());
        account.setRole(role);
        // Assert the role is properly retrieved from the account
        Role result = account.getRole();
        assertEquals(result, role);
    }

    /**
     * Test of setRole method, of class Account.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        testGetRole();
    }

}
