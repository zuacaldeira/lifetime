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

import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import java.util.Objects;
import lifetime.ui.Location;
import lifetime.ui.Navigation;
import lifetime.view.LifetimeMenu;
import lifetime.util.StyleClassName;

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
        registerButton.addClickListener(this);
        loginButton = new LoginButton(language);
        loginButton.addClickListener(this);
        contactButton = new ContactButton(language);
        contactButton.addClickListener(this);
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
    public void buttonClick(Button.ClickEvent event) {
        Button b = event.getButton();
        if (b == registerButton) {
            getUI().getNavigator().navigateTo(Navigation.REGISTER_VIEW);
        } else if (b == loginButton) {
            Page.getCurrent().setLocation(Location.USER);
        } else if (b == contactButton) {
            getUI().getNavigator().navigateTo(Navigation.CONTACT_VIEW);
        } else {
            Notification.show("Unknown Button: " + b, Notification.Type.ERROR_MESSAGE);
        }
    }

}
