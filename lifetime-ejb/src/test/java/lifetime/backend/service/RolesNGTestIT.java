/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service;

import lifetime.backend.util.SecurityRoles;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class RolesNGTestIT {
    
    public RolesNGTestIT() {
    }

    @Test
    public void testSomeMethod() {
        assertNotNull(SecurityRoles.USER);
    }
    
}
