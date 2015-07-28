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

import lifetime.view.welcome.ContactButton;
import com.vaadin.event.ListenerMethod;
import com.vaadin.ui.Button;
import lifetime.ui.WelcomeUI;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class ContactButtonNGTest {

    public ContactButtonNGTest() {
    }

    @Test
    public void testSomeMethod() {
        ContactButton button = new ContactButton("en");
        Assert.assertNotNull(button);
        Assert.assertNotNull(button.getListeners(Button.ClickEvent.class));
        Assert.assertFalse(button.getListeners(Button.ClickEvent.class).isEmpty());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testButtonClick() {
        ContactButton button = new ContactButton("en");
        button.buttonClick(new Button.ClickEvent(new WelcomeUI()));
    }

}
