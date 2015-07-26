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

import lifetime.view.welcome.register.RegisterMenu;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class WelcomeViewNGTest {

    public WelcomeViewNGTest() {
    }

    /**
     * Test of createMenu method, of class WelcomeView.
     * @param instance
     */
    @Test(dataProvider = "valid")
    public void testCreateMenu(WelcomeView instance) {
        System.out.println("testCreateMenu()");
        Assert.assertNotNull(instance.createMenu());
    }

    /**
     * Test of createContent method, of class WelcomeView.
     * @param instance
     */
    @Test(dataProvider = "valid")
    public void testCreateContent(WelcomeView instance) {
        System.out.println("testCreateContent()");
        Assert.assertNotNull(instance.createContent());
    }

    /**
     * Test of createBackground method, of class WelcomeView.
     * @param instance
     */
    @Test(dataProvider = "valid")
    public void testCreateBackground(WelcomeView instance) {
        System.out.println("testCreateBackground()");
        Assert.assertNotNull(instance.createBackground());
    }
    
    @Test(dataProvider = "validEquals")
    public void testHashCode(WelcomeView instance, WelcomeView other) {
        System.out.println("testEquals()");
        Assert.assertEquals(instance.hashCode(), other.hashCode());
    }

    @Test(dataProvider = "validEquals")
    public void testEquals(WelcomeView instance, WelcomeView other) {
        System.out.println("testHashCode()");
        Assert.assertTrue(instance.equals(other));
    }

    @Test(dataProvider = "invalidEquals")
    public void testNotEquals(WelcomeView instance, Object other) {
        System.out.println("testNotEquals()");
        Assert.assertFalse(instance.equals(other));
    }

    
    @DataProvider(name = "valid")
    private Object[][] getValidData() {
        WelcomeView wv1 = new WelcomeView("en");
        WelcomeView wv2 = new WelcomeView("pt");
        return new Object[][]{{wv1}, {wv2}};
    }

    @DataProvider(name = "validEquals")
    private Object[][] getEqualsData() {
        WelcomeView wv1 = new WelcomeView("en");
        WelcomeView wv2 = new WelcomeView("pt");
        return new Object[][]{{wv1, wv1}, {wv2, wv2}};
    }

    @DataProvider(name = "invalidEquals")
    private Object[][] getNotEqualsData() {
        WelcomeView wv1 = new WelcomeView("en");
        WelcomeView wv2 = new WelcomeView("pt");
        return new Object[][]{{wv1, wv2}, {wv2, wv1}, {wv1, null}, {wv1, ""}};
    }

}
