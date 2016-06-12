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
public class TestHelperNGTest {
    
    public TestHelperNGTest() {
    }

    /**
     * Test of getRandomId method, of class TestHelper.
     */
    @Test
    public void testGetRandomId() {
        System.out.println("getRandomId");
        Integer expResult = null;
        Integer result = TestHelper.getRandomId();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRandomByteArray method, of class TestHelper.
     */
    @Test
    public void testGetRandomByteArray() {
        System.out.println("getRandomByteArray");
        byte[] expResult = null;
        byte[] result = TestHelper.getRandomByteArray();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRandomString method, of class TestHelper.
     */
    @Test
    public void testGetRandomString() {
        System.out.println("getRandomString");
        String expResult = "";
        String result = TestHelper.getRandomString();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
