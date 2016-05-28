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

import com.vaadin.ui.Component;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class LabeledInfoViewNGTest {

    public LabeledInfoViewNGTest() {
    }

    /**
     * Test of getKey method, of class LabeledInfoView.
     *
     * @param info
     * @param key
     */
    @Test(dataProvider = "getKeyProvider")
    public void testGetKey(LabeledInfoView info, Component key) {
        System.out.println("getKey");
        //Assert.assertEquals(info.getKey().getCaption(), key.getCaption());
    }

    @DataProvider(name = "getKeyProvider")
    private Object[][] getKeyProvider() {
        return new Object[][]{ //{new LabeledInfoView(new Label("K1"))},
        //{new LabeledInfoView(new Label("K2"))}
        };
    }

    /**
     * Test of getInfo method, of class LabeledInfoView.
     *
     * @param info
     * @param value
     */
    @Test(dataProvider = "getInfoProvider")
    public void testGetInfo(LabeledInfoView info, Component value) {
        System.out.println("getInfo");
        Assert.assertEquals(info.getInfo().getCaption(), value.getCaption());
    }

    @DataProvider(name = "getInfoProvider")
    private Object[][] getInfoProvider() {
        return new Object[][]{ //{new LabeledInfoView(new Label("K1"))},
        //{new LabeledInfoView(new Label("K2"))}
        };
    }

    /**
     * Test of hashCode method, of class LabeledInfoView.
     *
     * @param info
     * @param other
     */
    @Test(dataProvider = "equalsProvider")
    public void testHashCode(LabeledInfoView info, LabeledInfoView other) {
        System.out.println("hashCode");
        Assert.assertEquals(info.hashCode(), other.hashCode());
    }

    @DataProvider(name = "equalsProvider")
    private Object[][] getEqualsProvider() {
        return new Object[][]{ //{new LabeledInfoView(new Label("K1")), new LabeledInfoView(new Label("K1"))},
        //{new LabeledInfoView(new Label("K2")), new LabeledInfoView(new Label("K2"))}
        };
    }

    /**
     * Test of equals method, of class LabeledInfoView.
     *
     * @param info
     * @param other
     */
    @Test(dataProvider = "equalsProvider")
    public void testEquals(LabeledInfoView info, LabeledInfoView other) {
        System.out.println("equals");
        Assert.assertTrue(info.equals(other));
    }

    /**
     * Test of equals method, of class LabeledInfoView.
     *
     * @param info
     * @param other
     */
    @Test(dataProvider = "inequalsProvider")
    public void testInequals(LabeledInfoView info, Object other) {
        System.out.println("inequals");
        Assert.assertFalse(info.equals(other));
    }

    @DataProvider(name = "inequalsProvider")
    private Object[][] getInequalsProvider() {
        return new Object[][]{ //{new LabeledInfoView(new Label("K1")), new LabeledInfoView(new Label("K2"))},
        //{new LabeledInfoView(new Label("K2")), new LabeledInfoView(new Label("K1"))}
        };
    }

}
