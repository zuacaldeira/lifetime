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
package lifetime.component.welcome.register;

import lifetime.component.welcome.register.OKButton;
import lifetime.component.welcome.register.RegisterView;
import com.vaadin.server.FontAwesome;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class OKButtonNGTest {

    public OKButtonNGTest() {
    }

    @Test
    public void testConstructor() {
        System.out.println(getClass().getName() + "#OKButton()");
        String username = "username";
        String language = "en";
        OKButton okButton = new OKButton(username, language);
        Assert.assertEquals(okButton.getCaption(), "OK");
        Assert.assertEquals(okButton.getIcon(), FontAwesome.CHECK);
    }

    @Test
    public void testClick() {
        System.out.println(getClass().getName() + "#testClick()");
        RegisterView registerView = new RegisterView("pt");
        registerView.getMenu().getOkButton().click();
    }

    @Test
    public void testGetRegistrationForm() {
        System.out.println(getClass().getName() + "#testGetRegistrationForm()");
        RegisterView registerView = new RegisterView("pt");
        Assert.assertSame(registerView.getMenu().getOkButton().getRegistrationForm(), registerView.getContent().getRegistrationForm());
    }
}
