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
package lifetime.view.welcome;

import java.util.Objects;
import lifetime.view.welcome.contact.ContactButton;
import lifetime.view.LifetimeMenu;
import lifetime.view.StyleClassName;

/**
 *
 * @author zua
 */
public class WelcomeMenu extends LifetimeMenu {

    private final RegisterButton registerButton;
    private final LoginButton loginButton;
    private final ContactButton contactButton;

    public WelcomeMenu(String language) {
        super(language);
        setSizeFull();
        registerButton = new RegisterButton(language);
        loginButton = new LoginButton(language);
        contactButton = new ContactButton(language);
        addControl(registerButton);
        addControl(loginButton);
        addControl(contactButton);
        setStyleName(StyleClassName.WELCOME_MENU);
        setId(StyleClassName.WELCOME_MENU);
    }

    public RegisterButton getRegisterButton() {
        return registerButton;
    }

    public LoginButton getLoginButton() {
        return loginButton;
    }

    public ContactButton getContactButton() {
        return contactButton;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.registerButton);
        hash = 79 * hash + Objects.hashCode(this.loginButton);
        hash = 79 * hash + Objects.hashCode(this.contactButton);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        final WelcomeMenu other = (WelcomeMenu) obj;
        return Objects.equals(this.registerButton, other.registerButton)
                && Objects.equals(this.loginButton, other.loginButton)
                && Objects.equals(this.contactButton, other.contactButton);
    }

}
