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
package lifetime.component.welcome.contact;

import lifetime.component.welcome.contact.ContactView;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class ContactViewNGTest {

    public ContactViewNGTest() {
    }

    /**
     * Test of createMenu method, of class ContactView.
     */
    @Test
    public void testCreateMenu() {
        System.out.println("createMenu");
        ContactView instance = new ContactView("en");
        assertNotNull(instance.getMenu());
    }

    /**
     * Test of createContent method, of class ContactView.
     */
    @Test
    public void testCreateContent() {
        System.out.println("createContent");
        ContactView instance = new ContactView("en");
        assertNotNull(instance.getContent());
    }

    /**
     * Test of createBackground method, of class ContactView.
     */
    @Test
    public void testCreateBackground() {
        System.out.println("createBackground");
        ContactView instance = new ContactView("en");
        assertNotNull(instance.getBackground());
    }

}
