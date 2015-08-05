/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.exceptions;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class CreateEntityExceptionNGTest {

    public CreateEntityExceptionNGTest() {
    }

    @Test
    public void testCreateException() {
        CreateEntityException exception = new CreateEntityException(new RuntimeException("Ui...."));
        Assert.assertNotNull(exception.getLocalizedMessage());
    }

}
