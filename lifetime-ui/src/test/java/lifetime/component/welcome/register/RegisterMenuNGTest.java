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

import lifetime.component.welcome.register.RegisterView;
import lifetime.component.welcome.register.RegisterMenu;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class RegisterMenuNGTest {

    public RegisterMenuNGTest() {
    }

    /**
     * Test of getHomeButton method, of class RegisterMenu.
     *
     * @param menu
     */
    @Test(dataProvider = "valid")
    public void testGetHomeButton(RegisterMenu menu) {
        System.out.println("getHomeButton");
        assertNotNull(menu.getHomeButton());
    }

    /**
     * Test of getCancelButton method, of class RegisterMenu.
     *
     * @param menu
     */
    @Test(dataProvider = "valid")
    public void testGetCancelButton(RegisterMenu menu) {
        System.out.println("getCancelButton");
        assertNotNull(menu.getCancelButton());
    }

    /**
     * Test of getOkButton method, of class RegisterMenu.
     *
     * @param menu
     */
    @Test(dataProvider = "valid")
    public void testGetOkButton(RegisterMenu menu) {
        System.out.println("getOkButton");
        assertNotNull(menu.getOkButton());
    }

    /**
     * Test of getRegistrationForm, that the register menu uses to lookup the
     * registration form.
     *
     * @param menu
     */
    @Test(dataProvider = "valid")
    public void testGetRegistrationForm(RegisterMenu menu) {
        System.out.println("getRegistrationForm()");
        RegisterView rView = new RegisterView("en");
        assertNotNull(rView.getMenu().getRegistrationForm());
        assertNull(menu.getRegistrationForm());
    }

    /**
     * Test of hashCode method, of class RegisterMenu.
     *
     * @param menu1
     * @param menu2
     */
    @Test(dataProvider = "validEquals")
    public void testHashCode(RegisterMenu menu1, RegisterMenu menu2) {
        System.out.println("hashCode");
        assertEquals(menu1.hashCode(), menu2.hashCode());
    }

    /**
     * Test of equals method, of class RegisterMenu.
     *
     * @param menu1
     * @param menu2
     */
    @Test(dataProvider = "validEquals")
    public void testEquals(RegisterMenu menu1, RegisterMenu menu2) {
        System.out.println("equals");
        assertTrue(menu1.equals(menu2));
    }

    /**
     * Test of equals method, of class RegisterMenu.
     *
     * @param menu1
     * @param menu2
     */
    @Test(dataProvider = "invalidEquals")
    public void testNotEquals(RegisterMenu menu1, Object menu2) {
        System.out.println("equals");
        assertFalse(menu1.equals(menu2));
    }

    @DataProvider(name = "valid")
    private Object[][] getValidData() {
        RegisterMenu menu1 = new RegisterMenu("en");
        RegisterMenu menu2 = new RegisterMenu("pt");
        return new Object[][]{{menu1}, {menu2}};
    }

    @DataProvider(name = "validEquals")
    private Object[][] getEqualsData() {
        RegisterMenu menu1 = new RegisterMenu("en");
        RegisterMenu menu2 = new RegisterMenu("pt");
        return new Object[][]{{menu1, menu1}, {menu2, menu2}};
    }

    @DataProvider(name = "invalidEquals")
    private Object[][] getNotEqualsData() {
        RegisterMenu menu1 = new RegisterMenu("en");
        RegisterMenu menu2 = new RegisterMenu("pt");
        return new Object[][]{{menu1, menu2}, {menu2, menu1}, {menu1, null}, {menu1, ""}};
    }

}
