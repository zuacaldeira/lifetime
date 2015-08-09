/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service;

import lifetime.backend.service.controller.AccountController;
import java.util.Date;
import java.util.logging.Level;
import javax.naming.Context;
import javax.naming.NamingException;
import lifetime.TestConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class AccountControllerNGTestIT {

    private AccountController controller;
    private Context context;

    public AccountControllerNGTestIT() {
    }

    @BeforeTest
    private void setUp() {
        context = TestConfig.getContainer().getContext();
        try {
            controller = (AccountController) context.lookup("java:global/classes/AccountController");
        } catch (NamingException ex) {
            java.util.logging.Logger.getLogger(AccountControllerNGTestIT.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    @Test(dataProvider = "registerData", dataProviderClass = LifetimeAccountServiceTestIT.class, groups = "CREATE_ACCOUNT")
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
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTestIT.class, groups = "DELETE_ACCOUNT", dependsOnGroups = "READ_ACCOUNT")
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
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTestIT.class, groups = "READ_ACCOUNT", dependsOnGroups = "CREATE_ACCOUNT")
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
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTestIT.class, groups = "READ_ACCOUNT", dependsOnGroups = "CREATE_ACCOUNT")
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
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTestIT.class, groups = "READ_ACCOUNT", dependsOnGroups = "CREATE_ACCOUNT")
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
    @Test(dataProvider = "email", dataProviderClass = LifetimeAccountServiceTestIT.class, groups = "READ_ACCOUNT", dependsOnGroups = "CREATE_ACCOUNT")
    public void testGetBirthPlace(String email) throws Exception {
        System.out.println("getBirthPlace");
        if (controller.hasAccount(email)) {
            Assert.assertNotNull(controller.getBirthPlace(email));
        }
    }

}
