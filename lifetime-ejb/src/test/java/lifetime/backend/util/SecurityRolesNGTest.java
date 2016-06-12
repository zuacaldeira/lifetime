/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.util;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zuacaldeira
 */
public class SecurityRolesNGTest {
    
    public SecurityRolesNGTest() {
    }

    /**
     * Test of values method, of class SecurityRoles.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        SecurityRoles[] expResult = null;
        SecurityRoles[] result = SecurityRoles.values();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class SecurityRoles.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        SecurityRoles expResult = null;
        SecurityRoles result = SecurityRoles.valueOf(name);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
