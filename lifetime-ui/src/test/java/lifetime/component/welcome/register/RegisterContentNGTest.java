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
package lifetime.component.welcome.register;

import lifetime.component.welcome.register.RegisterContent;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class RegisterContentNGTest {

    public RegisterContentNGTest() {
    }

    /**
     * Test of getRegistrationForm method, of class RegisterContent.
     */
    @Test
    public void testGetRegisterForm() {
        System.out.println("testGetRegisterForm()");
        RegisterContent content = new RegisterContent("en");
        Assert.assertNotNull(content.getRegistrationForm());
    }

    /**
     * Test of hashCode method, of class RegisterContent.
     *
     * @param rc1
     * @param rc2
     */
    @Test(dataProvider = "equals")
    public void testHashCode(RegisterContent rc1, RegisterContent rc2) {
        System.out.println("testHashCode()");
        assertEquals(rc1.hashCode(), rc2.hashCode());
    }

    /**
     * Test of equals method, of class RegisterContent.
     *
     * @param rc1
     * @param rc2
     */
    @Test(dataProvider = "equals")
    public void testEquals(RegisterContent rc1, RegisterContent rc2) {
        System.out.println("testEquals()");
        assertTrue(rc1.equals(rc2));
    }

    /**
     * Test of equals method, of class RegisterContent.
     *
     * @param rc1
     * @param rc2
     */
    @Test(dataProvider = "notEquals")
    public void testNotEquals(RegisterContent rc1, Object rc2) {
        System.out.println("testNotEquals()");
        assertFalse(rc1.equals(rc2));
    }

    @DataProvider(name = "equals")
    private Object[][] getEqualsData() {
        RegisterContent rc1 = new RegisterContent("en");
        RegisterContent rc2 = new RegisterContent("pt");
        return new Object[][]{{rc1, rc1}, {rc2, rc2}};
    }

    @DataProvider(name = "notEquals")
    private Object[][] getNotEqualsData() {
        RegisterContent rc1 = new RegisterContent("en");
        RegisterContent rc2 = new RegisterContent("pt");
        return new Object[][]{{rc1, rc2}, {rc2, rc1}, {rc1, null}, {rc1, ""}};
    }

}
