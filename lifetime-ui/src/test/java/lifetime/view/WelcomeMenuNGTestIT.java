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

import java.util.List;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import lifetime.ui.TestBundle;
import org.openqa.selenium.chrome.ChromeDriver;

/**
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

    private List<WebElement> topElements;
    private WebElement lifetimeUI;
    private WebElement lifetimeView;
    private WebElement lifetimeMenu;

    /**
     * Test of getHomeButton method, of class WelcomeMenu.
     */
    @Test
    public void testGetHomeButton() {
        getLogger().info("IT-TEST: testGetHomeButton()".toUpperCase());
        Assert.assertNotNull(webDriver, "Drone web driver not injected.");
        webDriver.get(TestBundle.HOME_URL);
        getLogger().info("\tWeb page loaded");

        topElements = webDriver.findElements(By.xpath("*"));
        Assert.assertNotNull(topElements, "WebPage not found");
        Assert.assertFalse(topElements.isEmpty(), "WebPage not found");
        getLogger().info("\tFound content");

        lifetimeUI = topElements.get(0).findElement(By.xpath("*"));
        Assert.assertNotNull(lifetimeUI, "Lifetime UI not found");
        getLogger().info("\tFound lifetime-ui" + lifetimeUI.getText());
        // Find the menu
        lifetimeView = lifetimeUI.findElement(By.xpath(XPathHelper.getXPathExpression(StyleClassName.LIFETIME_VIEW)));
        Assert.assertNotNull(lifetimeView, "Lifetime VIEW not found");
        getLogger().info("\tFound lifetime-view" + lifetimeView.getText());

        lifetimeMenu = lifetimeView.findElement(By.xpath(XPathHelper.getXPathExpression(StyleClassName.LIFETIME_MENU)));
        Assert.assertNotNull(lifetimeMenu, "Lifetime MENU not found");
        getLogger().info("\tFound lifetime-Menu" + lifetimeMenu.getText());

        WebElement homeButton = lifetimeMenu.findElement(By.xpath(XPathHelper.getXPathExpression(StyleClassName.HOME_BUTTON)));
        Assert.assertNotNull(homeButton, "Home button not found");
        getLogger().info("\tFound home button" + homeButton.getText());
        homeButton.click();
        getLogger().info("\tClicked home button");
    }

}
