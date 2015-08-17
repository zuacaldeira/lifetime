/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service;

import java.util.Date;
import java.util.logging.Level;
import javax.naming.Context;
import javax.naming.NamingException;
import lifetime.TestConfig;
import lifetime.backend.persistence.Address;
import lifetime.backend.persistence.Contact;
import lifetime.backend.persistence.Photo;
import lifetime.backend.persistence.User;
import lifetime.backend.util.TestHelper;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class LifetimeAccountServiceNGTestIT /*extends Arquillian implements Serializable */ {

    private LifetimeAccountService accountService;
    private static Context ctx;

    @BeforeTest
    private void setUp() {
        ctx = TestConfig.getContainer().getContext();
        try {
            accountService = (LifetimeAccountService) ctx.lookup("java:global/classes/LifetimeAccountService");
        } catch (NamingException ex) {
            java.util.logging.Logger.getLogger(LifetimeAccountServiceNGTestIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of register method, of class LifetimeAccountService.
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param language
     * @param password
     * @param birthDate
     * @param birthPlace Candidate's birth place
     */
    @Test(dataProvider = "registerData", groups = "CREATE_ACCOUNT")
    public void testRegisterAccount(String firstName, String lastName, String email, String password, Date birthDate, String language, String birthPlace) {
        Assert.assertNotNull(accountService, "REGISTER: Lifetime Account Service lookup failed");
        if (!accountService.hasAccount(email)) {
            Assert.assertTrue(accountService.register(firstName, lastName, email, password, language, birthDate, birthPlace));
        }
    }

    @Test(dataProvider = "registerData", groups = "READ_ACCOUNT", dependsOnGroups = {"CREATE_ACCOUNT"})
    public void testReadAccount(String firstName, String lastName, String email, String password, Date birthDate, String language, String birthPlace) {
        Assert.assertNotNull(accountService, "REGISTER: Lifetime Account Service lookup failed");
        if (accountService.hasAccount(email)) {
            Assert.assertEquals(accountService.getFullName(email), firstName + " " + lastName);
        }
    }

    @Test(dataProvider = "email", groups = "READ_ACCOUNT", dependsOnGroups = {"CREATE_ACCOUNT"})
    public void testReadFullname(String email) {
        Assert.assertNotNull(accountService, "REGISTER: Lifetime Account Service lookup failed");
        if (accountService.hasAccount(email)) {
            Assert.assertNotNull(accountService.getFullName(email));
            Assert.assertNotNull(accountService.getBirthdate(email));
            Assert.assertNotNull(accountService.getBirthPlace(email));
        }
    }

    @Test(dataProvider = "registerData", groups = {"DELETE_ACCOUNT"}, dependsOnGroups = {"CREATE_ACCOUNT", "READ_ACCOUNT"})
    public void testDeleteAccount(String firstName, String lastName, String email, String password, Date birthDate, String language, String birthPlace) {
        Assert.assertNotNull(accountService, "Service not initialized");
        if (accountService.hasAccount(email)) {
            Assert.assertTrue(accountService.deleteAccount(email));
        }
    }

    @Test(dataProvider = "email", groups = "CREATE_PHOTO")
    public void testCreatePhoto(String email) {
        Assert.assertNotNull(accountService, "Service not initialized");
        if (!accountService.hasPhoto(email)) {
            Assert.assertTrue(accountService.addPhoto(new Photo(null, email, TestHelper.getRandomByteArray())));
        }
    }

    @Test(dataProvider = "email", groups = "READ_PHOTO", dependsOnGroups = {"CREATE_PHOTO"})
    public void testGetPhoto(String email) {
        Assert.assertNotNull(accountService, "Service not initialized");
        if (accountService.hasPhoto(email)) {
            Assert.assertNotNull(accountService.getPhoto(email));
        }
    }

    @Test(dataProvider = "email", dependsOnGroups = {"READ_PHOTO"})
    public void testDeletePhoto(String email) {
        Assert.assertNotNull(accountService, "Service not initialized");
        if (accountService.hasPhoto(email)) {
            Assert.assertTrue(accountService.deletePhoto(email));
        }
    }

    @Test(dataProvider = "address", groups = "CREATE_ADDRESS")
    public void testCreateAddress(Address address) {
        Assert.assertNotNull(accountService, "Service not initialized");
        if (!accountService.hasAddress(address.getUsername())) {
            Assert.assertTrue(accountService.addAddress(address));
        }
    }

    @Test(dataProvider = "email", groups = {"READ_ADDRESS"}, dependsOnGroups = {"CREATE_ADDRESS"})
    public void testGetAddress(String email) {
        Assert.assertNotNull(accountService, "Service not initialized");
        if (accountService.hasAddress(email)) {
            Assert.assertNotNull(accountService.getAddress(email));
        }
    }

    @Test(dataProvider = "address", dependsOnGroups = {"READ_ADDRESS"})
    public void testDeleteAddress(Address address) {
        Assert.assertNotNull(accountService, "Service not initialized");
        if (accountService.hasAddress(address.getUsername())) {
            Assert.assertTrue(accountService.deleteAddress(address));
        }
    }

    @Test(dataProvider = "contact", groups = "CREATE_CONTACT")
    public void testCreateContact(Contact contact) {
        Assert.assertNotNull(accountService, "Service not initialized");
        if (!accountService.hasContact(contact.getUsername())) {
            Assert.assertTrue(accountService.addContact(contact));
        }
    }

    @Test(dataProvider = "email", groups = "READ_CONTACT", dependsOnGroups = {"CREATE_CONTACT"})
    public void testGetContact(String email) {
        Assert.assertNotNull(accountService, "Service not initialized");
        if (accountService.hasContact(email)) {
            Assert.assertNotNull(accountService.getContact(email));
        }
    }

    @Test(dataProvider = "contact", dependsOnGroups = {"READ_CONTACT"})
    public void testDeleteContact(Contact contact) {
        Assert.assertNotNull(accountService, "Service not initialized");
        if (accountService.hasContact(contact.getUsername())) {
            Assert.assertTrue(accountService.deleteContact(contact));
        }
    }

    @Test(dataProvider = "email", groups = {"READ_USER"}, dependsOnGroups = {"CREATE_ACCOUNT"})
    public void testReadUser(String email) {
        accountService.getUser(email);
    }

    @Test(dataProvider = "email", dependsOnGroups = {"CREATE_ACCOUNT", "READ_USER"})
    public void testUpdateUser(String email) {
        User u = accountService.getUser(email);
        if (u != null) {
            u.setBirthDate(new Date());
            assertTrue(accountService.update(u));
        }
    }

    /*    @Test(dataProvider = "registerNegativeData", groups = "CREATE_BAD_ACCOUNT", dependsOnGroups = "DELETE_ACCOUNT")
     public void testBadRegistration(String firstName, String lastName, String email, String password, Date birthDate, String language, String birthPlace) {
     Assert.assertNotNull(accountService, "Service not initialized");
     if (!accountService.hasAccount(email)) {
     Assert.assertFalse(accountService.register(firstName, lastName, email, password, language, birthDate, birthPlace));
     }
     }

     @Test(dataProvider = "registerNegativeData", groups = "DELETE_BAD_ACCOUNT", dependsOnGroups = "CREATE_BAD_ACCOUNT")
     public void testDeleteBadRegistration(String firstName, String lastName, String email, String password, Date birthDate, String language, String birthPlace) {
     Assert.assertNotNull(accountService, "Service not initialized");
     accountService.deleteAccount(email);
     }
     */
    @DataProvider(name = "registerData")
    public static Object[][] getData() {
        Object[][] dataArray = {
            {"Alexandre 1", "Zua Caldeira 1", "zuacaldeira1@gmail.com", "unicidade", new Date(), "pt", "Lisbon, Portugal"},
            {"Alexandre 2", "Zua Caldeira 2", "zuacaldeira2@gmail.com", "unicidade", new Date(), "pt", "Lisbon, Portugal"},
            {"Alexandre 3", "Zua Caldeira 3", "zuacaldeira3@gmail.com", "unicidade", new Date(), "pt", "Lisbon, Portugal"}
        };
        return dataArray;
    }

    @DataProvider(name = "registerNegativeData")
    public static Object[][] getNegativeData() {
        Object[][] dataArray = {
            {null, "Zua Caldeira 4", "zuacaldeira4@gmail.com", "unicidade", new Date(), "pt", "Lisbon, Portugal"},
            {"Alexandre 5", null, "zuacaldeira5@gmail.com", "unicidade", new Date(), "pt", "Lisbon, Portugal"},
            {"Alexandre 6", "Zua Caldeira 3", null, "unicidade", new Date(), "pt", "Lisbon, Portugal"},
            {"Alexandre 7", "Zua Caldeira 3", "zuacaldeira7@gmail.com", null, new Date(), "pt", "Lisbon, Portugal"},
            {"Alexandre 8", "Zua Caldeira 3", "zuacaldeira8@gmail.com", "unicidade", null, "pt", "Lisbon, Portugal"},
            {"Alexandre 9", "Zua Caldeira 3", "zuacaldeira9@gmail.com", "unicidade", new Date(), null, "Lisbon, Portugal"},
            {"Alexandre 10", "Zua Caldeira 3", "zuacaldeira10@gmail.com", "unicidade", new Date(), "pt", null}
        };
        return dataArray;
    }

    @DataProvider(name = "email")
    public static Object[][] getEmailData() {
        Object[][] dataArray = {
            {"zuacaldeira1@gmail.com"},
            {"zuacaldeira2@gmail.com"},
            {"zuacaldeira3@gmail.com"}
        };
        return dataArray;
    }

    @DataProvider(name = "contact")
    public static Object[][] getContactData() {
        Object[][] dataArray = {
            //{null, "Zua Caldeira 1", "zuacaldeira1@gmail.com", "unicidade", new Date(), "pt", "Lisbon, Portugal"},
            //{"Alexandre 2", null, "zuacaldeira2@gmail.com", "unicidade", new Date(), "pt", "Lisbon, Portugal"},
            {new Contact(null, "zuacaldeira1@gmail.com", "t", "m", "f")},
            {new Contact(null, "zuacaldeira2@gmail.com", null, "m", "f")},
            {new Contact(null, "zuacaldeira3@gmail.com", "t", null, "f")}
        };
        return dataArray;
    }

    @DataProvider(name = "address")
    public static Object[][] getAddressData() {
        Address a1 = new Address("zuacaldeira1@gmail.com", "S1", "D1", "F1", "PC1", "L1", "R1", "C1");
        Address a2 = new Address("zuacaldeira2@gmail.com", "S2", "D2", "F2", "PC1", "L1", "R1", "C1");
        Address a3 = new Address("zuacaldeira3@gmail.com", "S3", "D3", "F3", "PC1", "L1", "R1", "C1");

        Object[][] dataArray = {
            {a1},
            {a2},
            {a3}
        };
        return dataArray;
    }

}
