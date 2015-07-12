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
package unit.views;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Image;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import views.LifetimeBackground;
import views.LifetimeContent;
import views.LifetimeMenu;
import views.LifetimeView;

/**
 * Test of the abstract class {@link LifetimeView}, the top-level abstract
 * class, the central component for user interaction.
 * 
 * Given that the class is abstract, we will test on anonymous instances.
 *
 * @author zua
 */
public class LifetimeViewNGTest {

    /**
     *
     */
    @Test
    public void testGetBackground() {
        System.out.println("getBackground");
        LifetimeView instance = new LifetimeView("en") {
            
            @Override
            protected LifetimeMenu createMenu() {
                return new LifetimeMenu(getLanguage()){};
            }
            
            @Override
            protected LifetimeContent createContent() {
                return new LifetimeContent(getLanguage()){};
            }
            
            @Override
            protected LifetimeBackground createBackground() {
                return new LifetimeBackground(getLanguage(), new Image("", new ThemeResource("../img/background.jpg"))){};
            }
        };
        LifetimeBackground result = instance.getBackground();
        assertNotNull(result);
    }

    /**
     * Test of getMenu method, of class LifetimeView.
     */
    @Test
    public void testGetMenu() {
        System.out.println("getMenu");
        LifetimeView instance = new LifetimeView("en") {
            
            @Override
            protected LifetimeMenu createMenu() {
                return new LifetimeMenu(getLanguage()){};
            }
            
            @Override
            protected LifetimeContent createContent() {
                return new LifetimeContent(getLanguage()){};
            }
            
            @Override
            protected LifetimeBackground createBackground() {
                return new LifetimeBackground(getLanguage(), new Image("", new ThemeResource("../img/background.jpg"))){};
            }
        };
        LifetimeMenu result = instance.getMenu();
        assertNotNull(result);
    }

    /**
     * Test of getContent method, of class LifetimeView.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");
        LifetimeView instance = new LifetimeView("en") {
            
            @Override
            protected LifetimeMenu createMenu() {
                return new LifetimeMenu(getLanguage()){};
            }
            
            @Override
            protected LifetimeContent createContent() {
                return new LifetimeContent(getLanguage()){};
            }
            
            @Override
            protected LifetimeBackground createBackground() {
                return new LifetimeBackground(getLanguage(), new Image("", new ThemeResource("../img/background.jpg"))){};
            }
        };
        LifetimeContent result = instance.getContent();
        assertNotNull(result);
    }

    /**
     * Test of getLanguage method, of class LifetimeView.
     */
    @Test
    public void testGetLanguage() {
        System.out.println("getLanguage");
        LifetimeView instance = new LifetimeView("en") {
            
            @Override
            protected LifetimeMenu createMenu() {
                return new LifetimeMenu(getLanguage()){};
            }
            
            @Override
            protected LifetimeContent createContent() {
                return new LifetimeContent(getLanguage()){};
            }
            
            @Override
            protected LifetimeBackground createBackground() {
                return new LifetimeBackground(getLanguage(), new Image("", new ThemeResource("../img/background.jpg"))){};
            }
        };
        String result = instance.getLanguage();
        assertEquals(result, "en");
    }


}