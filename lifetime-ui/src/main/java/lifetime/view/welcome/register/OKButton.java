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
package lifetime.view.welcome.register;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import lifetime.util.StyleClassName;
import lifetime.view.custom.LifetimeButtonLink;

/**
 *
 * @author lifetime
 */
public class OKButton extends LifetimeButtonLink implements Button.ClickListener {

    public OKButton(String username, String language) {
        super(username, language, "OK", FontAwesome.CHECK);
        setCaption(getDescription());
        setId(StyleClassName.OK_BUTTON.getId());
        addClickListener(this);
    }

    @Override
    public void buttonClick(ClickEvent event) {
        getRegistrationForm().submit();
    }

    private RegistrationForm getRegistrationForm() {
        Component view = getParent();

        while (!(view instanceof RegisterView)) {
            view = view.getParent();
        }

        RegisterView rView = (RegisterView) view;
        return rView.getContent().getRegisterForm();
    }

}
