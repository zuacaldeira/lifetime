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

import lifetime.component.welcome.HomeView;
import lifetime.component.welcome.WelcomeContent;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class WelcomeContentNGTest {

    public WelcomeContentNGTest() {
    }

    
    /**
     * 
     */
    @Test
    public void testContent() {
        System.out.println("testContent()");
        WelcomeContent welcomeContent = new WelcomeContent("en");
        Assert.assertNotNull(welcomeContent.getContentView());
        Assert.assertTrue(welcomeContent.getContentView() instanceof HomeView);
    }
    
    /**
     * Test of hashCode method, of class WelcomeContent.
     *
     * @param wc1
     * @param wc2
     */
    @Test(dataProvider = "equalsProvider")
    public void testHashCode(WelcomeContent wc1, WelcomeContent wc2) {
        System.out.println("hashCode");
        Assert.assertEquals(wc1.hashCode(), wc2.hashCode());
    }

    @DataProvider(name = "equalsProvider")
    private Object[][] provideHashCodeData() {
        WelcomeContent wcPt = new WelcomeContent("pt");
        WelcomeContent wcEn = new WelcomeContent("en");
        return new Object[][]{{wcPt, wcPt}, {wcEn, wcEn}};
    }

    /**
     * Test of equals method, of class WelcomeContent.
     *
     * @param wc1
     * @param wc2
     */
    @Test(dataProvider = "equalsProvider")
    public void testEquals(WelcomeContent wc1, WelcomeContent wc2) {
        System.out.println("equals");
        Assert.assertTrue(wc1.equals(wc2));
    }

}
