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

import lifetime.component.validator.HasMinimumLength;
import com.vaadin.data.Validator;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class HasMinimumLengthNGTest {

    /**
     * Test of validate method, of class HasMinimumLength.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        HasMinimumLength rule = new HasMinimumLength();
        rule.validate("asdasd");
    }

    /**
     * Test of validate method, of class HasMinimumLength.
     */
    @Test(expectedExceptions = Validator.InvalidValueException.class)
    public void testInvalidate() {
        System.out.println("invalidate");
        HasMinimumLength rule = new HasMinimumLength();
        rule.validate("asdas");
    }
}
