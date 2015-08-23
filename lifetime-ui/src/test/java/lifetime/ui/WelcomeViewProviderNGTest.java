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
package lifetime.ui;

import lifetime.util.Navigation;
import lifetime.component.welcome.WelcomeViewProvider;
import lifetime.component.welcome.WelcomeView;
import lifetime.component.welcome.contact.ContactView;
import lifetime.component.welcome.register.RegisterView;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class WelcomeViewProviderNGTest {

    public WelcomeViewProviderNGTest() {
    }

    /**
     * Test of getViewName method, of class WelcomeViewProvider.
     *
     * @param viewAndParamaters
     * @param viewName
     */
    @Test(dataProvider = "viewNames")
    public void testGetViewName(String viewAndParamaters, String viewName) {
        System.out.println("testGetViewName()");
        WelcomeViewProvider viewProvider = new WelcomeViewProvider("pt");
        assertEquals(viewProvider.getViewName(viewAndParamaters), viewName);
        assertNotNull(viewProvider.getView(viewName));
    }

    @DataProvider(name = "viewNames")
    private Object[][] provideViewNames() {
        return new Object[][]{
            {"!#welcome", Navigation.WELCOME_VIEW.getName()},
            {"!#register", Navigation.REGISTER_VIEW.getName()},
            {"!#contact", Navigation.CONTACT_VIEW.getName()}
        };
    }

    @DataProvider(name = "views")
    private Object[][] provideViews() {
        return new Object[][]{
            {Navigation.WELCOME_VIEW.getName(), WelcomeView.class},
            {Navigation.REGISTER_VIEW.getName(), RegisterView.class},
            {Navigation.CONTACT_VIEW.getName(), ContactView.class}
        };
    }

    /**
     * Test of getView method, of class WelcomeViewProvider.
     *
     * @param viewName
     * @param aClass
     */
    @Test(dataProvider = "views")
    public void testGetView(String viewName, Class<WelcomeView> aClass) {
        System.out.println("getView");
        WelcomeViewProvider provider = new WelcomeViewProvider("en");
        assertNotNull(provider.getView(viewName));
        assertEquals(provider.getView(viewName).getClass(), aClass);
        assertNull(provider.getView(null));
    }

    /**
     * Test of getLanguage method, of class WelcomeViewProvider.
     *
     * @param provider
     * @param language
     */
    @Test(dataProvider = "providers")
    public void testGetLanguage(WelcomeViewProvider provider, String language) {
        System.out.println("getLanguage");
        assertEquals(provider.getLanguage(), language);
    }

    @DataProvider(name = "providers")
    private Object[][] provideProviders() {
        return new Object[][]{
            {new WelcomeViewProvider("pt"), "pt"},
            {new WelcomeViewProvider("en"), "en"},};
    }

    @DataProvider(name = "equalsProvider")
    private Object[][] provideEquals() {
        WelcomeViewProvider wv1 = new WelcomeViewProvider("pt");
        WelcomeViewProvider wv2 = new WelcomeViewProvider("en");
        return new Object[][]{
            {wv1, wv1},
            {wv2, wv2}
        };
    }

    @DataProvider(name = "notEqualsProvider")
    private Object[][] provideNotEquals() {
        WelcomeViewProvider wv1 = new WelcomeViewProvider("pt");
        WelcomeViewProvider wv2 = new WelcomeViewProvider("en");
        return new Object[][]{
            {wv1, wv2},
            {wv2, wv1},
            {wv1, null},
            {wv1, "A"}
        };
    }
}
