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
package lifetime.component;

import lifetime.component.CrudMenu;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class CrudMenuNGTest {

    public CrudMenuNGTest() {
    }

    /**
     * Test of addControls method, of class CrudMenu.
     */
    @Test
    public void testAddControls() {
        System.out.println("addControls");
        CrudMenu instance = new CrudMenu("username", "pt") {
        };
        Assert.assertEquals(instance.getControls().getComponentCount(), new String[]{"C", "R", "U", "D"}.length);
        Assert.assertNotEquals(instance.getAddButton(), instance.getReadButton());
        Assert.assertNotEquals(instance.getReadButton(), instance.getUpdateButton());
        Assert.assertNotEquals(instance.getUpdateButton(), instance.getDeleteButton());
    }

}
