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
package lifetime.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewProvider;
import lifetime.view.welcome.WelcomeView;
import lifetime.view.welcome.contact.ContactView;
import lifetime.view.welcome.register.RegisterView;

/**
 *
 * @author zua
 */
public class WelcomeViewProvider implements ViewProvider {

    private final String language;

    public WelcomeViewProvider(String language) {
        this.language = language;
    }

    @Override
    public String getViewName(String viewAndParameters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public View getView(String viewName) {
        switch (viewName) {
            case Navigation.WELCOME_VIEW:
                return new WelcomeView(language);
            case Navigation.REGISTER_VIEW:
                return new RegisterView(language);
            case Navigation.CONTACT_VIEW:
                return new ContactView(language);
            default:
                return new WelcomeView(language);
        }
    }

}
