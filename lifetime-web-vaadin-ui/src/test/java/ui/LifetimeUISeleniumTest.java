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
package ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.AbsoluteLayoutElement;
import com.vaadin.testbench.elements.HorizontalLayoutElement;
import com.vaadin.testbench.elements.VerticalLayoutElement;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class LifetimeUISeleniumTest extends TestBenchTestCase {

    public LifetimeUISeleniumTest() {
    }

    /**
     *
     * @throws Exception
     */
    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
        ChromeDriver webDriver = new ChromeDriver();
        setDriver(webDriver);
    }

    /**
     *
     * @throws Exception
     */
    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
        getDriver().quit();
    }

    /**
     * Test of init method, of class LifetimeUI. Visits the application.
     */
    @Test
    public void testInit() {
        // Enter application
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> LifetimeUISeleniumTest#testInit()");
        getDriver().get(TestBundle.WELCOME_URL);
    }

    /**
     * Test of getMenu method, of class LifetimeUI.
     */
    @Test
    public void testGetMenu() {
        // Enter application
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> LifetimeUISeleniumTest#testGetLanguage()");
        getDriver().get(TestBundle.WELCOME_URL);
        // Asserts the menu exists
        HorizontalLayoutElement menu = $(HorizontalLayoutElement.class).first();
        Assert.assertNotNull(menu);
    }

    /**
     * Test of getLifetimeView method, of class LifetimeUI.
     */
    @Test
    public void testGetLifetimeView() {
        // Enter application
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> LifetimeUISeleniumTest#testGetLifetimeView()");
        getDriver().get(TestBundle.WELCOME_URL);
        // Asserts the component exists
        HorizontalLayoutElement content = $$(AbsoluteLayoutElement.class).$$(VerticalLayoutElement.class).$$(VerticalLayoutElement.class).$$(HorizontalLayoutElement.class).first();
        Assert.assertNotNull(content);
    }

    public class LifetimeUIImpl extends LifetimeUI {

        public void init(VaadinRequest request) {
        }
    }

}
