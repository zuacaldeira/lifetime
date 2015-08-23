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
package lifetime.component.custom;

import lifetime.component.custom.LifetimeButton;
import lifetime.component.custom.LifetimeButtonLink;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class LifetimeButtonLinkNGTest  {

    /**
     * Test of getUsername method, of class LifetimeButton.
     */
    @Test
    public void testGetUserId() {
        System.out.println("testGetUserId()");
        String username = "username";
        String caption = "caption";
        String language = "pt";
        Resource icon = FontAwesome.ADJUST;
        LifetimeButton instance = new LifetimeButtonLink(username, language, caption, icon);
        assertEquals(instance.getUsername(), username);
    }

    /**
     * Test of getLanguage method, of class LifetimeButton.
     */
    @Test
    public void testGetLanguage() {
        System.out.println("testGetLanguage()");
        String username = "username";
        String caption = "caption";
        String language = "pt";
        Resource icon = FontAwesome.ADJUST;
        LifetimeButton instance = new LifetimeButtonLink(username, language, caption, icon);
        assertEquals(instance.getLanguage(), language);
    }

    /**
     * Test of showCaption method, of class LifetimeButton.
     */
    @Test
    public void testShowCaption() {
        System.out.println("testShowCaption()");
        String username = "username";
        String caption = "caption";
        String language = "pt";
        Resource icon = FontAwesome.ADJUST;
        LifetimeButton instance = new LifetimeButtonLink(username, language, caption, icon);
        instance.showCaption();
        assertNotNull(instance.getCaption());
    }

    /**
     * Test of hideCaption method, of class LifetimeButton.
     */
    @Test
    public void testHideCaption() {
        System.out.println("testHideCaption()");
        String username = "username";
        String caption = "caption";
        String language = "pt";
        Resource icon = FontAwesome.ADJUST;
        LifetimeButton instance = new LifetimeButtonLink(username, language, caption, icon);
        instance.hideCaption();
        assertNull(instance.getCaption());
    }

    /**
     * Test of hashCode method, of class LifetimeButton.
     */
    @Test
    public void testHashCode() {
        System.out.println("testHashCode()");
        String username = "username";
        String caption = "caption";
        String language = "pt";
        Resource icon = FontAwesome.ADJUST;
        LifetimeButton instance1 = new LifetimeButtonLink(username, language, caption, icon);
        LifetimeButton instance2 = new LifetimeButtonLink(username, language, caption, icon);
        assertEquals(instance1.hashCode(), instance2.hashCode());
    }

    /**
     * Test of equals method, of class LifetimeButton.
     */
    @Test
    public void testEquals() {
        System.out.println("testEquals()");
        String username = "username";
        String caption = "caption";
        String language = "pt";
        Resource icon = FontAwesome.ADJUST;
        LifetimeButton instance1 = new LifetimeButtonLink(username, language, caption, icon);
        LifetimeButton instance2 = new LifetimeButtonLink(username, language, caption, icon);
        assertTrue(instance1.equals(instance2));
    }
}
