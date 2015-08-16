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

import util.TestBundle;
import lifetime.util.StyleClassName;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import usecase.XPathByIds;

/**
 *
 * @author zua
 */
public class CrudMenuNGTestIT extends Arquillian {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Drone
    private ChromeDriver webDriver;

    public CrudMenuNGTestIT() {
    }

    /**
     * Factory of deployments or scenarios for this test case.
     *
     * @return A web archive with the test application
     */
    @Deployment(testable = false)
    public static Archive createDeployment() {
        // pick up a deployment
        WebArchive result = ShrinkWrap.create(WebArchive.class, "CrudMenuNGTestIT.war")
                //.addAsLibraries(files)
                .addAsResource(EmptyAsset.INSTANCE,
                        ArchivePaths.create("beans.xml"));
        return result;
    }

    /**
     * Test of addControls method, of class CrudMenu.
     */
    @Test
    public void testAddControls() {
        System.out.println("addControls IT");
        // load page lifetime/user#!vitae
        webDriver.get(TestBundle.VITAE_URL);
        // Find the add button
        WebElement profile = webDriver.findElementByXPath(XPathByIds.getXPathIdExpressionINPUT(StyleClassName.BACK_TO_PROFILE_BUTTON.getId()));
        WebElement cButton = webDriver.findElementByXPath(XPathByIds.getXPathIdExpressionINPUT(StyleClassName.C_BUTTON.getId()));
        WebElement rButton = webDriver.findElementByXPath(XPathByIds.getXPathIdExpressionINPUT(StyleClassName.R_BUTTON.getId()));
        WebElement uButton = webDriver.findElementByXPath(XPathByIds.getXPathIdExpressionINPUT(StyleClassName.U_BUTTON.getId()));
        WebElement dButton = webDriver.findElementByXPath(XPathByIds.getXPathIdExpressionINPUT(StyleClassName.D_BUTTON.getId()));
        
        Assert.assertNotNull(profile);
        Assert.assertNotNull(cButton);
        Assert.assertNotNull(rButton);
        Assert.assertNotNull(uButton);
        Assert.assertNotNull(dButton);
    }

}
