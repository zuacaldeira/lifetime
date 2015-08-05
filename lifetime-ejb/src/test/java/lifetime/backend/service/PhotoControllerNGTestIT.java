/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service;

import lifetime.backend.service.controller.PhotoController;
import java.util.logging.Level;
import javax.naming.Context;
import javax.naming.NamingException;
import lifetime.TestConfig;
import lifetime.backend.persistence.Photo;
import lifetime.backend.util.TestHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class PhotoControllerNGTestIT {

    private PhotoController photoController;
    private Context context;

    @BeforeTest
    private void setUp() {
        context = TestConfig.getContainer().getContext();
        try {
            photoController = (PhotoController) context.lookup("java:global/classes/PhotoController");
        } catch (NamingException ex) {
            java.util.logging.Logger.getLogger(PhotoControllerNGTestIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of read method, of class PhotoController.
     *
     * @param email
     * @throws java.lang.Exception
     */
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTestIT.class)
    public void testGetPhoto(String email) throws Exception {
        System.out.println("getPhoto");
        if(photoController.hasPhoto(email)) {
            Assert.assertNotNull(photoController.read(email));
        }
    }

    /**
     * Test of read method, of class PhotoController.
     *
     * @param email
     * @throws java.lang.Exception
     */
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTestIT.class)
    public void testDeletePhoto(String email) throws Exception {
        System.out.println("getPhoto");
        if(photoController.hasPhoto(email)) {
            Assert.assertTrue(photoController.delete(email));
        }
    }

    /**
     * Test of create method, of class PhotoController.
     *
     * @param email
     * @throws java.lang.Exception
     */
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTestIT.class)
    public void testAddPhoto(String email) throws Exception {
        System.out.println("addPhoto");
        if(!photoController.hasPhoto(email)) {
            photoController.create(new Photo(null, email, TestHelper.getRandomByteArray()));
        }
    }

}
