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

import lifetime.component.custom.LocalesComboBox;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class LocalesComboBoxNGTest {
    
    public LocalesComboBoxNGTest() {
    }

    /**
     * Tests the constructor of LocalesComboBox.
     */
    @Test
    public void testConstructor() {
        LocalesComboBox instance = new LocalesComboBox("en");
        Assert.assertEquals("en", instance.getLanguage());
        Assert.assertTrue(instance.isImmediate());
        Assert.assertFalse(instance.isNullSelectionAllowed());        
        Assert.assertFalse(instance.isNewItemsAllowed());        
    }
    
}
