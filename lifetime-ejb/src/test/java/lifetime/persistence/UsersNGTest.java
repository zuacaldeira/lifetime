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
public class UsersNGTest {

    public UsersNGTest() {
    }

    /**
     * Test of getId method, of class Users.
     *
     * @param id A test user id
     */
    @org.testng.annotations.Test(dataProvider = "idProvider")
    public void testGetId(Integer id) {
        System.out.println("getId");
        Users instance = new Users();
        instance.setId(id);
        Integer result = instance.getId();
        assertEquals(result, id);
    }

    /**
     * Test of setId method, of class Users. Ids are provided by a data provider.
     *
     * @param id A test user id
     */
    @org.testng.annotations.Test(dataProvider = "idProvider")
    public void testSetId(Integer id) {
        System.out.println("setId");
        Users instance = new Users();
        assertNull(instance.getId());
        instance.setId(id);
        assertEquals(instance.getId(), id);
    }

    /**
     * Test of getFirstName method, of class Users.
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
        String newFirstName = "a new firts name";

        Users instance = new Users(id, firstname, lastname, birthDate, birthPlace, motherLanguage);
        assertEquals(instance.getFirstnames(), firstname);

        instance.setFirstnames(newFirstName);
        assertEquals(instance.getFirstnames(), newFirstName);
    }

    /**
     * Test of setFirstName method, of class Users.
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
        testGetFirstNames(id, firstname, lastname, username, birthDate, birthPlace, motherLanguage);
    }

    /**
     * Test of getLastName method, of class Users.
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
        String newLastnames = "a new lastname";

        Users instance = new Users(id, firstname, lastname, birthDate, birthPlace, motherLanguage);
        assertEquals(instance.getLastnames(), lastname);

        instance.setLastnames(newLastnames);
        assertEquals(instance.getLastnames(), newLastnames);
    }

    /**
     * Test of setLastName method, of class Users.
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
        testGetLastname(id, firstname, lastname, username, birthDate, birthPlace, motherLanguage);
    }

    /**
     * Test of getBirthdate method, of class Users.
     *
     * @param birthDate A test birth date
     */
    @org.testng.annotations.Test(dataProvider = "userProvider")
    public void testGetBirthdate(Integer id, String firstname, String lastname, String username, Date birthDate, String birthPlace, String motherLanguage) {
        System.out.println("getBirthdate");
        Calendar cal = Calendar.getInstance();
        cal.set(1999, 00, 31);
        Date newBirthdate = cal.getTime();

        Users instance = new Users(id, firstname, lastname, birthDate, birthPlace, motherLanguage);
        assertEquals(instance.getBirthDate(), birthDate);

        instance.setBirthDate(newBirthdate);
        assertEquals(instance.getBirthDate(), newBirthdate);
    }

    /**
     * Test of setBirthdate method, of class Users.
     *
     * @param birthDate A test birth date
     */
    @org.testng.annotations.Test(dataProvider = "userProvider")
    public void testSetBirthdate(Integer id, String firstname, String lastname, String username, Date birthDate, String birthPlace, String motherLanguage) {
        System.out.println("setBirthdate");
        testGetBirthdate(id, firstname, lastname, username, birthDate, birthPlace, motherLanguage);
    }

    /**
     * Test of getBirthplace method, of class Users.
     *
     * @param birthPlace A test birth date
     */
    @org.testng.annotations.Test(dataProvider = "userProvider")
    public void testGetBirthplace(Integer id, String firstname, String lastname, String username, Date birthDate, String birthPlace, String motherLanguage) {
        System.out.println("getBirthplace");
        String newBirthplace = "new birth place";

        Users instance = new Users(id, firstname, lastname, birthDate, birthPlace, motherLanguage);
        instance.setBirthPlace(birthPlace);
        assertEquals(instance.getBirthPlace(), birthPlace);

        instance.setBirthPlace(newBirthplace);
        assertEquals(instance.getBirthPlace(), newBirthplace);
    }

