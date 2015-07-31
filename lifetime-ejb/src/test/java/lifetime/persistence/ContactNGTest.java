/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.persistence;

import junit.framework.Assert;
import static lifetime.persistence.TestHelper.getRandomId;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class ContactNGTest {

    public ContactNGTest() {
    }

    /**
     * Test of getId method, of class Contact.
     *
     * @param contact
     */
    @Test(dataProvider = "contactData")
    public void testGetId(Contact contact) {
        System.out.println("getId");
        Integer id = TestHelper.getRandomId();
        contact.setId(id);
        Assert.assertEquals(contact.getId(), id);
    }

    /**
     * Test of setId method, of class Contact.
     *
     * @param contact
     */
    @Test(dataProvider = "contactData")
    public void testSetId(Contact contact) {
        System.out.println("setId");
        testGetId(contact);
    }

    /**
     * Test of getUsername method, of class Contact.
     *
     * @param contact
     */
    @Test(dataProvider = "contactData")
    public void testGetUsername(Contact contact) {
        System.out.println("getUsername");
        String username = "username";
        contact.setUsername(username);
        Assert.assertEquals(contact.getUsername(), username);
    }

    /**
     * Test of setUsername method, of class Contact.
     *
     * @param contact
     */
    @Test(dataProvider = "contactData")
    public void testSetUsername(Contact contact) {
        System.out.println("setUsername");
        testGetUsername(contact);
    }

    /**
     * Test of getTelephone1 method, of class Contact.
     *
     * @param contact
     */
    @Test(dataProvider = "contactData")
    public void testGetTelephone1(Contact contact) {
        System.out.println("getTelephone1");
        String telephone1 = "+4930123456";
        contact.setTelephone1(telephone1);
        Assert.assertEquals(contact.getTelephone1(), telephone1);
    }

    /**
     * Test of setTelephone1 method, of class Contact.
     *
     * @param contact
     */
    @Test(dataProvider = "contactData")
    public void testSetTelephone1(Contact contact) {
        System.out.println("setTelephone1");
        testGetTelephone1(contact);
    }

    /**
     * Test of getTelephone2 method, of class Contact.
     *
     * @param contact
     */
    @Test(dataProvider = "contactData")
    public void testGetTelephone2(Contact contact) {
        System.out.println("getTelephone2");
        String telephone2 = "+4930123456";
        contact.setTelephone2(telephone2);
        Assert.assertEquals(contact.getTelephone2(), telephone2);
    }

    /**
     * Test of setTelephone2 method, of class Contact.
     *
     * @param contact
     */
    @Test(dataProvider = "contactData")
    public void testSetTelephone2(Contact contact) {
        System.out.println("setTelephone2");
        testGetTelephone2(contact);
    }

    /**
     * Test of getMobile1 method, of class Contact.
     *
     * @param contact
     */
    @Test(dataProvider = "contactData")
    public void testGetMobile1(Contact contact) {
        System.out.println("getMobile1");
        String mobile1 = "+4930123456";
        contact.setMobile1(mobile1);
        Assert.assertEquals(contact.getMobile1(), mobile1);
    }

    /**
     * Test of setMobile1 method, of class Contact.
     *
     * @param contact
     */
    @Test(dataProvider = "contactData")
    public void testSetMobile1(Contact contact) {
        System.out.println("setMobile1");
        testGetMobile1(contact);
    }

    /**
     * Test of getMobile2 method, of class Contact.
     *
     * @param contact
     */
    @Test(dataProvider = "contactData")
    public void testGetMobile2(Contact contact) {
        System.out.println("getMobile2");
        String mobile2 = "+4930123456";
        contact.setMobile2(mobile2);
        Assert.assertEquals(contact.getMobile2(), mobile2);
    }

    /**
     * Test of setMobile2 method, of class Contact.
     *
     * @param contact
     */
    @Test(dataProvider = "contactData")
    public void testSetMobile2(Contact contact) {
        System.out.println("setMobile2");
        testGetMobile2(contact);
    }

    /**
     * Test of getFax1 method, of class Contact.
     *
     * @param contact
     */
    @Test(dataProvider = "contactData")
    public void testGetFax1(Contact contact) {
        System.out.println("getFax1");
        String fax1 = "+4930123456";
        contact.setFax1(fax1);
        Assert.assertEquals(contact.getFax1(), fax1);
    }

    /**
     * Test of setFax1 method, of class Contact.
     *
     * @param contact
     */
    @Test(dataProvider = "contactData")
    public void testSetFax1(Contact contact) {
        System.out.println("setFax1");
        testGetFax1(contact);
    }

    /**
     * Test of getFax2 method, of class Contact.
     *
     * @param contact
     */
    @Test(dataProvider = "contactData")
    public void testGetFax2(Contact contact) {
        System.out.println("getFax2");
        String fax2 = "+4930123456";
        contact.setFax2(fax2);
        Assert.assertEquals(contact.getFax2(), fax2);
    }

    /**
     * Test of setFax2 method, of class Contact.
     *
     * @param contact
     */
    @Test(dataProvider = "contactData")
    public void testSetFax2(Contact contact) {
        System.out.println("setFax2");
        testGetFax2(contact);
    }

    /**
     * Test of hashCode method, of class Contact.
     *
     * @param contact1
     * @param contact2
     */
    @Test(dataProvider = "equals")
    public void testHashCode(Contact contact1, Contact contact2) {
        System.out.println("hashCode");
        assertEquals(contact1.hashCode(), contact2.hashCode());
    }

    /**
     * Test of equals method, of class Contact.
     *
     * @param contact1
     * @param contact2
     */
    @Test(dataProvider = "equals")
    public void testEquals(Contact contact1, Contact contact2) {
        System.out.println("equals");
        Assert.assertTrue(contact1.equals(contact2));
    }

    /**
     * Test of equals method, of class Contact.
     *
     * @param contact1
     * @param contact2
     */
    @Test(dataProvider = "inequals")
    public void testInequals(Contact contact1, Object contact2) {
        System.out.println("equals");
        Assert.assertFalse(contact1.equals(contact2));
    }

    /**
     * Test of toString method, of class Contact.
     *
     * @param contact1
     * @param contact2
     */
    @Test(dataProvider = "equals")
    public void testToString(Contact contact1, Contact contact2) {
        assertEquals(contact1.toString(), contact2.toString());
    }

    /**
     * DATA PROVIDERS
     */
    /**
     * DATA PROVIDER: <b>addressData</b>
     */
    @DataProvider(name = "contactData")
    private Object[][] getContactData() {
        Contact c1 = new Contact(getRandomId(), "username", "+4930123456", "+35196123456", "+4930123456");
        Contact c2 = new Contact(getRandomId(), "username", null, null, null);
        Contact c3 = new Contact(getRandomId());
        Object[][] result = new Object[][]{
            {c1}, {c2}, {c3}
        };
        return result;
    }

    /**
     * DATA PROVIDER: <b>addressData</b>
     */
    @DataProvider(name = "equals")
    private Object[][] getEquasData() {
        Contact c1 = new Contact(getRandomId(), "username", "+4930123456", "+35196123456", "+4930123456");
        Contact c2 = new Contact(getRandomId(), "username", null, null, null);
        Contact c3 = new Contact(getRandomId());
        Contact c4 = new Contact();
        Object[][] result = new Object[][]{
            {c1, c1}, {c2, c2}, {c3, c3}, {c4, c4}
        };
        return result;
    }

    /**
     * DATA PROVIDER: <b>addressData</b>
     */
    @DataProvider(name = "inequals")
    private Object[][] getInequalsData() {
        Contact c1 = new Contact(getRandomId(), "username", "+4930123456", "+35196123456", "+4930123456");
        Contact c2 = new Contact(getRandomId(), "username", null, null, null);
        Contact c3 = new Contact(getRandomId());
        Contact c5 = new Contact(getRandomId(), TestHelper.getRandomString());
        Contact c6 = null;
        String c7 = "";
        Object[][] result = new Object[][]{
            {c1, c2}, {c2, c3}, {c3, c5}, {c5, c6}, {c5, c7}
        };
        return result;
    }

}
