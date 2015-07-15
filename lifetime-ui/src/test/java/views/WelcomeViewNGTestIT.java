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

import java.io.File;
import lifetime.persistence.UserAccount;
import lifetime.service.LifetimeAccountBusiness;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

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

    private static final String TEST_APP_NAME = "drone.jar";

    @Drone
    private WebDriver webDriver;

    public WelcomeViewNGTestIT() {
    }

    @Deployment(testable = false)
    public static Archive createDeployment() {
        // pick up a deployment
        return Deployments.getDeploymentWelcomeView();
    }

    /**
     * *************************************************************************
     *
     * STRUCTURAL TESTS. Structural tests check if the UI component conforms
     * with the architectural and design requirements.
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
    public void testCreation() {
        Assert.assertNotNull(webDriver);
    }

    @Test
    public void testBehaviour() {
        Assert.assertNotNull(webDriver);
    }

    /**
     * Test of createMenu method, of class WelcomeView.
     */
    @Test
    public void testCreateMenu() {
        System.out.println("createMenu");
        Assert.assertNotNull(webDriver);
    }

    /**
     * Test of createContent method, of class WelcomeView.
     */
    @Test
    public void testCreateContent() {
        System.out.println("createContent");
    }

    /**
     * Test of createBackground method, of class WelcomeView.
     */
    @Test
    public void testCreateBackground() {
        System.out.println("createBackground");
    }

    /**
     * Factory of deployments or scenarios for this test case.
     *
     */
    private static class Deployments {

        public static Archive getDeploymentWelcomeView() {
            JavaArchive result = ShrinkWrap.create(JavaArchive.class, TEST_APP_NAME)
                    //.addAsLibraries(files)
                    .addPackage(LifetimeAccountBusiness.class.getPackage().getName())
                    .addPackage(UserAccount.class.getPackage().getName())
                    .addAsResource(new File("src/main/resources/META-INF/persistence.xml"),
                            "META-INF/persistence.xml")
                    .addAsResource(EmptyAsset.INSTANCE,
                            ArchivePaths.create("beans.xml"));
            return result;
        }
    }
}
