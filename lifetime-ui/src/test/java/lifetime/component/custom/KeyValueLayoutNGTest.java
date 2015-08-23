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

import lifetime.component.custom.KeyValueLayout;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class KeyValueLayoutNGTest {

    /**
     * Test of hashCode method, of class KeyValueLayout.
     */
    @Test(dataProvider = "equals")
    public void testHashCode(KeyValueLayout instance, KeyValueLayout instance2) {
        System.out.println("hashCode");
        Assert.assertEquals(instance.hashCode(), instance2.hashCode());
    }

    /**
     * Test of equals method, of class KeyValueLayout.
     * @param instance
     * @param instance2
     */
    @Test(dataProvider = "equals")
    public void testEquals(KeyValueLayout instance, KeyValueLayout instance2) {
        System.out.println("equals");
        Assert.assertTrue(instance.equals(instance2));
    }

    /**
     * Test of equals method, of class KeyValueLayout.
     * @param instance
     * @param instance2
     */
    @Test(dataProvider = "inequals")
    public void testInequals(KeyValueLayout instance, Object instance2) {
        System.out.println("equals");
        Assert.assertFalse(instance.equals(instance2));
    }

    @DataProvider(name = "equals")
    private Object[][] provideEquals() {
        KeyValueLayout instance = new KeyValueLayout("key", "value");
        KeyValueLayout instance2 = new KeyValueLayout("key", "value");
        return new Object[][]{
            {instance, instance2}
        };
    }

    @DataProvider(name = "inequals")
    private Object[][] provideInequals() {
        KeyValueLayout instance = new KeyValueLayout("key1", "value");
        KeyValueLayout instance2 = new KeyValueLayout("key", "value2");
        KeyValueLayout instance3 = null;
        Object instance4 = "OK";
        return new Object[][]{
            {instance, instance2},
            {instance, instance3},
            {instance, instance4},
        };
    }

}
