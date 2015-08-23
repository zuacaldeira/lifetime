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
package lifetime.component.welcome;

import lifetime.component.welcome.WelcomeBackground;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class WelcomeBackgroundNGTest {

    public WelcomeBackgroundNGTest() {
    }

    @Test(dataProvider = "valid")
    public void testWelcomeBackground(WelcomeBackground background) {
        Assert.assertNotNull(background);
        Assert.assertNotNull(background.getImage());
        Assert.assertEquals(background.getImage().getSource(), new ThemeResource("../img/background.jpg"));
    }

    @Test(dataProvider = "validEquals")
    public void testEquals(WelcomeBackground background, WelcomeBackground other) {
        Assert.assertTrue(background.equals(other));
    }

    @Test(dataProvider = "invalidEquals")
    public void testNotEquals(WelcomeBackground background, Object other) {
        Assert.assertFalse(background.equals(other));
    }

    @DataProvider(name = "valid")
    private Object[][] getValidData() {
        WelcomeBackground back = new WelcomeBackground("en");
        WelcomeBackground back2 = new WelcomeBackground("pt");
        return new Object[][]{{back}, {back2}};
    }

    @DataProvider(name = "validEquals")
    private Object[][] getEqualsData() {
        WelcomeBackground back = new WelcomeBackground("en");
        WelcomeBackground back2 = new WelcomeBackground("pt");
        return new Object[][]{{back, back}, {back2, back2}};
    }

    @DataProvider(name = "invalidEquals")
    private Object[][] getNotEqualsData() {
        WelcomeBackground back = new WelcomeBackground("en");
        WelcomeBackground back2 = new WelcomeBackground("pt");
        WelcomeBackground back3 = new WelcomeBackground("pt");
        back3.getImage().setSource(FontAwesome.ANDROID);

        return new Object[][]{{back, back2}, {back2, back}, {back, null}, {back, ""}, {back, back3}};
    }

}
