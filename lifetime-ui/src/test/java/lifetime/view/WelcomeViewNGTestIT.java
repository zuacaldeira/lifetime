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

import java.io.File;
import java.util.List;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
public class WelcomeViewNGTestIT extends LifetimeArquillian {

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
        return Deployments.getDeploymentWelcomeView();
    }

    private static class Deployments {

        public static Archive getDeploymentWelcomeView() {
            WebArchive result = ShrinkWrap.create(WebArchive.class, "test.war")
                    //.addAsLibraries(files)
                    .addAsResource(new File("src/main/resources/META-INF/persistence.xml"),
                            "META-INF/persistence.xml")
                    .addAsResource(EmptyAsset.INSTANCE,
                            ArchivePaths.create("beans.xml"));
            return result;
        }
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
        getLogger().info("IT-TEST: testWelcomeViewStructure()".toUpperCase());
        Assert.assertNotNull(webDriver, "Drone web driver not injected.");

        webDriver.get(TestBundle.HOME_URL);
        getLogger().info("Page title: " + webDriver.getTitle());
        
        /**
         * Has a top level element...
         */
        getLogger().info("Looking for a lifetime page...");
        List<WebElement> lifetimeWebPage = webDriver.findElements(By.xpath("*"));
        getLogger().info("Found: " + lifetimeWebPage);
        Assert.assertFalse(lifetimeWebPage.isEmpty());
        /**
         * Has a welcome ui...
         */
        getLogger().info("Looking for a lifetime ui...");
        WebElement lifetimeUi = lifetimeWebPage.get(0).findElement(By.xpath(".//div[@id='lifetime-ui']"));
        getLogger().info("Found: " + lifetimeUi);
        Assert.assertNotNull(lifetimeUi);
        /**
         * with a welcome view...
         */
        getLogger().info("Looking for a lifetime view...");
        WebElement lifetimeView = lifetimeUi.findElement(By.xpath(".//div[@id='lifetime-view']"));
        getLogger().info("Found: " + lifetimeView);
        Assert.assertNotNull(lifetimeView);

        /**
         * and with a welcome menu...
         */
        getLogger().info("Looking for a lifetime menu...");
        WebElement lifetimeMenu = lifetimeView.findElement(By.xpath(".//div[@id='lifetime-menu']"));
        getLogger().info("Found: " + lifetimeMenu);
        Assert.assertNotNull(lifetimeMenu);
        /**
         * and a welcome content.
         */
        getLogger().info("Looking for a lifetime content...");
        WebElement lifetimeContent = lifetimeView.findElement(By.xpath(".//div[@id='lifetime-content']"));
        getLogger().info("Found: " + lifetimeContent);
        Assert.assertNotNull(lifetimeContent);
        webDriver.close();
    }
}
