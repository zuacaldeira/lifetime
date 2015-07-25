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
package lifetime.view.welcome.register;

import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class RegisterViewNGTest {

    /**
     * Test of createMenu method, of class RegisterView.
     *
     * @param view
     */
    @Test(dataProvider = "valid")
    public void testCreateMenu(RegisterView view) {
        System.out.println("testCreateMenu()");
        Assert.assertNotNull(view.getMenu());
    }

    /**
     * Test of createContent method, of class RegisterView.
     *
     * @param view
     */
    @Test(dataProvider = "valid")
    public void testCreateContent(RegisterView view) {
        System.out.println("testCreateContent()");
        Assert.assertNotNull(view.getContent());
    }

    /**
     * Test of createBackground method, of class RegisterView.
     *
     * @param view
     */
    @Test(dataProvider = "valid")
    public void testCreateBackground(RegisterView view) {
        System.out.println("createBackground()");
        Assert.assertNotNull(view.getBackground());
    }

    /**
     * Test of getMenu method, of class RegisterView.
     *
     * @param view
     */
    @Test(dataProvider = "valid")
    public void testGetMenu(RegisterView view) {
        System.out.println("testGetMenu()");
        assertNotNull(view.getContent());
    }

    /**
     * Test of getContent method, of class RegisterView.
     *
     * @param view
     */
    @Test(dataProvider = "valid")
    public void testGetContent(RegisterView view) {
        System.out.println("getContent");
        assertNotNull(view.getContent());
    }

    @DataProvider(name = "valid")
    private Object[][] getValidData() {
        RegisterView rv1 = new RegisterView("en");
        RegisterView rv2 = new RegisterView("pt");
        return new Object[][]{{rv1}, {rv2}};
    }

    @DataProvider(name = "validEquals")
    private Object[][] getEqualsData() {
        RegisterView rv1 = new RegisterView("en");
        RegisterView rv2 = new RegisterView("pt");
        return new Object[][]{{rv1, rv1}, {rv2, rv2}};
    }

    @DataProvider(name = "invalidEquals")
    private Object[][] getNotEqualsData() {
        RegisterView rv1 = new RegisterView("en");
        RegisterView rv2 = new RegisterView("pt");
        return new Object[][]{{rv1, rv2}, {rv2, rv1}, {rv1, null}, {rv1, ""}};
    }

}
