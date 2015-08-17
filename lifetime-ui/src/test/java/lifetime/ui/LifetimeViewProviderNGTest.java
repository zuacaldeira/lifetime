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
package lifetime.ui;

import com.vaadin.navigator.ViewProvider;
import lifetime.view.welcome.WelcomeViewProvider;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class LifetimeViewProviderNGTest {

    public LifetimeViewProviderNGTest() {
    }

    /**
     * Test of getWelcomeViewProvider method, of class LifetimeViewProvider.
     */
    @Test
    public void testGetWelcomeViewProvider() {
        System.out.println("getWelcomeViewProvider");
        String language = "";
        WelcomeViewProvider result = LifetimeViewProvider.getWelcomeViewProvider(language);
        assertNotNull(result);
        assertTrue(result instanceof WelcomeViewProvider);
    }

    /**
     * Test of getUserViewProvider method, of class LifetimeViewProvider.
     */
    @Test
    public void testGetUserViewProvider() {
        System.out.println("getUserViewProvider");
        String username = "";
        String language = "";
        ViewProvider result = LifetimeViewProvider.getUserViewProvider(username, language);
        assertNotNull(result);
        assertTrue(result instanceof UserViewProvider);
    }

    /**
     * Test of getGuestViewProvider method, of class LifetimeViewProvider.
     */
    @Test
    public void testGetGuestViewProvider() {
        System.out.println("getGuestViewProvider");
        String username = "";
        String language = "";
        ViewProvider result = LifetimeViewProvider.getGuestViewProvider(username, language);
        assertNotNull(result);
        assertTrue(result instanceof UserViewProvider);
    }

}
