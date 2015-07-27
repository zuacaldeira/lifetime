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
package usecase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
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
import org.testng.annotations.DataProvider;

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
public class ResgistrationUseCaseTestIT extends Arquillian {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Drone
    private ChromeDriver webDriver;

    public ResgistrationUseCaseTestIT() {
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
     * BEHAVIOURAL TESTS. Behavioral test to stress the registration use case.
     *
     * @param firstname
     * @param lastname
     * @param email
     * @param password
     * @param birthdate
     * @param passwordRepeat
     * @param birthPlace
     * **************************************************************************
     */
    @Test(dataProvider = "registration")
    public void testRegistration(String firstname, String lastname, String email, String password, String passwordRepeat, Date birthdate, String birthPlace) {
        getLogger().info("testRegistration()".toUpperCase());
        Assert.assertNotNull(webDriver, "Drone web driver not injected.");

        webDriver.get(TestBundle.HOME_URL);
        getLogger().info("Page title: " + webDriver.getTitle());

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        /**
         * Has a top level element...
         */
        getLogger().info("Looking for register button...");
        WebElement registerButton = webDriver.findElementByXPath(XPathIds.getXPathIdExpressionDIV(StyleClassName.REGISTER_BUTTON));
        Assert.assertNotNull(registerButton, "Register button not found!");

        // Click on button
        registerButton.click();

        // Check we're on the registration form
        getLogger().info("Looking for the form...");
        WebElement registrationForm = webDriver.findElementByXPath(XPathIds.getXPathIdExpressionDIV(StyleClassName.REGISTRATION_FORM));
        Assert.assertNotNull(registrationForm, "Registration form not found!");

        // Firstnames
        getLogger().info("Looking for the birth firstname...");
        WebElement weFirstnames = webDriver.findElementByXPath(XPathIds.getXPathIdExpressionINPUT(StyleClassName.REGISTRATION_FORM_FIRSTNAME));
        weFirstnames.sendKeys(firstname);

        // Lastnames
        getLogger().info("Looking for the lastname...");
        WebElement weLastname = webDriver.findElementByXPath(XPathIds.getXPathIdExpressionINPUT(StyleClassName.REGISTRATION_FORM_LASTNAME));
        weLastname.sendKeys(lastname);

        // Email
        getLogger().info("Looking for the email...");
        WebElement weEmail = webDriver.findElementByXPath(XPathIds.getXPathIdExpressionINPUT(StyleClassName.REGISTRATION_FORM_EMAIL));
        weEmail.sendKeys(email);

        // Password        
        getLogger().info("Looking for the password...");
        WebElement wePassword = webDriver.findElementByXPath(XPathIds.getXPathIdExpressionINPUT(StyleClassName.REGISTRATION_FORM_PASSWORD));
        wePassword.sendKeys(password);
        // Password repeat
        getLogger().info("Looking for the repeat password...");
        WebElement wePasswordRepeat = webDriver.findElementByXPath(XPathIds.getXPathIdExpressionINPUT(StyleClassName.REGISTRATION_FORM_PASSWORD_REPEAT));
        wePasswordRepeat.sendKeys(passwordRepeat);

        // Birth date
        getLogger().info("Looking for the birth date...");
        WebElement weBirthdate = webDriver.findElementByXPath("//input[contains(@class, 'v-datefield')]");
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/YY");
        getLogger().info("Parsed date " + df.format(birthdate));
        
        weBirthdate.sendKeys(df.format(birthdate));

        // Birth place
        getLogger().info("Looking for the birth place...");
        WebElement weBirthplace = webDriver.findElementByXPath(XPathIds.getXPathIdExpressionINPUT(StyleClassName.REGISTRATION_FORM_BIRTHPLACE));
        weBirthplace.sendKeys(birthPlace);

        // Submit form
        getLogger().info("Looking for the ok button...");
        WebElement ok = webDriver.findElementByXPath(XPathIds.getXPathIdExpressionDIV(StyleClassName.OK_BUTTON));
        ok.click();
        
        getLogger().info("Wait for page to load...");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        getLogger().info("Looking for the welcome view...");
        WebElement welcome = webDriver.findElementByXPath(XPathIds.getXPathIdExpressionDIV(StyleClassName.WELCOME_VIEW));
        Assert.assertNotNull(welcome, "welcome view not found!");
        
        webDriver.close();
    }

    @DataProvider(name = "registration")
    private Object[][] provideRegistrationData() {
        return new Object[][]{
            {"Alexandre", "Zua Caldeira", "zuacaldeira@lifetime.com", "Password1!", "Password1!", new Date(), "Piri, Angola"}
        };
    }

}
