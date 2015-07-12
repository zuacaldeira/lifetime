/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.persistence;

import java.util.Calendar;
import java.util.Date;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class LifetimeUserNGTest {

    public LifetimeUserNGTest() {
    }

    /**
     * Test of getId method, of class LifetimeUser.
     *
     * @param id A test user id
     */
    @org.testng.annotations.Test(dataProvider = "idProvider")
    public void testGetId(Integer id) {
        System.out.println("getId");
        LifetimeUser instance = new LifetimeUser();
        instance.setId(id);
        Integer result = instance.getId();
        assertEquals(result, id);
    }

    /**
     * Test of setId method, of class LifetimeUser. Ids are provided by a data
     * provider.
     *
     * @param id A test user id
     */
    @org.testng.annotations.Test(dataProvider = "idProvider")
    public void testSetId(Integer id) {
        System.out.println("setId");
        LifetimeUser instance = new LifetimeUser();
        assertNull(instance.getId());
        instance.setId(id);
        assertEquals(instance.getId(), id);
    }

    /**
     * Test of getFirstName method, of class LifetimeUser.
     *
     * @param id
     * @param firstname A test first name
     * @param lastname
     * @param motherLanguage
     * @param username
     * @param birthDate
     * @param birthPlace
     */
    @org.testng.annotations.Test(dataProvider = "userProvider")
    public void testGetFirstNames(Integer id, String firstname, String lastname, String username, Date birthDate, String birthPlace, String motherLanguage) {
        System.out.println("getFirstname");
        LifetimeUser instance = new LifetimeUser(id, firstname, lastname, username, birthDate, birthPlace, motherLanguage);
        assertEquals(instance.getFirstName(), firstname);

    }

    /**
     * Test of setFirstName method, of class LifetimeUser.
     *
     * @param id
     * @param firstname A test first name
     * @param lastname
     * @param motherLanguage
     * @param username
     * @param birthDate
     * @param birthPlace
     */
    @org.testng.annotations.Test(dataProvider = "userProvider")
    public void testSetFirstname(Integer id, String firstname, String lastname, String username, Date birthDate, String birthPlace, String motherLanguage) {
        System.out.println("setFirstname");
        String newFirstName = "a new firts name";
        LifetimeUser instance = new LifetimeUser(id, firstname, lastname, username, birthDate, birthPlace, motherLanguage);
        instance.setFirstName(newFirstName);
        assertEquals(instance.getFirstName(), newFirstName);
    }

    /**
     * Test of getLastName method, of class LifetimeUser.
     *
     * @param id
     * @param firstname A test first name
     * @param lastname
     * @param motherLanguage
     * @param username
     * @param birthDate
     * @param birthPlace
     */
    @org.testng.annotations.Test(dataProvider = "userProvider")
    public void testGetLastname(Integer id, String firstname, String lastname, String username, Date birthDate, String birthPlace, String motherLanguage) {
        System.out.println("getLastname");
        LifetimeUser instance = new LifetimeUser(id, firstname, lastname, username, birthDate, birthPlace, motherLanguage);
        assertEquals(instance.getLastName(), lastname);
    }

    /**
     * Test of setLastName method, of class LifetimeUser.
     *
     * @param id
     * @param firstname A test first name
     * @param lastname
     * @param motherLanguage
     * @param username
     * @param birthDate
     * @param birthPlace
     *
     */
    @org.testng.annotations.Test(dataProvider = "userProvider")
    public void testSetLastname(Integer id, String firstname, String lastname, String username, Date birthDate, String birthPlace, String motherLanguage) {
        System.out.println("setLastname");
        LifetimeUser instance = new LifetimeUser(id, firstname, lastname, username, birthDate, birthPlace, motherLanguage);
        assertEquals(instance.getLastName(), lastname);
        String newLastName = "new last name";
        instance.setLastName(newLastName);
        assertEquals(instance.getLastName(), newLastName);
    }

    /**
     * Test of getBirthdate method, of class LifetimeUser.
     *
     * @param birthDate A test birth date
     */
    @org.testng.annotations.Test(dataProvider = "birthDateProvider")
    public void testGetBirthdate(Date birthDate) {
        System.out.println("getBirthdate");
        LifetimeUser instance = new LifetimeUser();
        assertNull(instance.getBirthDate());
        instance.setBirthDate(birthDate);
        assertEquals(instance.getBirthDate(), birthDate);
    }

    /**
     * Test of setBirthdate method, of class LifetimeUser.
     *
     * @param birthDate A test birth date
     */
    @org.testng.annotations.Test(dataProvider = "birthDateProvider")
    public void testSetBirthdate(Date birthDate) {
        System.out.println("setBirthdate");
        LifetimeUser instance = new LifetimeUser();
        assertNull(instance.getBirthDate());
        instance.setBirthDate(birthDate);
        assertEquals(instance.getBirthDate(), birthDate);
    }

    /**
     * Test of getBirthplace method, of class LifetimeUser.
     *
     * @param birthPlace A test birth date
     */
    @org.testng.annotations.Test(dataProvider = "birthPlaceProvider")
    public void testGetBirthplace(String birthPlace) {
        System.out.println("getBirthplace");
        LifetimeUser instance = new LifetimeUser();
        assertNull(instance.getBirthPlace());
        instance.setBirthPlace(birthPlace);
        assertEquals(instance.getBirthPlace(), birthPlace);
    }

    /**
     * Test of setBirthplace method, of class LifetimeUser.
     *
     * @param birthPlace A test birth date
     */
    @org.testng.annotations.Test(dataProvider = "birthPlaceProvider")
    public void testSetBirthplace(String birthPlace) {
        System.out.println("setBirthplace");
        LifetimeUser instance = new LifetimeUser();
        assertNull(instance.getBirthPlace());
        instance.setBirthPlace(birthPlace);
        assertEquals(instance.getBirthPlace(), birthPlace);
    }

    /**
     * Test of getUsername method, of class LifetimeUser.
     *
     * @param username A test username
     */
    @org.testng.annotations.Test(dataProvider = "usernameProvider")
    public void testGetUsername(String username) {
        System.out.println("getUsername");
        LifetimeUser instance = new LifetimeUser();
        assertNull(instance.getUsername());
        instance.setUsername(username);
        assertEquals(instance.getUsername(), username);
    }

    /**
     * Test of setUsername method, of class LifetimeUser.
     *
     * @param username A test username
     */
    @org.testng.annotations.Test(dataProvider = "usernameProvider")
    public void testSetUsername(String username) {
        System.out.println("setUsername");
        LifetimeUser instance = new LifetimeUser();
        assertNull(instance.getUsername());
        instance.setUsername(username);
        assertEquals(instance.getUsername(), username);
    }

    /**
     * Test of getMotherLanguage method, of class LifetimeUser.
     *
     * @param motherLanguage Test mother language
     */
    @org.testng.annotations.Test(dataProvider = "languageProvider")
    public void testGetMotherLanguage(String motherLanguage) {
        System.out.println("getMotherLanguage");
        LifetimeUser instance = new LifetimeUser();
        assertNull(instance.getMotherLanguage());
        instance.setMotherLanguage(motherLanguage);
        assertEquals(instance.getMotherLanguage(), motherLanguage);
    }

    /**
     * Test of setMotherLanguage method, of class LifetimeUser.
     *
     * @param motherLanguage Test mother language
     */
    @org.testng.annotations.Test(dataProvider = "languageProvider")
    public void testSetMotherLanguage(String motherLanguage) {
        System.out.println("setMotherLanguage");
        LifetimeUser instance = new LifetimeUser();
        assertNull(instance.getMotherLanguage());
        instance.setMotherLanguage(motherLanguage);
        assertEquals(instance.getMotherLanguage(), motherLanguage);
    }

    /**
     * Test of getIsLoggedIn method, of class LifetimeUser.
     */
    @org.testng.annotations.Test
    public void testGetIsLoggedIn() {
        System.out.println("getIsLoggedIn");
        LifetimeUser instance = new LifetimeUser();
        assertFalse(instance.getIsLoggedIn());
        instance.setIsLoggedIn(!instance.getIsLoggedIn());
        assertTrue(instance.getIsLoggedIn());
        instance.setIsLoggedIn(!instance.getIsLoggedIn());
        assertFalse(instance.getIsLoggedIn());
    }

    /**
     * Test of setIsLoggedIn method, of class LifetimeUser.
     */
    @org.testng.annotations.Test
    public void testSetIsLoggedIn() {
        System.out.println("setIsLoggedIn");
        LifetimeUser instance = new LifetimeUser();
        assertFalse(instance.getIsLoggedIn());
        instance.setIsLoggedIn(!instance.getIsLoggedIn());
        assertTrue(instance.getIsLoggedIn());
        instance.setIsLoggedIn(!instance.getIsLoggedIn());
        assertFalse(instance.getIsLoggedIn());
    }

    /**
     * Test of getIsConfirmed method, of class LifetimeUser.
     */
    @org.testng.annotations.Test
    public void testGetIsConfirmed() {
        System.out.println("getIsConfirmed");
        LifetimeUser instance = new LifetimeUser();
        assertFalse(instance.getIsConfirmed());
        instance.setIsConfirmed(!instance.getIsConfirmed());
        assertTrue(instance.getIsConfirmed());
        instance.setIsConfirmed(!instance.getIsConfirmed());
        assertFalse(instance.getIsConfirmed());
    }

    /**
     * Test of setIsConfirmed method, of class LifetimeUser.
     */
    @org.testng.annotations.Test
    public void testSetIsConfirmed() {
        System.out.println("setIsConfirmed");
        LifetimeUser instance = new LifetimeUser();
        assertFalse(instance.getIsConfirmed());
        instance.setIsConfirmed(!instance.getIsConfirmed());
        assertTrue(instance.getIsConfirmed());
        instance.setIsConfirmed(!instance.getIsConfirmed());
        assertFalse(instance.getIsConfirmed());
    }

    /**
     * Test of setIsConfirmed method, of class LifetimeUser.
     *
     * @param aUser the user we are comparing
     * @param another the user we are comparing against
     */
    @org.testng.annotations.Test(dataProvider = "equalsProvider")
    public void testEquals(LifetimeUser aUser, Object another) {
        System.out.println("equals");
        assertTrue(aUser.equals(another));
    }

    /**
     * Test of notEquals method, of class LifetimeUser.
     *
     * @param aUser
     * @param another
     */
    @org.testng.annotations.Test(dataProvider = "nonEqualsProvider")
    public void testNotEquals(LifetimeUser aUser, Object another) {
        System.out.println("non-equals");
        assertFalse(aUser.equals(another));
    }

    /**
     * Test of setIsConfirmed method, of class LifetimeUser.
     */
    @org.testng.annotations.Test
    public void testEqualsWithIncompatibleObject() {
        System.out.println("equals");
        LifetimeUser instance1 = new LifetimeUser();
        SecurityRole instance2 = new SecurityRole();
        assertFalse(instance1.equals(instance2));
    }

    /**
     * Test hash code.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        LifetimeUser instance1 = new LifetimeUser();
        LifetimeUser instance2 = new LifetimeUser();
        assertEquals(instance1.hashCode(), instance2.hashCode());
    }

    /**
     * Test toString.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LifetimeUser instance1 = new LifetimeUser();
        LifetimeUser instance2 = new LifetimeUser();
        assertEquals(instance1.toString(), instance2.toString());
    }

    @DataProvider(name = "userProvider")
    public Object[][] provideUserData() {
        Object[][] data = new Object[][]{
            {1, "firstname1", "lastname1", "username1", new Date(), "birthPlace", "en"},
            {2, "firstname2", "lastname2", "username2", new Date(), "birthPlace", "en"},
            {3, "firstname3", "lastname3", "username3", new Date(), "birthPlace", "en"}};
        return data;
    }

    @DataProvider(name = "lastNameProvider")
    public Object[][] provideLastNames() {
        Object[][] data = new Object[][]{
            {"Caldeira"},
            {"dos Santos"},
            {"Oliveira"}
        };
        return data;
    }

    @DataProvider(name = "idProvider")
    public Object[][] provideIds() {
        Object[][] data = new Object[][]{
            {0},
            {1},
            {Integer.MAX_VALUE}
        };
        return data;
    }

    @DataProvider(name = "birthDateProvider")
    public Object[][] provideBirthDates() {
        Object[][] data = new Object[][]{
            {new Date()},
            {Calendar.getInstance().getTime()}
        };
        return data;
    }

    @DataProvider(name = "birthPlaceProvider")
    public Object[][] provideBirthPlaces() {
        Object[][] data = new Object[][]{
            {"Piri, Angola"},
            {"Lisboa, Portugal"},
            {"Berlin, Deutschland"},
            {"Berlin, Germany"}
        };
        return data;
    }

    @DataProvider(name = "languageProvider")
    public Object[][] provideMotherLanguages() {
        Object[][] data = new Object[][]{
            {"pt"},
            {"en"},
            {"de"}
        };
        return data;
    }

    @DataProvider(name = "usernameProvider")
    public Object[][] provideUsernames() {
        Object[][] data = new Object[][]{
            {"username"},
            {"heteronym"},
            {"anotherHeteronym"}
        };
        return data;
    }

    @DataProvider(name = "nonEqualsProvider")
    public Object[][] provideNonEqualsData() {
        Date d = new Date();
        Object[][] data = new Object[][]{
            {new LifetimeUser(null, "Alexandre", "Zua Caldeira", "username", d, "birthPlace", "en"),
                new LifetimeUser(1, "Alexandre", "Zua Caldeira", "username", d, "birthPlace", "en")},
            {new LifetimeUser(1, "Alexandre", "Zua Caldeira", "username", d, "birthPlace", "en"),
                new LifetimeUser(null, "Alexandre", "Zua Caldeira", "username", d, "birthPlace", "en")},
            {new LifetimeUser(null, "Alexandre", "Zua Caldeira", "username", d, "birthPlace", "en"),
                new LifetimeUser(null, "Alexandre", "Zua Caldeira", null, d, "birthPlace", "en")},
            {new LifetimeUser(null, "Alexandre", "Zua Caldeira", "username", d, "birthPlace", "en"),
                new LifetimeUser(null, "Alexandre", "Zua Caldeira", "username", new Date(1000000), "birthPlace", "en")},
            {new LifetimeUser(null, "Alexandre", "Zua Caldeira", "username", d, "birthPlace", "en"),
                new LifetimeUser(null, "Alexandre", "Zua Caldeira", "username", d, null, "en")},
            {new LifetimeUser(null, "Alexandre", "Zua Caldeira", "username", d, "birthPlace", "en"),
                new LifetimeUser(null, "Alexandre", "Zua Caldeira", "username", d, "birthPlace", null)},
            {new LifetimeUser(null, "Alexandre", "Zua Caldeira", "username", d, "birthPlace", "en"),
                null},
            {new LifetimeUser(null, "Alexandre", "Zua Caldeira", "username", d, "birthPlace", "en"),
                new UserAccount(1, "gmal", "pass")}
        };
        return data;
    }

    @DataProvider(name = "equalsProvider")
    public Object[][] provideEqualsData() {
        Date d = new Date();
        Object[][] data = new Object[][]{
            {new LifetimeUser(1, "Alexandre", "Zua Caldeira", "username", d, "birthPlace", "en"),
                new LifetimeUser(1, "Alexandre", "Zua Caldeira", "username", d, "birthPlace", "en")},
            {new LifetimeUser(1, null, "Zua Caldeira", "username", d, "birthPlace", "en"),
                new LifetimeUser(1, null, "Zua Caldeira", "username", d, "birthPlace", "en")},
            {new LifetimeUser(1, "Alexandre", null, "username", d, "birthPlace", "en"),
                new LifetimeUser(1, "Alexandre", null, "username", d, "birthPlace", "en")},
            {new LifetimeUser(1, "Alexandre", "Zua Caldeira", null, d, "birthPlace", "en"),
                new LifetimeUser(1, "Alexandre", "Zua Caldeira", null, d, "birthPlace", "en")}
        };
        return data;
    }
}
