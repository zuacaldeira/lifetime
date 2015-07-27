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
import lifetime.ui.LifetimeViewProvider;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import lifetime.ui.TestBundle;
import lifetime.view.StyleClassName;
import org.jboss.arquillian.testng.Arquillian;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import usecase.XPathIds;

/**
 * Test suite for <b>structural, navigational and functional</b> requirements of
 * the welcome view. Structural requirements will check the view layout.
 * navigational and functional requirements are expressed and verified in terms
 * of a session type.
 *
 * @author zua
 */
@Test
@RunAsClient
public class WelcomeViewNGTestIT extends Arquillian {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Drone
    private ChromeDriver webDriver;

    public WelcomeViewNGTestIT() {
    }

    /**
     * Factory of deployments or scenarios for this test case.
     *
     * @return A web archive with the test application
     */
    @Deployment(testable = false)
    public static Archive createDeployment() {
        // pick up a deployment
        WebArchive result = ShrinkWrap.create(WebArchive.class, "test.war")
                //.addAsLibraries(files)
                .addAsResource(EmptyAsset.INSTANCE,
                        ArchivePaths.create("beans.xml"));
        return result;
    }

    private Logger getLogger() {
        return logger;
    }

    /**
     * *************************************************************************
     *
     * STRUCTURAL TESTS. Structural tests check if the LIFETIME_UI component
     * conforms with the architectural and design requirements.
     *
     * 1 - The only way to create a WelcomeView is via a factory method.
     * Constructor must be private or protected: 1.1) Fail to create a welcome
     * view via direct instantiation; 1.2) Create the view via
     * {@link LifetimeViewProvider}
     *
     * 2 - Creating a new welcome view will also create the associated menu and
     * content views: 2.1) Check <b>menu existence</b> and 2.2) Check
     * <b>content existence</b>
     *
     ***************************************************************************
     */
    @Test
    public void testWelcomeViewStructure() {
        getLogger().info("test_Welcome_View_Structure()".toUpperCase());
        Assert.assertNotNull(webDriver, "Drone web driver not injected.");

        webDriver.get(TestBundle.HOME_URL);
        getLogger().info("Page title: " + webDriver.getTitle());

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        /**
         * Has a top level ui element...
         */
        getLogger().info("Looking for a lifetime page...");
        WebElement lifetimeWebPage = webDriver.findElementByXPath(XPathIds.getXPathIdExpressionDIV(StyleClassName.WELCOME_UI));
        Assert.assertNotNull(lifetimeWebPage, "Lifetime page not found");
        /**
         * with a welcome view...
         */
        getLogger().info("Looking for a welcome view...");
        WebElement lifetimeView = webDriver.findElementByXPath(XPathIds.getXPathIdExpressionDIV(StyleClassName.WELCOME_VIEW));
        Assert.assertNotNull(lifetimeView, "Welcome View not found");

        /**
         * and with a welcome menu...
         */
        getLogger().info("Looking for a welcome menu...");
        WebElement lifetimeMenu = webDriver.findElementByXPath(XPathIds.getXPathIdExpressionDIV(StyleClassName.WELCOME_MENU));
        Assert.assertNotNull(lifetimeMenu, "Welcome Menu not found");
        /**
         * and a welcome content.
         */
        getLogger().info("Looking for a welcome content...");
        WebElement lifetimeContent = webDriver.findElementByXPath(XPathIds.getXPathIdExpressionDIV(StyleClassName.WELCOME_CONTENT));
        Assert.assertNotNull(lifetimeContent, "Welcome Content not found");
        webDriver.close();
    }
}
