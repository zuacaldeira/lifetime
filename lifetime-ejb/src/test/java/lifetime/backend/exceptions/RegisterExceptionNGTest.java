/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.exceptions;

import lifetime.backend.exceptions.LifetimeException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class RegisterExceptionNGTest {

    public RegisterExceptionNGTest() {
    }

    @Test
    public void testCreateException() {
        LifetimeException exception = new LifetimeException(new RuntimeException("Ui...."));
        Assert.assertNotNull(exception.getLocalizedMessage());
    }

}
