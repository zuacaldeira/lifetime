/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class RolesNGTest {
    
    public RolesNGTest() {
    }

    @Test
    public void testSomeMethod() {
        assertNotNull(SecurityRoles.USER);
    }
    
}
