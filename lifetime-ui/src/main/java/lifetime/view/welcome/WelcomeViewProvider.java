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

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewProvider;
import java.util.HashMap;
import java.util.Map;
import lifetime.util.Navigation;
import lifetime.view.welcome.contact.ContactView;
import lifetime.view.welcome.register.RegisterView;

/**
 *
 * @author zua
 */
public class WelcomeViewProvider implements ViewProvider {

    private final String language;
    private final transient Map<String, View> viewMap;

    public WelcomeViewProvider(String language) {
        this.language = language;
        viewMap = new HashMap();
        viewMap.put(Navigation.WELCOME_VIEW.getName(), new WelcomeView(language));
        viewMap.put(Navigation.REGISTER_VIEW.getName(), new RegisterView(language));
        viewMap.put(Navigation.CONTACT_VIEW.getName(), new ContactView(language));
    }

    @Override
    public String getViewName(String viewAndParameters) {
        if (viewAndParameters.startsWith("!#")) {
            return viewAndParameters.substring(2);
        } else {
            return viewAndParameters;
        }
    }

    @Override
    public View getView(String viewName) {
        if (viewMap.get(viewName) != null) {
            return viewMap.get(viewName);
        } else {
            return null;
        }
    }

    public String getLanguage() {
        return language;
    }

}
