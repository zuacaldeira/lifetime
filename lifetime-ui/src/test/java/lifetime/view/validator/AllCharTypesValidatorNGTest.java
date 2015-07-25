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
package lifetime.view.validator;

import com.vaadin.data.Validator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class AllCharTypesValidatorNGTest {
    
    public AllCharTypesValidatorNGTest() {
    }

    /**
     * Test of validate method, of class AllCharTypesValidator.
     */
    @Test(dataProvider = "validDataProvider")
    public void testValidate(String value) {
        System.out.println("testValidate()");
        AllCharTypesValidator instance = new AllCharTypesValidator();
        instance.validate(value);
        Assert.assertTrue(true);
    }
    
    /**
     * Test of invalidate with invalid data. Exception is expected.
     * @param value 
     */
    @Test(dataProvider = "invalidDataProvider", expectedExceptions = Validator.InvalidValueException.class)
    public void testValidateWithInvalidData(Object value) {
        System.out.println("testValidateWithInvalidData()");
        AllCharTypesValidator instance = new AllCharTypesValidator();
        instance.validate(value);
    }
    
    @DataProvider(name = "validDataProvider")
    private Object[][] provideValidData() {
        return new Object[][]{
            {"qwSrt1234!§$"},
            {"QWErT1234!§$"}
        };
    }
    
    @DataProvider(name = "invalidDataProvider")
    private Object[][] provideInvalidData() {
        return new Object[][]{
            {"QWErT!§$"},
            {"qwSrt1234"},
            {"qwerwqerqwerqwer"},
            {"QQQQQQQQQ"},
            {"1234123412341234"},
            {"qwe rwqerqwerqwer"},
            {"qwert"},
            {1.3f}
        };
    }

}
