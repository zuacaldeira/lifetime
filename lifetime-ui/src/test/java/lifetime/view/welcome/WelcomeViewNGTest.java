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
package lifetime.view.welcome;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class WelcomeViewNGTest {

    public WelcomeViewNGTest() {
    }

    /**
     * Test of createMenu method, of class WelcomeView.
     */
    @Test
    public void testCreateMenu() {
        System.out.println("testCreateMenu()");
        WelcomeView instance = new WelcomeView("en");
        Assert.assertNotNull(instance.createMenu());
    }

    /**
     * Test of createContent method, of class WelcomeView.
     */
    @Test
    public void testCreateContent() {
        System.out.println("testCreateContent()");
        WelcomeView instance = new WelcomeView("en");
        Assert.assertNotNull(instance.createContent());
    }

    /**
     * Test of createBackground method, of class WelcomeView.
     */
    @Test
    public void testCreateBackground() {
        System.out.println("testCreateBackground()");
        WelcomeView instance = new WelcomeView("en");
        Assert.assertNotNull(instance.createBackground());
    }

}
