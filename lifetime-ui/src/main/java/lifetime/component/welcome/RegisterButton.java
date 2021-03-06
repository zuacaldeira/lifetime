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
package lifetime.component.welcome;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import lifetime.util.Navigation;
import lifetime.util.StyleClassName;
import lifetime.util.Translator;
import lifetime.component.custom.LifetimeButtonLink;

/**
 *
 * @author lifetime
 */
public class RegisterButton extends LifetimeButtonLink implements Button.ClickListener {

    public RegisterButton(String language) {
        super(Translator.getTranslation("Register", language), language, FontAwesome.PLUS);
        setId(StyleClassName.REGISTER_BUTTON.getId());
        addClickListener(this);
    }

    @Override
    public void buttonClick(ClickEvent event) {
        getUI().getNavigator().navigateTo(Navigation.REGISTER_VIEW.getName());
    }

}
