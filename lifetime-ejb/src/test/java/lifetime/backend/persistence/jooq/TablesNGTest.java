/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.persistence.jooq;

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
public class TablesNGTest {
    
    public TablesNGTest() {
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

    @Test
    public void testContainsTables() {
        // TODO review the generated test code and remove the default call to fail.
        assertNotNull(Tables.ACCOUNT);
        assertNotNull(Tables.ADDRESS);
        assertNotNull(Tables.COMPETITION);
        assertNotNull(Tables.COURSE);
        assertNotNull(Tables.LECTURE);
        assertNotNull(Tables.LIFETIME_EVENT);
        assertNotNull(Tables.LIFETIME_ORG);
        assertNotNull(Tables.LIFETIME_USER);
        assertNotNull(Tables.PROJECT);
        assertNotNull(Tables.SPORT);
        assertNotNull(Tables.STUDY);
        assertNotNull(Tables.TASK);
        assertNotNull(Tables.TRAINING);
        assertNotNull(Tables.WORK);
        assertNotNull(Tables.SCHEMA_VERSION);
    }
    
}
