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

import lifetime.view.custom.LifetimeButtonLink;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class LifetimeMenuNGTest {

    public LifetimeMenuNGTest() {
    }

    /**
     * Test of getLanguage method, of class LifetimeMenu.
     */
    @Test
    public void testGetLanguage() {
        System.out.println("getLanguage");
        String pt = "pt";
        LifetimeMenu menu = new LifetimeMenu(pt) {

            @Override
            protected void addControls() {
            }
        };
        assertEquals(menu.getLanguage(), pt);
    }

    /**
     * Test of addControl method, of class LifetimeMenu.
     */
    @Test
    public void testAddControl() {
        System.out.println("addControl");
        String pt = "pt";
        String caption = "caption";
        String language = "language";

        LifetimeMenu menu = new LifetimeMenu(pt) {
            @Override
            protected void addControls() {
            }
        };
        LifetimeButtonLink b1 = new LifetimeButtonLink(caption, language, null);
        LifetimeButtonLink b2 = new LifetimeButtonLink(caption, language, null);
        menu.addControl(b1);
        menu.addControl(b2);
        assertTrue(true);
    }

}
