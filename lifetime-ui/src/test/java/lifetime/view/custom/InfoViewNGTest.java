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
public class InfoViewNGTest {

    /**
     * Test of getTag method, of class InfoView.
     *
     * @param info
     * @param tag
     */
    @Test(dataProvider = "tags")
    public void testGetTag(InfoView info, String tag) {
        System.out.println("getTag");
        assertEquals(info.getTag(), tag);
    }

    @DataProvider(name = "tags")
    private Object[][] getTagProvider() {
        return new Object[][]{
            {new InfoView("Key1", 1), "Key1"},
            {new InfoView("Key2", 2), "Key2"}
        };
    }

    /**
     * Test of getValue method, of class InfoView.
     *
     * @param info
     * @param value
     */
    @Test(dataProvider = "values")
    public void testGetValue(InfoView info, Number value) {
        System.out.println("getValue");
        Assert.assertEquals(info.getValue(), value);
    }

    @DataProvider(name = "values")
    private Object[][] getValueProvider() {
        return new Object[][]{
            {new InfoView("A", 1), 1},
            {new InfoView("B", 2), 2}
        };

    }

    /**
     * Test of hashCode method, of class InfoView.
     *
     * @param info
     * @param other
     */
    @Test(dataProvider = "equals")
    public void testHashCode(InfoView info, InfoView other) {
        System.out.println("hashCode");
        Assert.assertEquals(info.hashCode(), other.hashCode());
    }

    /**
     * Test of equals method, of class InfoView.
     *
     * @param info
     * @param other
     */
    @Test(dataProvider = "equals")
    public void testEquals(InfoView info, InfoView other) {
        System.out.println("equals");
        Assert.assertTrue(info.equals(other));
    }

    @DataProvider(name = "equals")
    private Object[][] getEqualsData() {
        return new Object[][]{
            {new InfoView("A", 1), new InfoView("A", 1)},
            {new InfoView("A", "A"), new InfoView("A", "A")}
        };
    }

    /**
     * Test of equals method, of class InfoView.
     *
     * @param info
     * @param other
     */
    @Test(dataProvider = "inequals")
    public void testInequals(InfoView info, InfoView other) {
        System.out.println("inequals");
        Assert.assertFalse(info.equals(other));
    }

    @DataProvider(name = "inequals")
    private Object[][] getInequalsData() {
        return new Object[][]{
            {new InfoView("A", 1), new InfoView("A", "A")},
            {new InfoView("A", "A"), new InfoView("A", 1)}
        };
    }

}
