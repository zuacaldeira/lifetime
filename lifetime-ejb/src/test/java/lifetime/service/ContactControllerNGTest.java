/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import lifetime.persistence.Contact;
import lifetime.persistence.TestHelper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class ContactControllerNGTest {

    private ContactController contactController;
    private EJBContainer container;
    private Context context;

    @BeforeClass
    private void setUp() {
        Map<String, Object> p = new HashMap<String, Object>();
        p.put(TestHelper.getEmbeddedGlassFishDomainPropertyName,
                TestHelper.getEmbeddedGlassFishDomainPropertyValue
        );
        container = EJBContainer.createEJBContainer(p);
        System.out.println("Starting the container");
        context = container.getContext();
        try {
            contactController = (ContactController) context.lookup("java:global/classes/ContactController");
        } catch (NamingException ex) {
            java.util.logging.Logger.getLogger(LifetimeAccountServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterClass
    private void tearDown() {
        container.close();
    }

    /**
     * Test of addPhoto method, of class PhotoController.
     *
     * @param contact
     * @throws java.lang.Exception
     */
    @Test(dataProvider = "contact", dataProviderClass = LifetimeAccountServiceTest.class)
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
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTest.class)
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
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTest.class)
    public void testDeleteContact(String email) throws Exception {
        System.out.println("testDeleteContact()");
        if (contactController.hasContact(email)) {
            Assert.assertTrue(contactController.delete(email));
        }
    }

}
