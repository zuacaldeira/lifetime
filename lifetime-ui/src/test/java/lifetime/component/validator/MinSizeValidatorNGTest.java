/*
 * Copyright 2015 zua.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package lifetime.component.validator;

import lifetime.component.validator.MinSizeValidator;
import com.vaadin.data.Validator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class MinSizeValidatorNGTest {
    
    public MinSizeValidatorNGTest() {
    }

    /**
     * Test of validate method, of class MinSizeValidator.
     * @param value
     */
    @Test(dataProvider = "validDataProvider")
    public void testValidate(String value) {
        System.out.println("validate");
        MinSizeValidator instance = new MinSizeValidator();
        instance.validate(value);
    }

    /**
     * Test of invalidate with invalid data. Exception is expected.
     *
     * @param value
     */
    @Test(dataProvider = "invalidDataProvider", expectedExceptions = Validator.InvalidValueException.class)
    public void testValidateWithInvalidData(Object value) {
        System.out.println("testValidateWithInvalidData()");
        MinSizeValidator instance = new MinSizeValidator();
        instance.validate(value);
    }

    @DataProvider(name = "validDataProvider")
    private Object[][] provideValidData() {
        return new Object[][]{
            {"asdfas"},
            {"asdfasdf"}
        };
    }

    @DataProvider(name = "invalidDataProvider")
    private Object[][] provideInvalidData() {
        return new Object[][]{
            {""},
            {"asdfa"}
        };
    }
    
}
