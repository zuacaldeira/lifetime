/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import lifetime.persistence.TestHelper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class AccountControllerNGTest {

    private AccountController controller;
    private EJBContainer container;
    private Context context;

    public AccountControllerNGTest() {
    }

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
            controller = (AccountController) context.lookup("java:global/classes/AccountController");
        } catch (NamingException ex) {
            java.util.logging.Logger.getLogger(AccountControllerNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterClass
    private void tearDown() {
        container.close();
    }

    /**
     * Test of register method, of class AccountController.
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param birthDate
     * @param birthPlace
     * @param language
     */
    @Test(dataProvider = "registerData", dataProviderClass = LifetimeAccountServiceTest.class)
    public void testRegister(String firstName, String lastName, String email, String password, Date birthDate, String language, String birthPlace) {
        System.out.println("register");
        if (!controller.hasAccount(email)) {
            controller.register(firstName, lastName, email, password, language, birthDate, birthPlace);
        }
    }

    /**
     * Test of deleteAccount method, of class AccountController.
     *
     * @param email
     * @throws java.lang.Exception
     */
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTest.class)
    public void testDeleteAccount(String email) throws Exception {
        System.out.println("deleteAccount");
        if (!email.equals("zuacaldeira@gmail.com") && controller.hasAccount(email)) {
            Assert.assertTrue(controller.deleteAccount(email));
            Assert.assertFalse(controller.hasAccount(email));
        }
    }

    /**
     * Test of hasAccount method, of class AccountController.
     *
     * @param email
     * @throws java.lang.Exception
     */
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTest.class)
    public void testHasAccount(String email) throws Exception {
        System.out.println("hasAccount");
        controller.hasAccount(email);
    }

    /**
     * Test of getFullName method, of class AccountController.
     *
     * @param email
     * @throws java.lang.Exception
     */
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTest.class)
    public void testGetFullName(String email) throws Exception {
        System.out.println("getFullName");
        if (controller.hasAccount(email)) {
            Assert.assertNotNull(controller.getFullName(email));
        }
    }

    /**
     * Test of getBirthdate method, of class AccountController.
     *
     * @param email
     * @throws java.lang.Exception
     */
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTest.class)
    public void testGetBirthdate(String email) throws Exception {
        System.out.println("getBirthdate");
        if (controller.hasAccount(email)) {
            Assert.assertNotNull(controller.getBirthdate(email));
        }
    }

    /**
     * Test of getBirthPlace method, of class AccountController.
     *
     * @param email
     * @throws java.lang.Exception
     */
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTest.class)
    public void testGetBirthPlace(String email) throws Exception {
        System.out.println("getBirthPlace");
        if (controller.hasAccount(email)) {
            Assert.assertNotNull(controller.getBirthPlace(email));
        }
    }

}
