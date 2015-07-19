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

import java.util.Calendar;
import java.util.Date;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class RegisterFormNGTest {

    /**
     * Test correct instantiation. This means:
     * <ol>
     * <li>The language is initialized with the current user interaction
     * language</li>
     * <li>All expected fields exist (not null)</li>
     * <li>All other fields are empty ()</li>
     * <li>Every field has an non empty {@code Validator} list</li>
     * </ol>
     */
    @Test
    public void testFormAfterCreation() {
        System.out.println("valueChange");
        RegistrationForm instance = new RegistrationForm("en");
        // Assert that the language combo box has a value
        assertNotNull(instance.getDefaultLanguage(), "Language should be " + "en");
        /*
         * Assert all other fields are there and are empty
         */
        // Firstname
        assertNotNull(instance.getFirstname(), "Firstname field not initialized");
        assertTrue(instance.getFirstname().getValue().isEmpty(), "Firstname field should be empty after creation");
        // Lastname
        assertNotNull(instance.getLastname(), "Lastname field not initialized");
        assertTrue(instance.getLastname().getValue().isEmpty(), "Lastname field should be empty after creation");
        // email
        assertNotNull(instance.getEmail(), "Email field not initialized");
        assertTrue(instance.getEmail().getValue().isEmpty(), "Email field should be empty after creation");
        // password
        assertNotNull(instance.getPassword(), "Password field not initialized");
        assertTrue(instance.getPassword().getValue().isEmpty(), "Password field should be empty after creation");
        // password2
        assertNotNull(instance.getPasswordRepeat(), "Password (repeat) field not initialized");
        assertTrue(instance.getPasswordRepeat().getValue().isEmpty(), "Password  (repeat) field should be empty after creation");
    }

    /**
     * Test the behavior of valueChange method, of class RegistrationForm.
     *
     * {@link RegisterForm#valueChange(com.vaadin.data.Property.ValueChangeEvent),
     * listens to any value change inside the form. The validation is made
     * automatically by validators associated to each field. The method default
     * behavior does nothing: This test is reponsible to check that a value
     * change is correctly implemented.
     *
     * @param language
     * @param firstname
     * @param lastname
     * @param email
     * @param password
     * @param passwordRepeat
     * @param date
     */
    @Test(dataProvider = "positive")
    public void testDefaultLanguageValueChange(String language, String firstname, String lastname, String email, String password, String passwordRepeat, Date date) {
        System.out.println("valueChange");
        RegistrationForm instance = new RegistrationForm(language);
        assertEquals(instance.getDefaultLanguage().getValue(), language);
        instance.getDefaultLanguage().select("português");
        assertEquals(instance.getDefaultLanguage().getValue(), "português");
    }

    /**
     * Test of getFirstname method, of class RegistrationForm.
     * @param language
     * @param firstname
     * @param lastname
     * @param email
     * @param birthDate
     * @param passwordRepeat
     * @param password
     */
    @Test(dataProvider = "positive")
    public void testGetFirstname(String language, String firstname, String lastname, String email, String password, String passwordRepeat, Date birthDate) {
        System.out.println("getFirstname");
        RegistrationForm form = new RegistrationForm(language);
        // Fill form
        fill(form, firstname, lastname, email, password, passwordRepeat, birthDate);
        // Assert firstname was set
        assertNotNull(form.getFirstname().getValue(), "Firstname was not initialized");
        // Assert firstname has the correct value
        assertEquals(form.getFirstname().getValue(), firstname, "Invalid firstname");
    }

    /**
     * Test of getLastname method, of class RegistrationForm.
     * @param language
     * @param firstname
     * @param lastname
     * @param email
     * @param birthDate
     * @param passwordRepeat
     * @param password
     */
    @Test(dataProvider = "positive")
    public void testGetLastname(String language, String firstname, String lastname, String email, String password, String passwordRepeat, Date birthDate) {
        System.out.println("getLastname");
        RegistrationForm form = new RegistrationForm(language);
        // Fill form
        fill(form, firstname, lastname, email, password, passwordRepeat, birthDate);
        // Assert lastname was set
        assertNotNull(form.getLastname().getValue(), "Lastname was not initialized");
        // Assert lastname has the correct value
        assertEquals(form.getLastname().getValue(), lastname, "Invalid lastname");
    }

    /**
     * Test of getEmail method, of class RegistrationForm.

     * @param language
     * @param firstname
     * @param lastname
     * @param email
     * @param birthDate
     * @param passwordRepeat
     * @param password
     */
    @Test(dataProvider = "positive")
    public void testGetEmail(String language, String firstname, String lastname, String email, String password, String passwordRepeat, Date birthDate) {
        System.out.println("getEmail");
        RegistrationForm form = new RegistrationForm(language);
        // Fill form
        fill(form, firstname, lastname, email, password, passwordRepeat, birthDate);
        // Assert email was set
        assertNotNull(form.getEmail().getValue(), "Email was not initialized");
        // Assert email has the correct value
        assertEquals(form.getEmail().getValue(), email, "Invalid email");
    }

    /**
     * Test of getPassword method, of class RegistrationForm.
     * 
     * @param language
     * @param firstname
     * @param lastname
     * @param email
     * @param birthDate
     * @param passwordRepeat
     * @param password
     */
    @Test(dataProvider = "positive")
    public void testGetPassword(String language, String firstname, String lastname, String email, String password, String passwordRepeat, Date birthDate) {
        System.out.println("getPassword");
        RegistrationForm form = new RegistrationForm(language);
        // Fill form
        fill(form, firstname, lastname, email, password, passwordRepeat, birthDate);
        // Assert password was set
        assertNotNull(form.getPasswordRepeat().getValue(), "Password was not initialized");
        // Assert password has the correct value
        assertEquals(form.getPasswordRepeat().getValue(), passwordRepeat, "Invalid password");
    }

    /**
     * Test of getPasswordRepeat method, of class RegistrationForm.
     * 
     * @param language
     * @param firstname
     * @param lastname
     * @param email
     * @param birthDate
     * @param passwordRepeat
     * @param password
     */
    @Test(dataProvider = "positive")
    public void testGetPasswordRepeat(String language, String firstname, String lastname, String email, String password, String passwordRepeat, Date birthDate) {
        System.out.println("getPasswordRepeat");
        RegistrationForm form = new RegistrationForm(language);
        // Fill form
        fill(form, firstname, lastname, email, password, passwordRepeat, birthDate);
        // Assert password repetition was set
        assertNotNull(form.getPasswordRepeat().getValue(), "Password repetition was not initialized");
        // Assert password repetition has the correct value
        assertEquals(form.getPasswordRepeat().getValue(), passwordRepeat, "Invalid password repetition");
    }

    /**
     * Test of getDefaultLanguage method, of class RegistrationForm.
     *
     * @param language
     * @param firstname
     * @param lastname
     * @param email
     * @param birthDate
     * @param passwordRepeat
     * @param password
     */
    @Test(dataProvider = "positive")
    public void testGetDefaultLanguage(String language, String firstname, String lastname, String email, String password, String passwordRepeat, Date birthDate) {
        System.out.println("getDefaultLanguage");
        RegistrationForm form = new RegistrationForm(language);
        // Fill form
        fill(form, firstname, lastname, email, password, passwordRepeat, birthDate);
        // Assert default langauge was set
        assertNotNull(form.getDefaultLanguage().getValue(), "Default language was not initialized");
        // Assert the language field has the correct value
        assertEquals(form.getDefaultLanguage().getValue(), language, "Invalid language");
    }

    /**
     * Test of getBirthDate method, of class RegistrationForm.
     *
     * This test creates a registration from, fill it with test data, and checks
     * that birth date is as passed to the method.
     *
     * @param language
     * @param firstname
     * @param lastname
     * @param email
     * @param birthDate
     * @param passwordRepeat
     * @param password
     */
    @Test(dataProvider = "positive")
    public void testGetBirthDate(String language, String firstname, String lastname, String email, String password, String passwordRepeat, Date birthDate) {
        System.out.println("getBirthDate");
        RegistrationForm form = new RegistrationForm(language);
        // Fill form
        fill(form, firstname, lastname, email, password, passwordRepeat, birthDate);
        // Assert birth date was set
        assertNotNull(form.getBirthDate().getValue(), "Birth date was not initialized");
        // Assert the birthdate field has the actual birth date as value
        assertEquals(form.getBirthDate().getValue(), birthDate, "Invalid birth date");
    }

    /**
     *
     * @return
     */
    @DataProvider(name = "positive")
    public static Object[][] getData() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1974, 0, 20);
        Object[][] dataArray = {
            {"português - pt", "Alexandre 1", "Zua Caldeira 1", "zuacaldeira1@gmail.com", "unicidade", "unicidade", calendar.getTime()},
            {"english - en", "Alexandre 2", "Zua Caldeira 2", "zuacaldeira2@gmail.com", "unicidade", "unicidade", calendar.getTime()},
            {"deutsch - de", "Alexandre 3", "Zua Caldeira 3", "zuacaldeira3@gmail.com", "unicidade", "unicidade", calendar.getTime()}
        };
        return dataArray;
    }

    private void fill(RegistrationForm form, String firstname, String lastname, String email, String password, String passwordRepeat, Date birthDate) {
        form.getFirstname().setValue(firstname);
        form.getLastname().setValue(lastname);
        form.getEmail().setValue(email);
        form.getPassword().setValue(password);
        form.getPasswordRepeat().setValue(passwordRepeat);
        form.getBirthDate().setValue(birthDate);
    }

}
