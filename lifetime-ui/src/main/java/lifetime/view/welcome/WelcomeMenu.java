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
import lifetime.view.LifetimeMenu;
import lifetime.util.StyleClassName;

/**
 * The welcoming menu, presenting guest enabled actions.
 *
 * @author zua
 */
public class WelcomeMenu extends LifetimeMenu {

    /**
     * Register button, starts the {@literal register} use case.
     */
    private RegisterButton registerButton;
    /**
     * Login button, starts the {@literal login} use case.
     */
    private LoginButton loginButton;
    /**
     * Contact button, starts the {@literal contact} use case.
     */
    private ContactButton contactButton;

    /**
     * Constructs a welcome menu instance.
     *
     * @param language The current user interaction language.
     */
    public WelcomeMenu(String language) {
        super(language);
        setSizeFull();
        setId(StyleClassName.WELCOME_MENU.getId());
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
        return hash + getLanguage().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WelcomeMenu other = (WelcomeMenu) obj;
        return Objects.equals(getLanguage(), other.getLanguage());
    }

    @Override
    protected void addControls() {
        registerButton = new RegisterButton(getLanguage());
        loginButton = new LoginButton(getLanguage());
        contactButton = new ContactButton(getLanguage());
        addControl(registerButton);
        addControl(loginButton);
        addControl(contactButton);
    }

}
