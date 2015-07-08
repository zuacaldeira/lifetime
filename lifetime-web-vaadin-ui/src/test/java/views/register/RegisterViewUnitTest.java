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
package views.register;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import views.RegisterContent;
import views.RegisterMenu;
import views.RegisterView;
import views.WelcomeBackground;

/**
 * Unit tests the {@code RegisterView}. A {@code RegisterView} is composed, as
 * any other {@code LifetimeView} of a menu and content views. We check that
 * {@code RegisterView} fulfills it's responsibilities providing implementations
 * for the background, menu and content adapter classes.
 *
 * @author zua
 */
public class RegisterViewUnitTest {

    /**
     * Test of getContent method, of class RegisterView. Creates a new instance
     * of the {@code RegisterView} and check that it has the content initialized
     * by the constructor. Additionally it also checks that the content adapter
     * is of type {@code RegisterContent}.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");
        RegisterView instance = new RegisterView("en");
        assertNotNull(instance.getContent());
        assertTrue(instance.getContent() instanceof RegisterContent);
    }

    /**
     * Test of createMenu method, of class RegisterView. Creates a new instance
     * of the {@code RegisterView} and check that it has the menu initialized by
     * the constructor. Additionally it also checks that the menu adapter is of
     * type {@code RegisterMenu}.
     * <p>
     * We do not call the method directly. It is executed at menu's creation
     * time. The {@link RegisterView#createMenu()} method. We check on the
     * object return by getter {@link RegisterView#getMenu()}
     */
    @Test
    public void testCreateMenu() {
        System.out.println("createMenu");
        RegisterView instance = new RegisterView("en");
        assertNotNull(instance.getMenu());
        assertTrue(instance.getMenu() instanceof RegisterMenu);
        // Create a new menu
    }

    /**
     * Test of createContent method, of class RegisterView. Creates a new
     * instance of the {@code RegisterView} and check that it has the content
     * initialized by the constructor. Additionally it also checks that the
     * content adapter is of type {@code RegisterContent}.
     * <p>
     * We do not call the method directly. It is executed at menu's creation
     * time. The {@link RegisterView#createContent()} method. We check on the
     * object return by getter {@link RegisterView#getContent()}
     * <p>
     * This test is equivalent to {@link RegisterViewNGTest#testGetContent()}.
     */
    @Test
    public void testCreateContent() {
        System.out.println("createContent");
        testGetContent();
    }

    /**
     * Test of createBackground method, of class RegisterView. Creates a new
     * instance of the {@code RegisterView} and check that it has the background
     * initialized by the constructor. Additionally it also checks that the menu
     * adapter is of type {@code RegisterMenu}.
     * <p>
     * We do not call the method directly. It is executed during the register
     * view creation time, by calling {@link RegisterView#createBackground()} in
     * the register view constructor. We check on the object return by getter
     * {@link RegisterView#getBackground()}
     */
    @Test
    public void testCreateBackground() {
        System.out.println("createBackground");
        RegisterView instance = new RegisterView("en");
        assertNotNull(instance.getBackground());
        assertTrue(instance.getBackground() instanceof WelcomeBackground);
    }

}
