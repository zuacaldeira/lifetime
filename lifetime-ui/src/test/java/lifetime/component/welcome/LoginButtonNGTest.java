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
package lifetime.component.welcome;

import lifetime.component.welcome.LoginButton;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class LoginButtonNGTest {

    public LoginButtonNGTest() {
    }

    /**
     * Test of hashCode method, of class LoginButton.
     *
     * @param instance1
     * @param instance2
     */
    @Test(dataProvider = "validEquals")
    public void testHashCode(LoginButton instance1, LoginButton instance2) {
        System.out.println("testHashCode()");
        assertEquals(instance1.hashCode(), instance2.hashCode());
    }

    /**
     * Test for equality.
     *
     * @param instance1
     * @param instance2
     */
    @Test(dataProvider = "validEquals")
    public void testEquals(LoginButton instance1, LoginButton instance2) {
        System.out.println("testEquals()");
        assertTrue(instance1.equals(instance2));
    }

    /**
     * Test for non equality.
     *
     * @param instance1
     * @param instance2
     */
    @Test(dataProvider = "invalidEquals")
    public void testNotEquals(LoginButton instance1, Object instance2) {
        System.out.println("testEquals()");
        assertFalse(instance1.equals(instance2));
    }

    @DataProvider(name = "valid")
    private Object[][] getValidData() {
        LoginButton button = new LoginButton("en");
        LoginButton button2 = new LoginButton("pt");
        return new Object[][]{{button}, {button2}};
    }

    @DataProvider(name = "validEquals")
    private Object[][] getEqualsData() {
        LoginButton button = new LoginButton("en");
        LoginButton button2 = new LoginButton("pt");
        return new Object[][]{{button, button}, {button2, button2}};
    }

    @DataProvider(name = "invalidEquals")
    private Object[][] getNotEqualsData() {
        LoginButton button = new LoginButton("en");
        LoginButton button2 = new LoginButton("pt");

        return new Object[][]{{button, button2}, {button2, button}, {button, null}, {button, ""}};
    }

}
