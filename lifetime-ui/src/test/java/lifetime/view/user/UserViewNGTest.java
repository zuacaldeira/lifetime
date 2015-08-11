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
package lifetime.view.user;

import lifetime.backend.util.TestHelper;
import lifetime.view.LifetimeBackground;
import lifetime.view.LifetimeContent;
import lifetime.view.LifetimeMenu;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class UserViewNGTest {

    public UserViewNGTest() {
    }

    /**
     * Test of createMenu method, of class UserView.
     */
    @Test
    public void testCreateMenu() {
        System.out.println("createMenu");
        String username = TestHelper.getRandomString();
        UserView view = new UserView(username, "pt");
        LifetimeMenu menu = view.getMenu();
        Assert.assertNotNull(menu);
        assertTrue(menu instanceof UserMenu);

    }

    /**
     * Test of createContent method, of class UserView.
     */
    @Test
    public void testCreateContent() {
        System.out.println("createContent");
        String username = TestHelper.getRandomString();
        UserView view = new UserView(username, "pt");
        LifetimeContent content = view.getContent();
        Assert.assertNotNull(content);
        assertTrue(content instanceof UserContent);
    }

    /**
     * Test of createBackground method, of class UserView.
     */
    @Test
    public void testCreateBackground() {
        System.out.println("createBackground");
        String username = TestHelper.getRandomString();
        UserView view = new UserView(username, "pt");
        LifetimeBackground background = view.getBackground();
        Assert.assertNotNull(background);
        assertTrue(background instanceof UserBackground);
    }

}
