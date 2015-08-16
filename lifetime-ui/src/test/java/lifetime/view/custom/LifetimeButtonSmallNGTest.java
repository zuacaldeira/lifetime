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
package lifetime.view.custom;

import com.vaadin.server.FontAwesome;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class LifetimeButtonSmallNGTest {

    /**
     * Test of getUsername method, of class LifetimeButton.
     *
     * @param instance
     */
    @Test(dataProvider = "valid")
    public void testGetUserId(LifetimeButtonSmall instance) {
        System.out.println("testGetUserId()");
        assertNotNull(instance.getUsername());
    }

    /**
     * Test of getLanguage method, of class LifetimeButton.
     *
     * @param instance
     */
    @Test(dataProvider = "valid")
    public void testGetLanguage(LifetimeButtonSmall instance) {
        System.out.println("testGetLanguage()");
        assertNotNull(instance.getLanguage());
    }

    /**
     * Test of showCaption method, of class LifetimeButton.
     *
     * @param instance
     */
    @Test(dataProvider = "valid")
    public void testShowCaption(LifetimeButtonSmall instance) {
        System.out.println("testShowCaption()");
        instance.showCaption();
        assertNotNull(instance.getCaption());
    }

    /**
     * Test of hideCaption method, of class LifetimeButton.
     *
     * @param instance
     */
    @Test(dataProvider = "valid")
    public void testHideCaption(LifetimeButtonSmall instance) {
        System.out.println("testHideCaption()");
        instance.hideCaption();
        assertNull(instance.getCaption());
    }

    /**
     * Test of hashCode method, of class LifetimeButton.
     *
     * @param instance1
     * @param instance2
     */
    @Test(dataProvider = "validEquals")
    public void testHashCode(LifetimeButtonSmall instance1, LifetimeButtonSmall instance2) {
        System.out.println("testHashCode()");
        assertEquals(instance1.hashCode(), instance2.hashCode());
    }

    /**
     * Test of equals method, of class LifetimeButton.
     *
     * @param instance1
     * @param instance2
     */
    @Test(dataProvider = "validEquals")
    public void testEquals(LifetimeButtonSmall instance1, LifetimeButtonSmall instance2) {
        System.out.println("testEquals()");
        assertTrue(instance1.equals(instance2));
    }

    @Test(dataProvider = "invalidEquals")
    public void testNotEquals(LifetimeButtonSmall instance1, Object instance2) {
        System.out.println("testEquals()");
        assertFalse(instance1.equals(instance2));
    }

    @DataProvider(name = "valid")
    private Object[][] getValidData() {
        LifetimeButtonSmall button = new LifetimeButtonSmall("username", "en", "a button", FontAwesome.ADJUST);
        LifetimeButtonSmall button2 = new LifetimeButtonSmall("username", "pt", "a button", FontAwesome.ADJUST);
        return new Object[][]{{button}, {button2}};
    }

    @DataProvider(name = "validEquals")
    private Object[][] getEqualsData() {
        LifetimeButtonSmall button = new LifetimeButtonSmall("username", "en", "a button", FontAwesome.ADJUST);
        LifetimeButtonSmall button2 = new LifetimeButtonSmall("username", "en", "a button", FontAwesome.ADJUST);
        return new Object[][]{{button, button}, {button2, button2}};
    }

    @DataProvider(name = "invalidEquals")
    private Object[][] getNotEqualsData() {
        LifetimeButtonSmall button = new LifetimeButtonSmall("username", "en", "a button", FontAwesome.ADJUST);
        LifetimeButtonSmall button2 = new LifetimeButtonSmall("username2", "en", "a button", FontAwesome.ADJUST);
        LifetimeButtonSmall button3 = new LifetimeButtonSmall("username", "pt", "a button", FontAwesome.ADJUST);

        return new Object[][]{{button, button2}, {button2, button}, {button, null}, {button, ""}, {button, button3}};
    }

}
