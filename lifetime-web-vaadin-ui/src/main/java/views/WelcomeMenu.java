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
package views;

import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;

/**
 *
 * @author zua
 */
public class WelcomeMenu extends LifetimeMenu implements ClickListener {
    private final LifetimeHomeButton homeButton;
    private final RegisterButton registerButton;
    private final LoginButton loginButton;
    private final ContactButton contactButton;
    
    public WelcomeMenu(String language) {
        super(language);
        setSizeFull();
        homeButton = new LifetimeHomeButton(language);
        registerButton = new RegisterButton(language);
        loginButton = new LoginButton(language);
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
        
        if(event.getButton() == homeButton) {
            Notification.show("--> WelcomeView -> " + context);
            getUI().getNavigator().navigateTo("Welcome");
        }
        if(event.getButton() == registerButton) {
            Notification.show("--> RegisterView -> " + context);
            getUI().getNavigator().navigateTo("Register");
        }
        if(event.getButton() == loginButton) {
            Notification.show("--> Login View -> " + context);
            getUI().getPage().setLocation(context+"/user");
        }
        if(event.getButton() == contactButton) {
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

    public LoginButton getLoginButton() {
        return loginButton;
    }

    public ContactButton getContactButton() {
        return contactButton;
    }
    
    
    

}
