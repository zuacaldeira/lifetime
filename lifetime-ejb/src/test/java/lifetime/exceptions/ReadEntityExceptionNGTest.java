/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.exceptions;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class ReadEntityExceptionNGTest {

    public ReadEntityExceptionNGTest() {
    }

    @Test
    public void testCreateException() {
        ReadEntityException exception = new ReadEntityException(new RuntimeException("Ui...."));
        Assert.assertNotNull(exception.getLocalizedMessage());
    }

}
