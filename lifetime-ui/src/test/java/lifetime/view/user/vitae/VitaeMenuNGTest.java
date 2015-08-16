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
package lifetime.view.user.vitae;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class VitaeMenuNGTest {

    public VitaeMenuNGTest() {
    }

    /**
     * Test of addControls method, of class VitaeMenu. Method
     * {@link VitaeMenu#addControls()}.
     */
    @Test
    public void testAddControls() {
        System.out.println("addControls");
        VitaeMenu instance = new VitaeMenu("username", "pt");
        assertEquals(instance.getControls().getComponentCount(), 5);
        assertNotNull(instance.getProfileButton());
        assertNotNull(instance.getAddButton());
        assertNotNull(instance.getReadButton());
        assertNotNull(instance.getUpdateButton());
        assertNotNull(instance.getDeleteButton());
    }

    /**
     * Test of getUsername method, of class VitaeMenu.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        VitaeMenu instance = new VitaeMenu("username", "pt");
        assertEquals(instance.getUsername(), "username");
    }

}
