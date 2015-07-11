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
        LifetimeUser instance = new LifetimeUser(null);
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(result, expResult);
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
        LifetimeUser instance = new LifetimeUser(null);
        assertNull(instance.getId());
        instance.setId(id);
        assertEquals(instance.getId(), id);
    }

    /**
     * Test of getFirstName method, of class LifetimeUser.
     *
     * @param firstname A test first name
     */
    @org.testng.annotations.Test(dataProvider = "firstNameProvider")
    public void testGetFirstNames(String firstname) {
        System.out.println("getFirstname");
        LifetimeUser instance = new LifetimeUser(null);
        assertNull(instance.getFirstName());
        instance.setFirstName(firstname);
        assertEquals(instance.getFirstName(), firstname);

    }

    /**
     * Test of setFirstName method, of class LifetimeUser.
     *
     * @param firstname A test first name
     */
    @org.testng.annotations.Test(dataProvider = "firstNameProvider")
    public void testSetFirstname(String firstname) {
        System.out.println("setFirstname");
        LifetimeUser instance = new LifetimeUser(null);
        assertNull(instance.getFirstName());
        instance.setFirstName(firstname);
        assertEquals(instance.getFirstName(), firstname);
    }

    /**
     * Test of getLastName method, of class LifetimeUser.
     *
     * @param lastname A test last name
     */
    @org.testng.annotations.Test(dataProvider = "lastNameProvider")
    public void testGetLastname(String lastname) {
        System.out.println("getLastname");
        LifetimeUser instance = new LifetimeUser(null);
        assertNull(instance.getFirstName());
        instance.setLastName(lastname);
        assertEquals(instance.getLastName(), lastname);
    }

    /**
     * Test of setLastName method, of class LifetimeUser.
     *
     * @param lastname A test last name
     */
    @org.testng.annotations.Test(dataProvider = "lastNameProvider")
    public void testSetLastname(String lastname) {
        System.out.println("setLastname");
        LifetimeUser instance = new LifetimeUser(null);
        assertNull(instance.getFirstName());
        instance.setLastName(lastname);
        assertEquals(instance.getLastName(), lastname);
    }

    /**
     * Test of getBirthdate method, of class LifetimeUser.
     *
     * @param birthDate A test birth date
     */
    @org.testng.annotations.Test(dataProvider = "birthDateProvider")
    public void testGetBirthdate(Date birthDate) {
        System.out.println("getBirthdate");
        LifetimeUser instance = new LifetimeUser(null);
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
        LifetimeUser instance = new LifetimeUser(null);
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
        LifetimeUser instance = new LifetimeUser(null);
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
        LifetimeUser instance = new LifetimeUser(null);
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
        LifetimeUser instance = new LifetimeUser(null);
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
        LifetimeUser instance = new LifetimeUser(null);
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
        LifetimeUser instance = new LifetimeUser(null);
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
        LifetimeUser instance = new LifetimeUser(null);
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
        LifetimeUser instance = new LifetimeUser(null);
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
        LifetimeUser instance = new LifetimeUser(null);
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
        LifetimeUser instance = new LifetimeUser(null);
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
        LifetimeUser instance = new LifetimeUser(null);
        assertFalse(instance.getIsConfirmed());
        instance.setIsConfirmed(!instance.getIsConfirmed());
        assertTrue(instance.getIsConfirmed());
        instance.setIsConfirmed(!instance.getIsConfirmed());
        assertFalse(instance.getIsConfirmed());
    }

    @DataProvider(name = "firstNameProvider")
    public Object[][] provideFirstNames() {
        Object[][] data = new Object[][]{
            {"Alexandre"},
            {"Pedro"},
            {"João"}
        };
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

}
