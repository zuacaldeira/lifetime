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
package lifetime.view.welcome;

import junit.framework.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class HomeViewNGTest {

    public HomeViewNGTest() {
    }

    /**
     * Test of getLanguage method, of class HomeView.
     *
     * @param instance test home view
     */
    @Test(dataProvider = "valid")
    public void testGetLanguage(HomeView instance) {
        System.out.println("getLanguage");
        Assert.assertNotNull(instance.getLanguage());
    }

    @DataProvider(name = "valid")
    private Object[][] provideValidData() {
        return new Object[][]{{new HomeView("pt")}, {new HomeView("en")}};
    }

    /**
     * Test of getnUsers method, of class HomeView.
     *
     * @param instance
     */
    @Test(dataProvider = "valid")
    public void testGetnUsers(HomeView instance) {
        System.out.println("getnUsers");
        Assert.assertNotNull(instance.getnUsers());
    }

    /**
     * Test of getnJobs method, of class HomeView.
     *
     * @param instance
     */
    @Test(dataProvider = "valid")
    public void testGetnJobs(HomeView instance) {
        System.out.println("getnJobs");
        Assert.assertNotNull(instance.getnJobs());
    }

    /**
     * Test of getnCourses method, of class HomeView.
     *
     * @param instance
     */
    @Test(dataProvider = "valid")
    public void testGetnCourses(HomeView instance) {
        System.out.println("getnCourses");
        Assert.assertNotNull(instance.getnCourses());
    }

    /**
     * Test of hashCode method, of class HomeView.
     *
     * @param instance1
     * @param instance2
     */
    @Test(dataProvider = "equals")
    public void testHashCode(HomeView instance1, HomeView instance2) {
        System.out.println("testHashCode()");
        Assert.assertEquals(instance1.hashCode(), instance2.hashCode());
    }

    /**
     * Test of equals method, of class HomeView.
     *
     * @param instance1
     * @param instance2
     */
    @Test(dataProvider = "equals")
    public void testEquals(HomeView instance1, HomeView instance2) {
        System.out.println("testEquals()");
        Assert.assertTrue(instance1.equals(instance2));
    }

    @DataProvider(name = "equals")
    private Object[][] provideEqualsData() {
        HomeView hvPt = new HomeView("pt");
        HomeView hvEn = new HomeView("en");
        return new Object[][]{{hvPt, hvPt}, {hvEn, hvEn}};
    }

}
