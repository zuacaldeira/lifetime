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
package lifetime.view;

import lifetime.view.welcome.WelcomeMenu;
import com.vaadin.ui.Button;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Unit structural test for the welcome menu. Structural tests provide a mean to
 * ensure that the structure of a class is well instantiated.
 * <p>
 * The tests run as follow:
 * <ul>
 * <li>Create a new instance of {@link WelcomeMenuView}</li>
 * <li>Assert that all expected menu buttons were instantiated with the menu as
 * a listener to </li>
 * </ul>
 *
 * @author zua
 */
public class WelcomeMenuNGTest {

    /**
     * Test of getHomeButton method, of class WelcomeMenuView.
     */
    @Test
    public void testGetHomeButton() {
        // Creates a menu
        WelcomeMenu instance = new WelcomeMenu("en");
        // Ensures the menu internally inserted the home button
        assertNotNull(instance.getHomeButton(), "Missing Home Button");
        // Ensures the menu has registered as a listener to click events
        assertTrue(instance.getHomeButton().getListeners(Button.ClickEvent.class).toArray()[0] instanceof WelcomeMenu, "Missing Click Listener");
    }

    /**
     * Test of getRegisterButton method, of class WelcomeMenuView. This test
     * ensures: 1) The button is properly created; 2) a click listener is added
     * to the button and is of type WelcomeMenu
     */
    @Test
    public void testGetRegisterButton() {
        System.out.println("getRegisterButton");
        // Creates a menu
        WelcomeMenu instance = new WelcomeMenu("en");
        // Ensures the menu internally inserted the register button
        assertNotNull(instance.getRegisterButton(), "Missing Register Button");
        // Ensures the menu has registered itself as a listener to click events
        assertTrue(instance.getRegisterButton().getListeners(Button.ClickEvent.class).toArray()[0] instanceof WelcomeMenu, "Missing Click Listener");
    }

    /**
     * Test of getLoginButton method, of class WelcomeMenuView. This test
     * ensures that button is properly created with the welcome menu
     * self-registered to listen click events.
     */
    @Test
    public void testGetLoginButton() {
        // Creates a menu
        WelcomeMenu instance = new WelcomeMenu("en");
        // Ensures the menu internally inserted the login button
        assertNotNull(instance.getLoginButton(), "Missing Login Button");
        // Ensures the menu has registered itself as a listener to click events
        assertTrue(instance.getLoginButton().getListeners(Button.ClickEvent.class).toArray()[0] instanceof WelcomeMenu, "Missing Click Listener");
    }

    /**
     * Test of getContactButton method, of class WelcomeMenuView. This test
     * ensures: 1) The home button is properly created; 2) a click listener is
     * added to the button and is of type WelcomeMenu
     */
    @Test
    public void testGetContactButton() {
        System.out.println("getContactButton");
        // Creates a menu
        WelcomeMenu instance = new WelcomeMenu("en");
        // Ensures the menu internally inserted the contact button
        assertNotNull(instance.getContactButton(), "Missing Contact Button");
        // Ensures the menu has registered itself as a listener to click events
        assertTrue(instance.getContactButton().getListeners(Button.ClickEvent.class).toArray()[0] instanceof WelcomeMenu, "Missing Click Listener");
    }

}
