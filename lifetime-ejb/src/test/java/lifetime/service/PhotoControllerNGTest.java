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
import lifetime.persistence.Photo;
import lifetime.persistence.TestHelper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class PhotoControllerNGTest {

    private PhotoController photoController;
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
            photoController = (PhotoController) context.lookup("java:global/classes/PhotoController");
        } catch (NamingException ex) {
            java.util.logging.Logger.getLogger(PhotoControllerNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterClass
    private void tearDown() {
        container.close();
    }

    /**
     * Test of read method, of class PhotoController.
     *
     * @param email
     * @throws java.lang.Exception
     */
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTest.class)
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
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTest.class)
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
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTest.class)
    public void testAddPhoto(String email) throws Exception {
        System.out.println("addPhoto");
        if(!photoController.hasPhoto(email)) {
            photoController.create(new Photo(null, email, TestHelper.getRandomByteArray()));
        }
    }

}
