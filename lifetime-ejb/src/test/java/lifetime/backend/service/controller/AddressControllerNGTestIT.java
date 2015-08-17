/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service.controller;

import lifetime.backend.service.controller.AddressController;
import java.util.logging.Level;
import javax.naming.Context;
import javax.naming.NamingException;
import lifetime.TestConfig;
import lifetime.backend.persistence.Address;
import lifetime.backend.service.LifetimeAccountServiceTestIT;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class AddressControllerNGTestIT {

    private AddressController addressController;
    private Context context;

    @BeforeTest
    private void setUp() {
        context = TestConfig.getContainer().getContext();
        try {
            addressController = (AddressController) context.lookup("java:global/classes/AddressController");
        } catch (NamingException ex) {
            java.util.logging.Logger.getLogger(AddressControllerNGTestIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of addPhoto method, of class PhotoController.
     *
     * @param address
     * @throws java.lang.Exception
     */
    @Test(dataProvider = "address", dataProviderClass = LifetimeAccountServiceTestIT.class)
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
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTestIT.class)
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
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTestIT.class)
    public void testDelete(String email) throws Exception {
        System.out.println("testDeleteAddress()");
        if (addressController.hasAddress(email)) {
            Assert.assertTrue(addressController.delete(email));
        }
    }

}
