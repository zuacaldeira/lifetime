/*
 * Copyright 2015 lifetime.
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
package lifetime.view;

import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import lifetime.ui.Navigation;

/**
 *
 * The Register View.
 * <p>
 * The RegisterView extends from LifetimeView application starts.
 * </p>
 * <p>
 * The <code>WelcomeView</code> is
 * </p>
 *
 * @author lifetime
 *
 */
public class RegisterView extends WelcomeView implements ClickListener {

    public RegisterView(String language) {
        super(language);
        setStyleName("welcome-view");
    }

    @Override
    protected LifetimeMenu createMenu() {
        RegisterMenu menu = new RegisterMenu(getLanguage());
        menu.addClickListener(this);
        return menu;
    }

    @Override
    protected LifetimeContent createContent() {
        return new RegisterContent(getLanguage());
    }

    @Override
    protected LifetimeBackground createBackground() {
        return new WelcomeBackground(getLanguage());
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        String context = VaadinServlet.getCurrent().getServletContext().getContextPath();

        if (event.getButton() == getMenu().getHomeButton()) {
            getUI().getNavigator().navigateTo(Navigation.WELCOME_VIEW);
        }
        else if (event.getButton() == getMenu().getCancelButton()) {
            getContent().getRegisterForm().clear();
        }
        else if (event.getButton() == getMenu().getOkButton()) {
            getContent().getRegisterForm().submit();
            getUI().getNavigator().navigateTo(Navigation.WELCOME_VIEW);
        }
    }

    @Override
    public RegisterMenu getMenu() {
        return (RegisterMenu) super.getMenu();
    }

    @Override
    public RegisterContent getContent() {
        return (RegisterContent) super.getContent();
    }

}
