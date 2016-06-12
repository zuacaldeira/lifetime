/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service;

import java.util.Date;
import lifetime.backend.persistence.jooq.tables.records.AccountRecord;
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

    private static final String ACCOUNT_SERVICE = "java:global/lifetime-ui/LifetimeAccountService";

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

        LifetimeAccountService instance = new LifetimeAccountService();
        boolean b = instance.register(firstname, lastname, email, password, language, birthdate, birthPlace);
        AccountRecord result = instance.read(email);
        assertTrue(b);
        assertEquals(result.getEmail(), email);
        assertEquals(result.getPassword(), password);
    }

    /**
     * Test of getPhoto method, of class LifetimeAccountService.
     */
    @Test
    public void testGetPhoto() throws Exception {
        System.out.println("getPhoto");
        String username = "";
        LifetimeAccountService instance = new LifetimeAccountService();
        //assertNull(instance.read(username).getEmail(username));

    }

}
