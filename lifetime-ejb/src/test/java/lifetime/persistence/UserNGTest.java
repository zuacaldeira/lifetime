/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.persistence;

import java.util.Calendar;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class UserNGTest {

    public UserNGTest() {
    }

    /**
     * Test of getId method, of class User.
     *
     * @param id
     */
    @Test(dataProvider = "provideId")
    public void testGetId(Integer id) {
        User u = new User();
        Assert.assertEquals(u.getId(), null);
        u.setId(id);
        Assert.assertEquals(u.getId(), id);
    }

    /**
     * Test of setId method, of class User.
     */
    @Test(dataProvider = "provideId")
    public void testSetId(Integer id) {
        User u = new User(null);
        u.setId(id);
        Assert.assertEquals(u.getId(), id);
    }

    @DataProvider(name = "provideId")
    private Object[][] provideId() {
        return new Object[][]{
            {1}, {Integer.MAX_VALUE}
        };
    }

    /**
     * Test of getFirstname method, of class User.
     *
     * @param firstname
     */
    @Test(dataProvider = "provideFirstName")
    public void testGetFirstname(String firstname) {
        User u = new User();
        u.setFirstname(firstname);
        Assert.assertEquals(u.getFirstname(), firstname);
    }

    /**
     * Test of setFirstname method, of class User.
     *
     * @param firstname
     */
    @Test
    public void testSetFirstname(String firstname) {
        testGetFirstname(firstname);
    }

    @DataProvider(name = "provideFirstName")
    private Object[][] provideFirstname() {
        return new Object[][]{
            {""}, {"Alexandre"}, {"AlexandreAlexandreAlexandreAlexandreAlexandre"}
        };
    }

    /**
     * Test of getLastname method, of class User.
     *
     * @param lastname
     */
    @Test(dataProvider = "provideLastName")
    public void testGetLastname(String lastname) {
        User u = new User();
        u.setLastname(lastname);
        Assert.assertEquals(u.getLastname(), lastname);
    }

    /**
     * Test of setLastname method, of class User.
     */
    @Test(dataProvider = "provideLastName")
    public void testSetLastname(String lastname) {
        testGetLastname(lastname);
    }

    @DataProvider(name = "provideLastName")
    private Object[][] provideLastname() {
        return new Object[][]{
            {""}, {"Alexandre"}, {"AlexandreAlexandreAlexandreAlexandreAlexandre"}
        };
    }

    /**
     * Test of getBirthDate method, of class User.
     *
     * @param d
     */
    @Test(dataProvider = "provideBirthDate")
    public void testGetBirthDate(Date d) {
        User u = new User();
        u.setBirthDate(d);
        Assert.assertEquals(u.getBirthDate(), d);
    }

    /**
     * Test of setBirthDate method, of class User.
     *
     * @param d
     */
    @Test(dataProvider = "provideBirthDate")
    public void testSetBirthDate(Date d) {
        testGetBirthDate(d);
    }

    @DataProvider(name = "provideBirthDate")
    private Object[][] provideBirthDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(2000, 01, 23);
        Date d1 = cal.getTime();

        cal.set(1000, 01, 23);
        Date d2 = cal.getTime();

        cal.set(3000, 01, 23);
        Date d3 = cal.getTime();

        return new Object[][]{
            {d1}, {d2}, {d3}
        };
    }

    /**
     * Test of getBirthPlace method, of class User.
     */
    @Test(dataProvider = "provideBirthPlace")
    public void testGetBirthPlace(String birthPlace) {
        User u = new User();
        u.setBirthPlace(birthPlace);
        Assert.assertEquals(u.getBirthPlace(), birthPlace);
    }

    /**
     * Test of setBirthPlace method, of class User.
     */
    @Test
    public void testSetBirthPlace(String birthPlace) {
        testGetBirthPlace(birthPlace);
    }

    @DataProvider(name = "provideBirthPlace")
    private Object[][] provideBirthPlace() {
        return new Object[][]{
            {"Luanda"}, {"Berlin"}, {"Lisboa"}
        };
    }

    /**
     * Test of getLanguage method, of class User.
     */
    @Test(dataProvider = "provideLanguage")
    public void testGetLanguage(String language) {
        User u = new User(null, null, null, null, null, null);
        u.setLanguage(language);
        Assert.assertEquals(u.getLanguage(), language);
    }

    /**
     * Test of setLanguage method, of class User.
     */
    @Test(dataProvider = "provideLanguage")
    public void testSetLanguage(String language) {
        testGetLanguage(language);
    }

    @DataProvider(name = "provideLanguage")
    private Object[][] provideLanguage() {
        return new Object[][]{
            {"pt"}, {"en"}, {"de"}
        };
    }

    /**
     * Test of hashCode method, of class User.
     *
     * @param u1
     * @param u2
     */
    @Test(dataProvider = "provideEqualUsers")
    public void testHashCode(User u1, User u2) {
        Assert.assertTrue(u1.hashCode() == u2.hashCode());
    }

    /**
     * Test of equals method, of class User.
     *
     * @param u1
     * @param u2
     */
    @Test(dataProvider = "provideEqualUsers")
    public void testEquals(User u1, User u2) {
        Assert.assertTrue(u1.equals(u2));
    }

    @DataProvider(name = "provideEqualUsers")
    private Object[][] provideEqualUsers() {
        Date d = new Date();
        User u1 = new User(1, "firstname", "lastname", d, "Lisboa", "pt");
        User u2 = new User(1, "firstname", "lastname", d, "Lisboa", "pt");
        return new Object[][]{
            {u1, u2}
        };
    }

    /**
     * Test of equals method, of class User.
     *
     * @param u1
     * @param u2
     */
    @Test(dataProvider = "provideNotEqualUsers")
    public void testNotEquals(User u1, Object u2) {
        Assert.assertFalse(u1.equals(u2));
    }

    @DataProvider(name = "provideNotEqualUsers")
    private Object[][] provideNotEqualUsers() {
        User u1 = new User(1, "firstname", "lastname", new Date(), "Lisboa", "pt");
        User u2 = new User(2, "firstname", "lastname", new Date(), "Lisboa", "pt");
        User u3 = new User(1, "first", "lastname", new Date(), "Lisboa", "pt");
        User u4 = new User(1, "firstname", "last", new Date(), "Lisboa", "pt");
        User u5 = new User(1, "firstname", "lastname", null, "Lisboa", "pt");
        User u6 = new User(1, "firstname", "lastname", new Date(), "Berlin", "pt");
        User u7 = new User(1, "firstname", "lastname", new Date(), "Lisboa", "de");
        return new Object[][]{
            {u1, u2},
            {u2, u3},
            {u3, u4},
            {u4, u5},
            {u5, u6},
            {u6, u7},
            {u7, null},
            {u7, ""}
        };
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        User u = new User(1);
        Assert.assertNotNull(u.toString());
    }

}
