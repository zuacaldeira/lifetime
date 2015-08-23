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
package lifetime.component.custom;

import lifetime.component.custom.LifetimeComboBox;
import lifetime.component.LifetimeBackground;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class LifetimeComboBoxNGTest {

    public LifetimeComboBoxNGTest() {
    }

    /**
     * Test of getLanguage method, of class LifetimeComboBox.
     *
     * @param combo
     * @param language
     */
    @Test(dataProvider = "combo")
    public void testGetLanguage(LifetimeComboBox combo, String language) {
        System.out.println("getLanguage");
        Assert.assertEquals(combo.getLanguage(), language);
    }

    /**
     * Test of equals method, of class LifetimeComboBox.
     *
     * @param combo1
     * @param combo2
     */
    @Test(dataProvider = "equals")
    public void testEquals(LifetimeComboBox combo1, LifetimeComboBox combo2) {
        System.out.println("equals");
        Assert.assertTrue(combo1.equals(combo2));
    }

    /**
     * Test of equals method, of class LifetimeComboBox.
     *
     * @param combo1
     * @param combo2
     */
    @Test(dataProvider = "inequals")
    public void testInequals(LifetimeComboBox combo1, Object combo2) {
        System.out.println("inequals");
        Assert.assertFalse(combo1.equals(combo2));
    }

    /**
     * Test of hashCode method, of class LifetimeComboBox.
     *
     * @param combo1
     * @param combo2
     */
    @Test(dataProvider = "equals")
    public void testHashCode(LifetimeComboBox combo1, LifetimeComboBox combo2) {
        System.out.println("hashCode");
        Assert.assertEquals(combo1.hashCode(), combo2.hashCode());
    }

    @DataProvider(name = "combo")
    private Object[][] getComboProvider() {
        return new Object[][]{
            {new LifetimeComboBox("caption", "pt", null) {
            }, "pt"},
            {new LifetimeComboBox("caption", "en", null) {
            }, "en"},};
    }

    @DataProvider(name = "equals")
    private Object[][] getEqualsProvider() {
        LifetimeComboBox comboPt1 = new LifetimeComboBox("caption", "pt", null) {
        };
        LifetimeComboBox comboPt2 = new LifetimeComboBox("caption", "pt", null) {
        };
        LifetimeComboBox comboEn1 = new LifetimeComboBox("caption", "en", null) {
        };
        LifetimeComboBox comboEn2 = new LifetimeComboBox("caption", "en", null) {
        };
        
        return new Object[][]{
            {comboPt1, comboPt2},//1
            {comboEn1, comboEn2}//2
        };
    }

    @DataProvider(name = "inequals")
    private Object[][] getInequalsProvider() {
        LifetimeComboBox comboPt1 = new LifetimeComboBox("caption", "pt", null) {
        };
        LifetimeComboBox comboPt2 = new LifetimeComboBox("caption", "pt", null) {
        };
        LifetimeComboBox comboEn1 = new LifetimeComboBox("caption", "en", null) {
        };
        LifetimeComboBox comboEn2 = new LifetimeComboBox("caption", "en", null) {
        };
        return new Object[][]{
            {comboEn1, comboPt1},
            {comboEn2, comboPt2},
            {comboEn1, null},
            {comboPt1, "Hi!"}
        };
    }

}
