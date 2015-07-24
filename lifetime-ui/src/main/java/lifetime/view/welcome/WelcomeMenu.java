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

import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import java.util.Objects;
import lifetime.view.welcome.contact.ContactButton;
import lifetime.view.custom.LifetimeHomeButton;
import lifetime.view.LifetimeMenu;
import lifetime.view.custom.RegisterButton;
import lifetime.view.custom.VitaeButton;

/**
 *
 * @author zua
 */
public class WelcomeMenu extends LifetimeMenu implements ClickListener {

    private final LifetimeHomeButton homeButton;
    private final RegisterButton registerButton;
    private final VitaeButton loginButton;
    private final ContactButton contactButton;

    public WelcomeMenu(String language) {
        super(language);
        setSizeFull();
        homeButton = new LifetimeHomeButton(language);
        registerButton = new RegisterButton(language);
        loginButton = new VitaeButton(language);
        contactButton = new ContactButton(language);
        homeButton.addClickListener(this);
        registerButton.addClickListener(this);
        loginButton.addClickListener(this);
        contactButton.addClickListener(this);
        addControl(homeButton);
        addControl(registerButton);
        addControl(loginButton);
        addControl(contactButton);
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        Notification.show("Welcome Menu View -> " + event.getButton());
        String context = VaadinServlet.getCurrent().getServletContext().getContextPath();

        if (event.getButton() == homeButton) {
            Notification.show("--> WelcomeView -> " + context);
            getUI().getNavigator().navigateTo("Welcome");
        }
        if (event.getButton() == registerButton) {
            Notification.show("--> RegisterView -> " + context);
            getUI().getNavigator().navigateTo("Register");
        }
        if (event.getButton() == loginButton) {
            Notification.show("--> Login View -> " + context);
            getUI().getPage().setLocation(context + "/user");
        }
        if (event.getButton() == contactButton) {
            Notification.show("Contact View -> " + context);
            getUI().getNavigator().navigateTo("Contact");
        }
    }

    public LifetimeHomeButton getHomeButton() {
        return homeButton;
    }

    public RegisterButton getRegisterButton() {
        return registerButton;
    }

    public VitaeButton getLoginButton() {
        return loginButton;
    }

    public ContactButton getContactButton() {
        return contactButton;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.homeButton);
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
        return Objects.equals(this.homeButton, other.homeButton)
                && Objects.equals(this.registerButton, other.registerButton)
                && Objects.equals(this.loginButton, other.loginButton)
                && Objects.equals(this.contactButton, other.contactButton);
    }

}
