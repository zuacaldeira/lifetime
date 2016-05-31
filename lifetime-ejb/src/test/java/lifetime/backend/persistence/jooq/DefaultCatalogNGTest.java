/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.persistence.jooq;

import java.util.ArrayList;
import java.util.List;
import org.jooq.Schema;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zuacaldeira
 */
public class DefaultCatalogNGTest {

    public DefaultCatalogNGTest() {
    }

    /**
     * Test of getSchemas method, of class DefaultCatalog.
     */
    @Test
    public void testGetSchemas() {
        System.out.println("getSchemas");
        DefaultCatalog instance = DefaultCatalog.DEFAULT_CATALOG;
        // Default catalog is initalized
        assertNotNull(instance);
        // Schema of default catalog is @{literal lifetime}
        assertTrue(instance.getSchemas().contains(Lifetime.LIFETIME));
    }

    /**
     * Test if default catalog is correctly initialized with defaults.
     */
    @Test
    public void testHasDefaultCatalog() {
        System.out.println("testHasDefaultCatalog");
        assertNotNull(DefaultCatalog.DEFAULT_CATALOG);
    }

    /**
     * Test if default catalog has an initialized schema of lifetime database.
     */
    @Test
    public void testHasLifetimeSchema() {
        System.out.println("testHasLifetimeSchema");
        assertNotNull(DefaultCatalog.DEFAULT_CATALOG.LIFETIME);
        String name = Lifetime.LIFETIME.getName();
        System.out.println(name);
        assertNotNull(DefaultCatalog.DEFAULT_CATALOG.getSchema(name));
    }
}
