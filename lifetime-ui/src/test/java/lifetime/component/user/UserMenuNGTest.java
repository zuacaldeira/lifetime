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
package lifetime.component.user;

import lifetime.TestHelper;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class UserMenuNGTest {

    public UserMenuNGTest() {
    }

    /**
     * Test of buttonClick method, of class UserMenu.
     */
    @Test
    public void testButtonClick() {
        System.out.println("buttonClick");
        UserMenu instance = new UserMenu(TestHelper.getRandomString(), "pt");
        Assert.assertTrue(instance.getHomeButton().isEnabled());
        Assert.assertTrue(instance.getVitaeButton().isEnabled());
        Assert.assertTrue(instance.getTimelineButton().isEnabled());
        Assert.assertTrue(instance.getYellowPagesButton().isEnabled());
    }

    /**
     * Test of hashCode method, of class UserMenu.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        String username = TestHelper.getRandomString();
        UserMenu instance = new UserMenu(username, "pt");
        UserMenu instance2 = new UserMenu(username, "pt");
        assertEquals(instance.hashCode(), instance2.hashCode());
    }

    /**
     * Test of equals method, of class UserMenu.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        String username = TestHelper.getRandomString();
        UserMenu instance = new UserMenu(username, "pt");
        UserMenu instance2 = new UserMenu(username, "pt");
        assertTrue(instance.equals(instance2));
    }

    /**
     * Test of equals method, of class UserMenu.
     */
    @Test
    public void testInequals() {
        System.out.println("inequals");
        String username = TestHelper.getRandomString();
        UserMenu instance = new UserMenu(username, "pt");
        UserMenu instance2 = new UserMenu(username, "en");
        UserMenu instance3 = null;
        Object instance4 = "Hi";
        assertFalse(instance.equals(instance2));
        assertFalse(instance.equals(instance3));
        assertFalse(instance.equals(instance4));
    }

    /**
     * Test getLifetimeButton.
     */
    @Test
    public void testGetLifetimeButton() {
        String username = TestHelper.getRandomString();
        UserMenu userMenu = new UserMenu(username, "pt");
        Assert.assertNotNull(userMenu.getTimelineButton());
    }

    /**
     * Test getVitaeButton.
     */
    @Test
    public void testGetVitaeButton() {
        String username = TestHelper.getRandomString();
        UserMenu userMenu = new UserMenu(username, "pt");
        Assert.assertNotNull(userMenu.getVitaeButton());
    }

    /**
     * Test getYellowPages.
     */
    @Test
    public void testGetYellowPages() {
        String username = TestHelper.getRandomString();
        UserMenu userMenu = new UserMenu(username, "pt");
        Assert.assertNotNull(userMenu.getYellowPagesButton());
    }
}
