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
package lifetime.view;

import com.vaadin.ui.Image;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class LifetimeBackgroundNGTest {

    public LifetimeBackgroundNGTest() {
    }

    /**
     * Test of getLanguage method, of class LifetimeBackground.
     */
    @Test
    public void testGetLanguage() {
        System.out.println("getLanguage");
        String language = "pt";
        Image image = new Image();
        LifetimeBackground instance = new LifetimeBackground(language, image) {
        };
        assertEquals(instance.getLanguage(), language);
    }

    /**
     * Test of getImage method, of class LifetimeBackground.
     */
    @Test
    public void testGetImage() {
        System.out.println("getImage");
        String language = "pt";
        Image image = new Image();
        LifetimeBackground instance = new LifetimeBackground(language, image) {
        };
        assertEquals(instance.getImage(), image);
    }

    @Test
    public void testEquals() {
        String language = "pt";
        Image image = new Image();
        LifetimeBackground instance = new LifetimeBackground(language, image) {
        };
        LifetimeBackground instance2 = new LifetimeBackground(language, new Image("ok...")) {
        };
        LifetimeBackground instance3 = new LifetimeBackground("en", image) {
        };
        Assert.assertTrue(instance.equals(instance));
        Assert.assertTrue(instance2.equals(instance2));
        Assert.assertFalse(instance.equals(instance2));
        Assert.assertFalse(instance.equals(null));
        Assert.assertFalse(instance.equals(instance3));
    }

}
