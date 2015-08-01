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
package lifetime.view.welcome.contact;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class ContactMenuNGTest {

    public ContactMenuNGTest() {
    }

    @Test
    public void testSomeMethod() {
        ContactMenu menu = new ContactMenu("en");
        Assert.assertNotNull(menu.getHomeButton());
    }

    @Test
    public void testEquals() {
        ContactMenu menu = new ContactMenu("en");
        ContactMenu menu2 = new ContactMenu("en");
        Assert.assertTrue(menu.equals(menu2));
    }

    @Test
    public void testInequals() {
        ContactMenu menu = new ContactMenu("en");
        ContactMenu menu2 = new ContactMenu("pt");
        ContactMenu menu3 = null;
        Object menu4 = "Hi";

        Assert.assertFalse(menu.equals(menu2));
        Assert.assertFalse(menu.equals(menu3));
        Assert.assertFalse(menu.equals(menu4));
    }

}
