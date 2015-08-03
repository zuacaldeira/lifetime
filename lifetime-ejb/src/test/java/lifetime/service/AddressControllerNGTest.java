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
import lifetime.persistence.Address;
import lifetime.persistence.TestHelper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class AddressControllerNGTest {

    private AddressController addressController;
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
            addressController = (AddressController) context.lookup("java:global/classes/AddressController");
        } catch (NamingException ex) {
            java.util.logging.Logger.getLogger(AddressControllerNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterClass
    private void tearDown() {
        container.close();
    }

    /**
     * Test of addPhoto method, of class PhotoController.
     *
     * @param address
     * @throws java.lang.Exception
     */
    @Test(dataProvider = "address", dataProviderClass = LifetimeAccountServiceTest.class)
    public void testCreate(Address address) throws Exception {
        System.out.println("testAddAddress()");
        if (!addressController.hasAddress(address.getUsername())) {
            Assert.assertTrue(addressController.create(address));
        }
    }

    /**
     * Test of getPhoto method, of class PhotoController.
     *
     * @param email
     * @throws java.lang.Exception
     */
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTest.class)
    public void testRead(String email) throws Exception {
        System.out.println("testGetAddress()");
        if (addressController.hasAddress(email)) {
            Assert.assertNotNull(addressController.read(email));
        }
    }

    /**
     * Test of getPhoto method, of class PhotoController.
     *
     * @param email
     * @throws java.lang.Exception
     */
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTest.class)
    public void testDelete(String email) throws Exception {
        System.out.println("testDeleteAddress()");
        if (addressController.hasAddress(email)) {
            Assert.assertTrue(addressController.delete(email));
        }
    }

}
