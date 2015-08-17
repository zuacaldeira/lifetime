/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service.controller;

import lifetime.backend.service.controller.ContactController;
import java.util.logging.Level;
import javax.naming.Context;
import javax.naming.NamingException;
import lifetime.TestConfig;
import lifetime.backend.persistence.Contact;
import lifetime.backend.service.LifetimeAccountServiceNGTestIT;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class ContactControllerNGTestIT {

    private ContactController contactController;
    private Context context;

    @BeforeTest
    private void setUp() {
        context = TestConfig.getContainer().getContext();
        try {
            contactController = (ContactController) context.lookup("java:global/classes/ContactController");
        } catch (NamingException ex) {
            java.util.logging.Logger.getLogger(LifetimeAccountServiceNGTestIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * Test of addPhoto method, of class PhotoController.
     *
     * @param contact
     * @throws java.lang.Exception
     */
    @Test(dataProvider = "contact", dataProviderClass = LifetimeAccountServiceNGTestIT.class)
    public void testAddContact(Contact contact) throws Exception {
        System.out.println("testAddContact()");
        if (!contactController.hasContact(contact.getUsername())) {
            Assert.assertTrue(contactController.create(contact));
        }
    }

    /**
     * Test of getPhoto method, of class PhotoController.
     *
     * @param email
     * @throws java.lang.Exception
     */
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceNGTestIT.class)
    public void testGetContact(String email) throws Exception {
        System.out.println("testGetContact()");
        if (contactController.hasContact(email)) {
            Assert.assertNotNull(contactController.read(email));
        }
    }

    /**
     * Test of getPhoto method, of class PhotoController.
     *
     * @param email
     * @throws java.lang.Exception
     */
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceNGTestIT.class)
    public void testDeleteContact(String email) throws Exception {
        System.out.println("testDeleteContact()");
        if (contactController.hasContact(email)) {
            Assert.assertTrue(contactController.delete(email));
        }
    }

}
