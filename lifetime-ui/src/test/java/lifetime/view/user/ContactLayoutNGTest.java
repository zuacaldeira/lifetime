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
package lifetime.view.user;

import lifetime.backend.persistence.Contact;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class ContactLayoutNGTest {

    public ContactLayoutNGTest() {
    }

    @Test
    public void testSomeMethod() {
        ContactLayout contactLayout = new ContactLayout(new Contact(1, "username", "telephone1", "mobile1", "fax1"));
        assertNotNull(contactLayout.getContact());
    }

}
