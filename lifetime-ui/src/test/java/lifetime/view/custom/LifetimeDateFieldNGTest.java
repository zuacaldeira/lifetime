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

import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class LifetimeDateFieldNGTest {
    
    public LifetimeDateFieldNGTest() {
    }

    
    /**
     * Test of LifetimeDateField constructor.
     */
    @Test
    public void testConstructor() {
        System.out.println("hashCode");
        String caption = "caption";
        String language = "en";
        
        LifetimeDateField instance = new LifetimeDateField(caption, language);
        Assert.assertTrue(instance.isImmediate());
        Assert.assertEquals(instance.getCaption(), caption);
        Assert.assertEquals(instance.getLanguage(), language);
        
    }
    
    
    
    /**
     * Test of hashCode method, of class LifetimeDateField.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        String caption = "caption";
        String language = "en";
        
        LifetimeDateField instance = new LifetimeDateField(caption, language);
        LifetimeDateField instance2 = new LifetimeDateField(caption, language);
        Assert.assertEquals(instance.hashCode(), instance2.hashCode());
    }

    /**
     * Test of equals method, of class LifetimeDateField.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        String caption = "caption";
        String language = "en";
        
        LifetimeDateField instance = new LifetimeDateField(caption, language);
        LifetimeDateField instance2 = new LifetimeDateField(caption, language);
        Assert.assertTrue(instance.equals(instance2));
    }
    
}
