/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime;

import lifetime.TestHelper;
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
        Integer result = TestHelper.getRandomId();
        assertNotNull(result);
    }

    /**
     * Test of getRandomByteArray method, of class TestHelper.
     */
    @Test
    public void testGetRandomByteArray() {
        System.out.println("getRandomByteArray");
        byte[] result = TestHelper.getRandomByteArray();
        assertNotNull(result);
    }

    /**
     * Test of getRandomString method, of class TestHelper.
     */
    @Test
    public void testGetRandomString() {
        System.out.println("getRandomString");
        String result = TestHelper.getRandomString();
        assertNotNull(result);
    }
    
}
