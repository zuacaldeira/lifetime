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

import org.openqa.selenium.chrome.ChromeDriver;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.ImageElement;
import data.RegistrationDataProvider;
import org.testng.Assert;
import ui.TestBundle;

/**
 *
 * @author zua
 */
public class WelcomeViewNGTestIT extends TestBenchTestCase {

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
     *
     */
    @org.testng.annotations.Test
    public void testBackgroundExistence() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> WelcomeViewSeleniumTest#testBackgroundExistence");
        getDriver().get("http://localhost:8080/vitae");
        // Get backgroud
        ImageElement background = $(ImageElement.class).caption("").first();
        Assert.assertNotNull(background);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

    /**
     *
     * @param firstname
     * @param lastname
     * @param email
     * @param password1
     * @param password2
     */
    @org.testng.annotations.Test(dataProviderClass = RegistrationDataProvider.class, dataProvider = "positive")
    public void testRegisterButton(String firstname, String lastname, String email, String password1, String password2) {
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>> WelcomeViewSeleniumTest#testRegisterButtonExistence");
        getDriver().get("http://localhost:8080/vitae");
        // Get Register Button
        ButtonElement registerButton = $(ButtonElement.class).caption("Register").first();
        Assert.assertNotNull(registerButton);
        // Click button. Should take us to the Registration Form
        registerButton.click();
        // Assert we've navigated to user area
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, TestBundle.REGISTER_URL);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

    //@Test(dataProviderClass = LoginDataProvider.class, dataProvider = "positive")

    /**
     *
     * @param username
     * @param password
     */
        public void testLoginButton(String username, String password) {
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>> WelcomeViewSeleniumTest#testLoginButtonExistence");
        getDriver().get("http://localhost:8080/vitae");
        // Get Login Botton
        ButtonElement loginButton = $(ButtonElement.class).caption("Login").first();
        Assert.assertNotNull(loginButton);
        // Click
        loginButton.click();
        // Assert we've navigated to user area
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, TestBundle.LOGIN_URL);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

    /**
     *
     */
    @org.testng.annotations.Test
    public void testContactButton() {
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>> WelcomeViewSeleniumTest#testContactButtonExistence");
        getDriver().get("http://localhost:8080/vitae");
        // Get Contact Button
        ButtonElement contactButton = $(ButtonElement.class).caption("Contact").first();
        Assert.assertNotNull(contactButton);
        // Click button. Should take us to the Registration Form
        contactButton.click();
        // Assert we've navigated to contact area
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, TestBundle.CONTACT_URL);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

}
