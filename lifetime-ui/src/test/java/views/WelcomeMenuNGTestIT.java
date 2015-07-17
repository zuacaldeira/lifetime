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
package views;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import ui.TestBundle;

/**
 *
 * @author zua
 */
@Test
@RunAsClient
public class WelcomeMenuNGTestIT extends LifetimeArquillian {
    
    /**
     * Arquillian ready selenium web driver
     */
    @Drone
    private ChromeDriver webDriver;
    
    /**
     * Test of getHomeButton method, of class WelcomeMenu.
     */
    @Test
    public void testGetHomeButton() {
        getLogger().debug("testGetHomeButton");
        /**
         * If the web driver is injected then navigate to welcome page.
         */
        Assert.assertNotNull(webDriver);
        webDriver.get(TestBundle.WELCOME_URL);
        /**
         * Find the home button.
         */
        WebElement homeButton = webDriver.findElement(By.className(StyleClassName.V_BUTTON_HOME));
        Assert.assertNotNull(homeButton);        
    }

    /**
     * Test of getRegisterButton method, of class WelcomeMenu.
     */
    @Test
    public void testGetRegisterButton() {
        getLogger().debug("testGetRegisterButton");
        Assert.assertNotNull(webDriver);        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoginButton method, of class WelcomeMenu.
     */
    @Test
    public void testGetLoginButton() {
        getLogger().debug("testGetLoginButton");
        Assert.assertNotNull(webDriver);        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContactButton method, of class WelcomeMenu.
     */
    @Test
    public void testGetContactButton() {
        getLogger().debug("testGetContactButton");
        Assert.assertNotNull(webDriver);        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class WelcomeMenu.
     */
    @Test
    public void testHashCode() {
        getLogger().debug("testHashCode");
        Assert.assertNotNull(webDriver);        
    }

    /**
     * Test of equals method, of class WelcomeMenu.
     */
    @Test
    public void testEquals() {
        getLogger().debug("testEquals");
        Assert.assertNotNull(webDriver);        
    }
    
}
