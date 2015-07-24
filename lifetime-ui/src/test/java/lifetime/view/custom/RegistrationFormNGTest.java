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
package lifetime.view.custom;

import java.util.Date;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class RegistrationFormNGTest {

    public RegistrationFormNGTest() {
    }

    /**
     * Test of getFirstname method, of class RegistrationForm.
     */
    @Test
    public void testGetFirstname() {
        System.out.println("getFirstname");
        String firstname = "firstname";
        String language = "en";
        RegistrationForm instance = new RegistrationForm(language);
        assertNotNull(instance.getFirstname());
        instance.getFirstname().setValue(firstname);
        Assert.assertEquals(instance.getFirstname().getValue(), firstname);
    }

    /**
     * Test of getLastname method, of class RegistrationForm.
     */
    @Test
    public void testGetLastname() {
        System.out.println("getLastname");
        String lastname = "lastname";
        String language = "en";
        RegistrationForm instance = new RegistrationForm(language);
        assertNotNull(instance.getLastname());
        instance.getLastname().setValue(lastname);
        Assert.assertEquals(instance.getLastname().getValue(), lastname);
    }

    /**
     * Test of getEmail method, of class RegistrationForm.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String email = "email@g.com";
        String language = "en";
        RegistrationForm instance = new RegistrationForm(language);
        assertNotNull(instance.getEmail());
        instance.getEmail().setValue(email);
        Assert.assertEquals(instance.getEmail().getValue(), email);
    }

    /**
     * Test of getPassword method, of class RegistrationForm.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String password = "pass";
        String language = "en";
        RegistrationForm instance = new RegistrationForm(language);
        assertNotNull(instance.getPassword());
        instance.getPassword().setValue(password);
        Assert.assertEquals(instance.getPassword().getValue(), password);
    }

    /**
     * Test of getPasswordRepeat method, of class RegistrationForm.
     */
    @Test
    public void testGetPasswordRepeat() {
        System.out.println("getPasswordRepeat");
        String passwordRepeat = "lastname";
        String language = "en";
        RegistrationForm instance = new RegistrationForm(language);
        assertNotNull(instance.getPasswordRepeat());
        instance.getPasswordRepeat().setValue(passwordRepeat);
        Assert.assertEquals(instance.getPasswordRepeat().getValue(), passwordRepeat);
    }

    /**
     * Test of getDefaultLanguage method, of class RegistrationForm.
     */
    @Test
    public void testGetDefaultLanguage() {
        System.out.println("getDefaultLanguage");
        String language = "en";
        RegistrationForm instance = new RegistrationForm(language);
        assertNotNull(instance.getDefaultLanguage());
        instance.getDefaultLanguage().setValue(language);
        Assert.assertEquals(instance.getDefaultLanguage().getValue(), language);
    }

    /**
     * Test of getBirthDate method, of class RegistrationForm.
     */
    @Test
    public void testGetBirthDate() {
        System.out.println("getBirthDate");
        Date birthdate = new Date();
        String language = "en";
        RegistrationForm instance = new RegistrationForm(language);
        assertNotNull(instance.getBirthDate());
        instance.getBirthDate().setValue(birthdate);
        Assert.assertEquals(instance.getBirthDate().getValue(), birthdate);
    }

    /**
     * Test of clear method, of class RegistrationForm.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Date birthdate = new Date();
        String language = "en";
        RegistrationForm instance = new RegistrationForm(language);
        assertNotNull(instance.getBirthDate());
        instance.getBirthDate().setValue(birthdate);
        Assert.assertEquals(instance.getBirthDate().getValue(), birthdate);
        instance.clear();
        Assert.assertNull(instance.getBirthDate().getValue());
    }

    /**
     * Test of submit method, of class RegistrationForm.
     */
    @Test(expectedExceptions = NullPointerException.class)
    public void testSubmit() {
        System.out.println("submit");
        Date birthdate = new Date();
        String language = "en";
        RegistrationForm instance = new RegistrationForm(language);
        assertNotNull(instance.getBirthDate());
        instance.getBirthDate().setValue(birthdate);
        Assert.assertEquals(instance.getBirthDate().getValue(), birthdate);
        instance.submit();
        Assert.assertNull(instance.getBirthDate());
    }

    /**
     * Test of hashCode method, of class RegistrationForm.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Date birthdate = new Date();
        String language = "en";
        RegistrationForm instance = new RegistrationForm(language);
        RegistrationForm instance2 = new RegistrationForm(language);
        instance.getBirthDate().setValue(birthdate);
        instance2.getBirthDate().setValue(birthdate);
        Assert.assertEquals(instance.hashCode(), instance2.hashCode());
    }

    /**
     * Test of equals method, of class RegistrationForm.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Date birthdate = new Date();
        String language = "en";
        RegistrationForm instance = new RegistrationForm(language);
        RegistrationForm instance2 = new RegistrationForm(language);
        instance.getBirthDate().setValue(birthdate);
        instance2.getBirthDate().setValue(birthdate);
        Assert.assertTrue(instance.equals(instance2));
    }

}
