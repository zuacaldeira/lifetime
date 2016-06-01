/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service;

import java.util.Date;
import javax.ejb.embeddable.EJBContainer;
import lifetime.TestConfig;
import lifetime.backend.persistence.jooq.tables.Account;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author zuacaldeira
 */
public class LifetimeAccountServiceNGTestIT {

    private static final String ACCOUNT_SERVICE = "java:global/classes/LifetimeAccountService";

    public LifetimeAccountServiceNGTestIT() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of register method, of class LifetimeAccountService.
     */
    @Test
    public void testRegister() throws Exception {
        System.out.println("register");
        String firstname = "";
        String lastname = "";
        String email = "";
        String password = "";
        String language = "";
        Date birthdate = null;
        String birthPlace = "";

        //EJBContainer container = TestConfig.getContainer();
        LifetimeAccountService instance = (LifetimeAccountService) TestConfig.lookupService(ACCOUNT_SERVICE);
        boolean b = instance.register(firstname, lastname, email, password, language, birthdate, birthPlace);
        Account result = instance.read(email, password);

        assertTrue(b);
        assertEquals(result.field("email"), email);
        assertEquals(result.field("password"), password);
    }

    /**
     * Test of getPhoto method, of class LifetimeAccountService.
     */
    @Test
    public void testGetPhoto() throws Exception {
        System.out.println("getPhoto");
        String username = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        LifetimeAccountService instance = (LifetimeAccountService) container.getContext().lookup("java:global/classes/LifetimeAccountService");
        //Photo expResult = null;
        //Photo result = instance.getPhoto(username);
        //assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
    }

}
