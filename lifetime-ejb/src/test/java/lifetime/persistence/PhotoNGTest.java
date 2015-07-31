/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.persistence;

import java.util.logging.Logger;
import static lifetime.persistence.TestHelper.getRandomId;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class PhotoNGTest {

    public PhotoNGTest() {
    }

    /**
     * Test of getId method, of class Photo.
     *
     * @param p
     */
    @Test(dataProvider = "photoData")
    public void testGetId(Photo p) {
        System.out.println("getId");
        Integer id = TestHelper.getRandomId();
        p.setId(id);
        assertEquals(p.getId(), id);
    }

    /**
     * Test of setId method, of class Photo.
     *
     * @param p
     */
    @Test(dataProvider = "photoData")
    public void testSetId(Photo p) {
        System.out.println("setId");
        testGetId(p);
    }

    /**
     * Test of hashCode method, of class Photo.
     *
     * @param p
     * @param other
     */
    @Test(dataProvider = "equals")
    public void testHashCode(Photo p, Photo other) {
        System.out.println("hashCode");
        Assert.assertEquals(p.hashCode(), other.hashCode());
    }

    /**
     * Test of equals method, of class Photo.
     *
     * @param p
     * @param other
     */
    @Test(dataProvider = "equals")
    public void testEquals(Photo p, Photo other) {
        System.out.println("equals");
        Assert.assertTrue(p.equals(other));
    }

    /**
     * Test of equals method, of class Photo.
     *
     * @param p
     * @param other
     */
    @Test(dataProvider = "inequals")
    public void testInequals(Photo p, Object other) {
        System.out.println("equals");
        System.out.println("P = " + p);
        System.out.println("Other = " + other);
        Assert.assertFalse(p.equals(other));
    }

    /**
     * Test of toString method, of class Photo.
     *
     * @param p
     * @param other
     */
    @Test(dataProvider = "equals")
    public void testToString(Photo p, Photo other) {
        System.out.println("toString");
        Assert.assertEquals(p.toString(), other.toString());
    }

    /**
     * Test of getImage method, of class Photo.
     *
     * @param p
     */
    @Test(dataProvider = "photoData")
    public void testGetImage(Photo p) {
        System.out.println("getImage");
        byte[] image = TestHelper.getRandomByteArray();
        p.setImage(image);
        assertEquals(p.getImage(), image);
    }

    /**
     * Test of setImage method, of class Photo.
     *
     * @param p
     */
    @Test(dataProvider = "photoData")
    public void testSetImage(Photo p) {
        System.out.println("setImage");
        testGetImage(p);
    }

    /**
     * Test of getUsername method, of class Photo.
     *
     * @param p
     */
    @Test(dataProvider = "photoData")
    public void testGetUsername(Photo p) {
        System.out.println("getUsername");
        String username = TestHelper.getRandomString();
        p.setUsername(username);
        assertEquals(p.getUsername(), username);
    }

    /**
     * Test of setUsername method, of class Photo.
     *
     * @param p
     */
    @Test(dataProvider = "photoData")
    public void testSetUsername(Photo p) {
        System.out.println("setUsername");
        testGetUsername(p);
    }

    /**
     * DATA PROVIDERS
     */
    /**
     * DATA PROVIDER: <b>addressData</b>
     */
    @DataProvider(name = "photoData")
    private Object[][] getPhotoData() {
        Photo p1 = new Photo(getRandomId(), TestHelper.getRandomString(), TestHelper.getRandomByteArray());
        Photo p2 = new Photo(getRandomId(), TestHelper.getRandomString(), TestHelper.getRandomByteArray());
        Photo p3 = new Photo();
        Photo p4 = new Photo(getRandomId());
        Photo p5 = new Photo(TestHelper.getRandomByteArray());
        Object[][] result = new Object[][]{
            {p1}, {p2}, {p3}, {p4}, {p5}
        };
        Logger.getLogger(PhotoNGTest.class.getName()).info("returning from PHOTO_DATA_PROVIDER".toUpperCase());
        return result;
    }

    /**
     * DATA PROVIDER: <b>addressData</b>
     */
    @DataProvider(name = "equals")
    private Object[][] getEquasData() {
        Photo p1 = new Photo(getRandomId(), TestHelper.getRandomString(), TestHelper.getRandomByteArray());
        Photo p2 = new Photo(getRandomId(), TestHelper.getRandomString(), TestHelper.getRandomByteArray());
        Photo p3 = new Photo();
        Object[][] result = new Object[][]{
            {p1, p1}, {p2, p2}, {p3, p3}
        };
        return result;
    }

    /**
     * DATA PROVIDER: <b>addressData</b>
     */
    @DataProvider(name = "inequals")
    private Object[][] getInequasData() {
        
        Photo p1 = new Photo();
        // Diff by id
        Photo p2 = new Photo(getRandomId());
        Photo p21 = new Photo(getRandomId());
        // Diff by image
        Photo p3 = new Photo(TestHelper.getRandomByteArray());
        Photo p31 = new Photo(TestHelper.getRandomByteArray());
        // diff by username
        Photo p4 = new Photo(null, TestHelper.getRandomString(), null);
        Photo p41 = new Photo(null, TestHelper.getRandomString(), null);
        // dif by type
        String p6 = "asd";
        // diff by null
        Photo p7 = null;
        Object[][] result = new Object[][]{
            {p1, p2}, {p2, p21}, {p3, p31}, {p4, p41}, {p1, p6}, {p1, p7}
        };
        return result;
    }

}
