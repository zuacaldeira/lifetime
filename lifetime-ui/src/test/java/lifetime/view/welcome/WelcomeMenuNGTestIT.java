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

import java.util.concurrent.TimeUnit;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import lifetime.ui.TestBundle;
import lifetime.view.LifetimeArquillian;
import lifetime.util.StyleClassName;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import usecase.XPathByIds;

/**
 * @author <a href="mailto:zuacaldeira@gmail.com">Alexandre Caldeira</a>
 */
@Test
@RunAsClient
public class WelcomeMenuNGTestIT extends LifetimeArquillian {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Arquillian ready selenium web driver
     */
    @Drone
    private ChromeDriver webDriver;

    /**
     * Factory of deployments or scenarios for this test case.
     *
     * @return A web archive with the test application
     */
    @Deployment(testable = false)
    public static Archive createDeployment() {
        // pick up a deployment
        WebArchive result = ShrinkWrap.create(WebArchive.class, "WelcomeMenuNGTestIT.war")
                //.addAsLibraries(files)
                .addAsResource(EmptyAsset.INSTANCE,
                        ArchivePaths.create("beans.xml"));
        return result;
    }

    private Logger getLogger() {
        return logger;
    }

    /**
     * Test of getHomeButton method, of class WelcomeMenu.
     */
    @Test
    public void testWelcomeMenuStructure() {
        getLogger().info("test_Welcome_Menu_Structure()".toUpperCase());
        Assert.assertNotNull(webDriver, "Drone web driver not injected.");

        webDriver.get(TestBundle.HOME_URL);
        getLogger().info("Page title: " + webDriver.getTitle());

        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        /**
         * Has a welcome menu...
         */
        getLogger().info("Looking for a lifetime menu...");
        WebElement lifetimeMenu = webDriver.findElementByXPath(XPathByIds.getXPathIdExpressionDIV(StyleClassName.WELCOME_MENU.getId()));
        Assert.assertNotNull(lifetimeMenu, "Lifetime menu not found");

        /**
         * with a login button...
         */
        getLogger().info("Looking for the login button...");
        WebElement loginButton = webDriver.findElementByXPath(XPathByIds.getXPathIdExpressionDIV(StyleClassName.LOGIN_BUTTON.getId()));
        Assert.assertNotNull(loginButton, "Login button not found");

        /**
         * with a login button...
         */
        getLogger().info("Looking for the register button...");
        WebElement registerButton = webDriver.findElementByXPath(XPathByIds.getXPathIdExpressionDIV(StyleClassName.REGISTER_BUTTON.getId()));
        Assert.assertNotNull(registerButton, "Register button not found");

        /**
         * with a contact button...
         */
        getLogger().info("Looking for the contact button...");
        WebElement contactButton = webDriver.findElementByXPath(XPathByIds.getXPathIdExpressionDIV(StyleClassName.CONTACT_BUTTON.getId()));
        Assert.assertNotNull(contactButton, "Contact button not found");

        // That's it!
        webDriver.close();
    }

}