    /**
     * Test of setBirthplace method, of class Users.
     *
     * @param birthPlace A test birth date
     */
    @org.testng.annotations.Test(dataProvider = "userProvider")
    public void testSetBirthplace(Integer id, String firstname, String lastname, String username, Date birthDate, String birthPlace, String motherLanguage) {
        System.out.println("setBirthplace");
        testGetBirthplace(id, firstname, lastname, username, birthDate, birthPlace, motherLanguage);
    }


    /**
     * Test of getMotherLanguage method, of class Users.
     *
     * @param motherLanguage Test mother language
     */
    @org.testng.annotations.Test(dataProvider = "userProvider")
    public void testGetMotherLanguage(Integer id, String firstname, String lastname, String username, Date birthDate, String birthPlace, String motherLanguage) {
        System.out.println("getMotherLanguage");
        String newMotherLanguage = "pt";

        Users instance = new Users(id, firstname, lastname, birthDate, birthPlace, motherLanguage);
        assertEquals(instance.getMotherLanguage(), motherLanguage);

        instance.setMotherLanguage(newMotherLanguage);
        assertEquals(instance.getMotherLanguage(), newMotherLanguage);
    }

    /**
     * Test of setMotherLanguage method, of class Users.
     *
     * @param motherLanguage Test mother language
     */
    @org.testng.annotations.Test(dataProvider = "userProvider")
    public void testSetMotherLanguage(Integer id, String firstname, String lastname, String username, Date birthDate, String birthPlace, String motherLanguage) {
        System.out.println("setMotherLanguage");
        testGetMotherLanguage(id, firstname, lastname, username, birthDate, birthPlace, motherLanguage);
    }



    /**
     * Test of setIsConfirmed method, of class Users.
     *
     * @param aUsers the user we are comparing
     * @param another the user we are comparing against
     */
    @org.testng.annotations.Test(dataProvider = "equalsProvider")
    public void testEquals(Users aUsers, Object another) {
        System.out.println("equals");
        assertTrue(aUsers.equals(another));
    }

    /**
     * Test of notEquals method, of class Users.
     *
     * @param aUsers
     * @param another
     */
    @org.testng.annotations.Test(dataProvider = "nonEqualsProvider")
    public void testNotEquals(Users aUsers, Object another) {
        System.out.println("non-equals");
        assertFalse(aUsers.equals(another));
    }

    /**
     * Test of setIsConfirmed method, of class Users.
     */
    @org.testng.annotations.Test
    public void testEqualsWithIncompatibleObject() {
        System.out.println("equals");
        Users instance1 = new Users();
        Roles instance2 = new Roles();
        assertFalse(instance1.equals(instance2));
    }

    /**
     * Test hash code.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Users instance1 = new Users();
        Users instance2 = new Users();
        assertEquals(instance1.hashCode(), instance2.hashCode());
    }

    /**
     * Test toString.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Users instance1 = new Users();
        Users instance2 = new Users();
        assertEquals(instance1.toString(), instance2.toString());
    }

    @DataProvider(name = "userProvider")
    public Object[][] provideUsersData() {
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
    public Object[][] provideUsersnames() {
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
        
        Users user1 = new Users(1, "Alexandre", "Zua Caldeira", d, "Piri, Angola", "pt");
        Users user2 = new Users(2, "Alexandre", "Zua Caldeira", d, "Estremoz, Portugal", "pt");
        Users user3 = new Users(3, "Alexandre2", "Zua Caldeira", d, "Lisboa Potugal", "pt");
        Users user4 = null;
        
        Object[][] data = new Object[][]{
            {user1, user2},
            {user1, user3},
            {user1, user4},
            {user2, user1},
            {user2, user3},
            {user2, user4},
            {user3, user1},
            {user3, user2},
            {user3, user4}
        };
        return data;
    }

    @DataProvider(name = "equalsProvider")
    public Object[][] provideEqualsData() {
        Date d = new Date();
        Users user1 = new Users(1, "Alexandre", "Zua Caldeira", d, "Piri, Angola", "pt");
        Users user2 = new Users(1, "Alexandre", "Zua Caldeira", d, "Piri, Angola", "pt");
        
        Object[][] data = new Object[][]{
            {user1, user1},
            {user1, user2},
            {user2, user1},
            {user2, user2}
        };
        return data;
    }
}
