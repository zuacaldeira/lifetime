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
public class DeleteEntityExceptionNGTest {

    public DeleteEntityExceptionNGTest() {
    }

    @Test
    public void testCreateException() {
        DeleteEntityException exception = new DeleteEntityException(new RuntimeException("Ui...."));
        Assert.assertNotNull(exception.getLocalizedMessage());
    }

}
