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

import lifetime.view.welcome.LoginButton;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class VitaeButtonNGTest {
    
    public VitaeButtonNGTest() {
    }

    /**
     * Test of hashCode method, of class LoginButton.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        String language = "pt";
        LoginButton instance = new LoginButton(language);
        LoginButton instance2 = new LoginButton(language);
        assertEquals(instance.hashCode(), instance2.hashCode());
    }

    /**
     * Test of equals method, of class LoginButton.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        String language = "pt";
        LoginButton instance = new LoginButton(language);
        LoginButton instance2 = new LoginButton(language);
        assertTrue(instance.equals(instance2));
    }
    
}
