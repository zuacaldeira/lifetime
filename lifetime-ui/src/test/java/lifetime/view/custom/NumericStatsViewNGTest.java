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
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class NumericStatsViewNGTest {
    
    public NumericStatsViewNGTest() {
    }

    /**
     * Test of hashCode method, of class InfoView.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        String key = "key";
        Integer value = 1000000;
        InfoView instance1 = new InfoView(key, value);
        InfoView instance2 = new InfoView(key, value);
        Assert.assertEquals(instance1.hashCode(), instance2.hashCode());
    }

    /**
     * Test of equals method, of class InfoView.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        String key = "key";
        Integer value = 1000000;
        InfoView instance1 = new InfoView(key, value);
        InfoView instance2 = new InfoView(key, value);
        Assert.assertTrue(instance1.equals(instance2));
    }
    
}
