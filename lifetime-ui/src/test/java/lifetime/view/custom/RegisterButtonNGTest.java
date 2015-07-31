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

import lifetime.view.welcome.RegisterButton;
import com.vaadin.server.FontAwesome;
import lifetime.util.StyleClassName;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class RegisterButtonNGTest {
    
    public RegisterButtonNGTest() {
    }

    @Test
    public void testRegisterButton() {
        String language = "en";
        RegisterButton button = new RegisterButton(language);
        Assert.assertEquals(button.getId(), StyleClassName.REGISTER_BUTTON);
        Assert.assertEquals(button.getIcon(), FontAwesome.PLUS);
    }
    
}
