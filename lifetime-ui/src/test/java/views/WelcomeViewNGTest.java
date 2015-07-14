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
package backend.views;

import com.vaadin.testbench.parallel.TestCategory;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import views.LifetimeBackground;
import views.LifetimeContent;
import views.LifetimeMenu;
import views.WelcomeBackground;
import views.WelcomeContent;
import views.WelcomeMenu;
import views.WelcomeView;

/**
 * This unit test is responsible to check that {@link WelcomeView} implements
 * correctly it's structural requirements. It must provide an implementation for
 * abstract methods, particularly those responsible for the initialization of
 * background, menu and view data.
 *
 * @author zua
 */
@TestCategory("Unit")
public class WelcomeViewNGTest {

    /**
     * Test of {@link WelcomeView#createMenu()}. Test that the the method
     * implements correctly the content menu adapter pattern, that is, that it
     * instantiates correctly the menu adapter on the super class.
     */
    @Test
    public void testCreateMenuView() {
        WelcomeView instance = new WelcomeView("en");
        LifetimeMenu result = instance.getMenu();
        assertNotNull(result, "Found NULL Menu");
        assertTrue(result instanceof WelcomeMenu, "Expecting " + WelcomeMenu.class + " but found " + result.getClass());
    }

    /**
     * Test of {@link WelcomeView#createContent()}. Test that the the method
     * implements correctly the content data adapter pattern, that is, that it
     * instantiates correctly the data adapter on the super class.
     */
    @Test
    public void testCreateContentView() {
        WelcomeView instance = new WelcomeView("en");
        LifetimeContent result = instance.getContent();
        assertNotNull(result, "Found NULL Content");
        assertTrue(result instanceof WelcomeContent, "Expecting " + WelcomeContent.class + " but found " + result.getClass());
    }

    /**
     * Test of {@link WelcomeView#createBackground()}. Test that the method
     * implements correctly the background adapter pattern, that is, that it
     * instantiates correctly the background adapter on the super class.
     */
    @Test
    public void testCreateBackground() {
        WelcomeView instance = new WelcomeView("en");
        LifetimeBackground back = instance.getBackground();
        assertNotNull(back, "Found NULL background");
        assertTrue(back instanceof WelcomeBackground, "Background should be an instance of " + WelcomeBackground.class);
    }

}
