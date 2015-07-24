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
public class LifetimeTextFieldNGTest {
    
    public LifetimeTextFieldNGTest() {
    }

    @Test
    public void testZeroAryConstructor() {
        LifetimeTextField instance = new LifetimeTextField();
        Assert.assertEquals(instance.getCaption(), "");
        Assert.assertEquals(instance.getWidth(), 400f);
        Assert.assertTrue(instance.isImmediate());
    }
    
    @Test
    public void testUnaryConstructor() {
        String caption = "That's it!";
        LifetimeTextField instance = new LifetimeTextField(caption);
        Assert.assertEquals(instance.getCaption(), caption);
        Assert.assertEquals(instance.getWidth(), 400f);
        Assert.assertTrue(instance.isImmediate());
    }
}
