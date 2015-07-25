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
package lifetime.view.welcome;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class WelcomeMenuNGTest {
    
    public WelcomeMenuNGTest() {
    }

    /**
     * Test of getHomeButton method, of class WelcomeMenu.
     * @param menu
     */
    @Test(dataProvider = "validMenuProvider")
    public void testGetHomeButton(WelcomeMenu menu) {
        System.out.println("getHomeButton");
        Assert.assertNotNull(menu.getHomeButton());
        Assert.assertTrue(menu.getHomeButton().isEnabled());
        Assert.assertTrue(menu.getHomeButton().isVisible());
    }

    /**
     * Test of getRegisterButton method, of class WelcomeMenu.
     * @param menu
     */
    @Test(dataProvider = "validMenuProvider")
    public void testGetRegisterButton(WelcomeMenu menu) {
        System.out.println("getRegisterButton");
        Assert.assertNotNull(menu.getRegisterButton());
        Assert.assertTrue(menu.getRegisterButton().isEnabled());
        Assert.assertTrue(menu.getRegisterButton().isVisible());
    }

    /**
     * Test of getLoginButton method, of class WelcomeMenu.
     * @param menu
     */
    @Test(dataProvider = "validMenuProvider")
    public void testGetLoginButton(WelcomeMenu menu) {
        System.out.println("getLoginButton");
        Assert.assertNotNull(menu.getLoginButton());
        Assert.assertTrue(menu.getLoginButton().isEnabled());
        Assert.assertTrue(menu.getLoginButton().isVisible());
    }

    /**
     * Test of getContactButton method, of class WelcomeMenu.
     * @param menu
     */
    @Test(dataProvider = "validMenuProvider")
    public void testGetContactButton(WelcomeMenu menu) {
        System.out.println("getContactButton");
        Assert.assertNotNull(menu.getContactButton());
        Assert.assertTrue(menu.getContactButton().isEnabled());
        Assert.assertTrue(menu.getContactButton().isVisible());
    }

    /**
     * Test of hashCode method, of class WelcomeMenu.
     * @param menu
     * @param anotherMenu
     */
    @Test(dataProvider = "validEqualsProvider")
    public void testHashCode(WelcomeMenu menu, WelcomeMenu anotherMenu) {
        System.out.println("hashCode");
        Assert.assertEquals(menu.hashCode(), anotherMenu.hashCode());
    }

    /**
     * Test of equals method, of class WelcomeMenu.
     * @param menu
     * @param anotherMenu
     */
    @Test(dataProvider = "validEqualsProvider")
    public void testEquals(WelcomeMenu menu, WelcomeMenu anotherMenu) {
        System.out.println("equals");
        Assert.assertTrue(menu.equals(anotherMenu));
    }
    
    /**
     * Test of equals method, of class WelcomeMenu.
     * @param menu
     * @param anotherMenu
     */
    @Test(dataProvider = "invalidEqualsProvider")
    public void testNotEquals(WelcomeMenu menu, Object anotherMenu) {
        System.out.println("equals");
        Assert.assertFalse(menu.equals(anotherMenu));
    }

    
    @DataProvider(name = "validMenuProvider")
    private Object[][] provideValidMenu() {
        return new Object[][]{
            {new WelcomeMenu("en")},
            {new WelcomeMenu("pt")}
        };
    }
    
    @DataProvider(name = "validEqualsProvider")
    private Object[][] provideValidEqualsData() {
        return new Object[][]{
            {new WelcomeMenu("en"), new WelcomeMenu("en")},
            {new WelcomeMenu("pt"), new WelcomeMenu("pt")}
        };
    }

    @DataProvider(name = "invalidEqualsProvider")
    private Object[][] provideInvalidEqualsData() {
        return new Object[][]{
            {new WelcomeMenu("en"), new WelcomeMenu("pt")},
            {new WelcomeMenu("pt"), new WelcomeMenu("en")},
            {new WelcomeMenu("en"), null},
            {new WelcomeMenu("pt"), "pt"},
            
        };
    }

}
