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

import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
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
     *
     * @param form
     */
    @Test(dataProvider = "valid")
    public void testGetFirstname(RegistrationForm form) {
        System.out.println("getFirstname");
        assertNotNull(form.getFirstname());
    }

    /**
     * Test of getLastname method, of class RegistrationForm.
     *
     * @param form
     */
    @Test(dataProvider = "valid")
    public void testGetLastname(RegistrationForm form) {
        System.out.println("getLastname");
        assertNotNull(form.getLastname());
    }

    /**
     * Test of getEmail method, of class RegistrationForm.
     *
     * @param form
     */
    @Test(dataProvider = "valid")
    public void testGetEmail(RegistrationForm form) {
        System.out.println("getEmail");
        assertNotNull(form.getEmail());
    }

    /**
     * Test of getPassword method, of class RegistrationForm.
     *
     * @param form
     */
    @Test(dataProvider = "valid")
    public void testGetPassword(RegistrationForm form) {
        System.out.println("getPassword");
        assertNotNull(form.getPassword());
    }

    /**
     * Test of getPasswordRepeat method, of class RegistrationForm.
     *
     * @param form
     */
    @Test(dataProvider = "valid")
    public void testGetPasswordRepeat(RegistrationForm form) {
        System.out.println("getPasswordRepeat");
        assertNotNull(form.getPasswordRepeat());
    }

    /**
     * Test of getDefaultLanguage method, of class RegistrationForm.
     *
     * @param form
     */
    @Test(dataProvider = "valid")
    public void testGetDefaultLanguage(RegistrationForm form) {
        System.out.println("getDefaultLanguage");
        assertNotNull(form.getDefaultLanguage());
    }

    /**
     * Test of getBirthDate method, of class RegistrationForm.
     *
     * @param form
     */
    @Test(dataProvider = "valid")
    public void testGetBirthDate(RegistrationForm form) {
        System.out.println("getBirthDate");
        assertNotNull(form.getBirthDate());
    }

    /**
     * Test of clear method, of class RegistrationForm.
     *
     * @param form
     */
    @Test(dataProvider = "valid")
    public void testClear(RegistrationForm form) {
        System.out.println("clear");
        form.clear();
    }

    /**
     * Test of submit method, of class RegistrationForm.
     *
     * @param form
     */
    @Test(dataProvider = "valid", expectedExceptions = NullPointerException.class)
    public void testSubmit(RegistrationForm form) {
        System.out.println("submit");
        form.submit();
    }

    /**
     * Test of hashCode method, of class RegistrationForm.
     *
     * @param instance
     * @param instance2
     */
    @Test(dataProvider = "validEquals")
    public void testHashCode(RegistrationForm instance, RegistrationForm instance2) {
        System.out.println("hashCode");
        Assert.assertTrue(instance.equals(instance2));
    }

    /**
     * Test of equals method, of class RegistrationForm.
     *
     * @param instance
     * @param instance2
     */
    @Test(dataProvider = "validEquals")
    public void testEquals(RegistrationForm instance, RegistrationForm instance2) {
        System.out.println("equals");
        Assert.assertTrue(instance.equals(instance2));
    }

    /**
     * Test of equals method, of class RegistrationForm.
     *
     * @param instance
     * @param instance2
     */
    @Test(dataProvider = "invalidEquals")
    public void testNotEquals(RegistrationForm instance, Object instance2) {
        System.out.println("equals");
        Assert.assertFalse(instance.equals(instance2));
    }

    @DataProvider(name = "valid")
    private Object[][] getValidData() {
        RegistrationForm rv1 = new RegistrationForm("en");
        RegistrationForm rv2 = new RegistrationForm("pt");
        return new Object[][]{{rv1}, {rv2}};
    }

    @DataProvider(name = "validEquals")
    private Object[][] getEqualsData() {
        RegistrationForm rv1 = new RegistrationForm("en");
        RegistrationForm rv2 = new RegistrationForm("pt");
        return new Object[][]{{rv1, rv1}, {rv2, rv2}};
    }

    @DataProvider(name = "invalidEquals")
    private Object[][] getNotEqualsData() {
        RegistrationForm rv1 = new RegistrationForm("en");
        RegistrationForm rv2 = new RegistrationForm("pt");
        return new Object[][]{{rv1, rv2}, {rv2, rv1}, {rv1, null}, {rv1, ""}};
    }

}
