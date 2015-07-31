/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.persistence;

import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class AddressNGTest {

    public AddressNGTest() {
    }

    /**
     * Test of getId method, of class Address.
     *
     * @param address
     */
    @Test(dataProvider = "addressData")
    public void testGetId(Address address) {
        System.out.println("getId");
        Integer id = Math.round(((float) Math.random() * Integer.MAX_VALUE));
        address.setId(id);
        assertEquals(address.getId(), id);
    }

    /**
     * Test of setId method, of class Address.
     *
     * @param address
     */
    @Test(dataProvider = "addressData")
    public void testSetId(Address address) {
        System.out.println("setId");
        testGetId(address);
    }

    /**
     * Test of getUsername method, of class Address.
     *
     * @param address
     */
    @Test(dataProvider = "addressData")
    public void testGetUsername(Address address) {
        System.out.println("getUsername");
        String username = "username";
        address.setUsername(username);
        assertEquals(address.getUsername(), username);
    }

    /**
     * Test of setUsername method, of class Address.
     *
     * @param address
     */
    @Test(dataProvider = "addressData")
    public void testSetUsername(Address address) {
        System.out.println("setUsername");
        testGetUsername(address);
    }

    /**
     * Test of getStreet method, of class Address.
     *
     * @param address
     */
    @Test(dataProvider = "addressData")
    public void testGetStreet(Address address) {
        System.out.println("getStreet");
        String street = "street";
        address.setStreet(street);
        assertEquals(address.getStreet(), street);
    }

    /**
     * Test of setStreet method, of class Address.
     *
     * @param address
     */
    @Test(dataProvider = "addressData")
    public void testSetStreet(Address address) {
        System.out.println("setStreet");
        testGetStreet(address);
    }

    /**
     * Test of getDoor method, of class Address.
     *
     * @param address
     */
    @Test(dataProvider = "addressData")
    public void testGetDoor(Address address) {
        System.out.println("getDoor");
        String door = "1A";
        address.setDoor(door);
        assertEquals(address.getDoor(), door);
    }

    /**
     * Test of setDoor method, of class Address.
     *
     * @param address
     */
    @Test(dataProvider = "addressData")
    public void testSetDoor(Address address) {
        System.out.println("setDoor");
        testGetDoor(address);

    }

    /**
     * Test of getFloor method, of class Address.
     *
     * @param address
     */
    @Test(dataProvider = "addressData")
    public void testGetFloor(Address address) {
        System.out.println("getFloor");
        String floor = "1A";
        address.setFloor(floor);
        assertEquals(address.getFloor(), floor);
    }

    /**
     * Test of setFloor method, of class Address.
     *
     * @param address
     */
    @Test(dataProvider = "addressData")
    public void testSetFloor(Address address) {
        System.out.println("setFloor");
        testGetFloor(address);
    }

    /**
     * Test of getPostalCode method, of class Address.
     *
     * @param address
     */
    @Test(dataProvider = "addressData")
    public void testGetPostalCode(Address address) {
        System.out.println("getPostalCode");
        String postalCode = "10557-345";
        address.setPostalCode(postalCode);
        assertEquals(address.getPostalCode(), postalCode);
    }

    /**
     * Test of setPostalCode method, of class Address.
     *
     * @param address
     */
    @Test(dataProvider = "addressData")
    public void testSetPostalCode(Address address) {
        System.out.println("setPostalCode");
        testGetPostalCode(address);
    }

    /**
     * Test of getLocality method, of class Address.
     *
     * @param address
     */
    @Test(dataProvider = "addressData")
    public void testGetLocality(Address address) {
        System.out.println("getLocality");
        String locality = "Estremoz";
        address.setLocality(locality);
        assertEquals(address.getLocality(), locality);
    }

    /**
     * Test of setLocality method, of class Address.
     *
     * @param address
     */
    @Test(dataProvider = "addressData")
    public void testSetLocality(Address address) {
        System.out.println("setLocality");
        testGetLocality(address);
    }

    /**
     * Test of getRegion method, of class Address.
     *
     * @param address
     */
    @Test(dataProvider = "addressData")
    public void testGetRegion(Address address) {
        System.out.println("getRegion");
        String region = "Alentejo";
        address.setRegion(region);
        assertEquals(address.getRegion(), region);
    }

    /**
     * Test of setRegion method, of class Address.
     *
     * @param address
     */
    @Test(dataProvider = "addressData")
    public void testSetRegion(Address address) {
        System.out.println("setRegion");
        testGetRegion(address);
    }

    /**
     * Test of getCountry method, of class Address.
     *
     * @param address
     */
    @Test(dataProvider = "addressData")
    public void testGetCountry(Address address) {
        System.out.println("getCountry");
        String country = "Portugal";
        address.setCountry(country);
        assertEquals(address.getCountry(), country);
    }

    /**
     * Test of setCountry method, of class Address.
     *
     * @param address
     */
    @Test(dataProvider = "addressData")
    public void testSetCountry(Address address) {
        System.out.println("setCountry");
        testGetCountry(address);
    }

    private Integer getRandomId() {
        return Math.round((float) (Math.random() * Integer.MAX_VALUE));
    }

    /**
     * Test of hashCode method, of class Address.
     *
     * @param address1
     * @param address2
     */
    @Test(dataProvider = "equals")
    public void testHashCode(Address address1, Address address2) {
        System.out.println("hashCode");
        Assert.assertEquals(address1.hashCode(), address2.hashCode());
    }

    /**
     * Test of equals method, of class Address.
     *
     * @param address1
     * @param address2
     */
    @Test(dataProvider = "equals")
    public void testEquals(Address address1, Address address2) {
        System.out.println("equals");
        Assert.assertTrue(address1.equals(address2));
    }

    /**
     * Test of equals method, of class Address.
     *
     * @param address1
     * @param other
     */
    @Test(dataProvider = "inequals")
    public void testInequals(Address address1, Object other) {
        System.out.println("inequals");
        Assert.assertFalse(address1.equals(other));
    }

    /**
     * Test of toString method, of class Address.
     *
     * @param address1
     * @param address2
     */
    @Test(dataProvider = "equals")
    public void testToString(Address address1, Address address2) {
        System.out.println("toString");
        Assert.assertEquals(address1.toString(), address2.toString());
    }

    
    
    
    /**
     * DATA PROVIDER: <b>addressData</b>
     */
    @DataProvider(name = "addressData")
    private Object[][] getAddressData() {
        Address a1 = new Address("Lehrter Str", "8", "3 links", "10557", "Berlin", "Berlin", "Deutschland");
        Address a2 = new Address("Lar de Betânia", null, "Quinta das Sequeiras", "7101", "Estremoz", "Alentejo", "Portugal");
        Address a3 = new Address();
        Object[][] result = new Object[][]{
            {a1}, {a2}, {a3}
        };
        return result;
    }

    
    /**
     * DATA PROVIDER: <b>addressData</b>
     */
    @DataProvider(name = "equals")
    private Object[][] getEquasData() {
        Address a1 = new Address("Lehrter Str", "8", "3 links", "10557", "Berlin", "Berlin", "Deutschland");
        Address a2 = new Address("Lar de Betânia", null, "Quinta das Sequeiras", "7101", "Estremoz", "Alentejo", "Portugal");
        Address a3 = new Address();
        Object[][] result = new Object[][]{
            {a1, a1}, {a2, a2}, {a3, a3}
        };
        return result;
    }

    
    
    /**
     * DATA PROVIDER: <b>addressData</b>
     */
    @DataProvider(name = "inequals")
    private Object[][] getInequasData() {
        Address a1 = new Address("Lehrter Str", "8", "3 links", "10557", "Berlin", "Berlin", "Deutschland");
        Address a2 = new Address("Lar de Betânia", null, "Quinta das Sequeiras", "7101", "Estremoz", "Alentejo", "Portugal");
        Address a3 = new Address();
        Address a6 = null;
        Object a7 = "";
        Object[][] result = new Object[][]{
            {a1, a2}, {a2, a3}, {a3, a6}, {a1, a7}
        };
        return result;
    }

}
