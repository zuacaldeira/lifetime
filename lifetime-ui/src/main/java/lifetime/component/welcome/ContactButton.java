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

import lifetime.component.custom.LifetimeButtonLink;
import com.vaadin.server.FontAwesome;
import lifetime.util.Navigation;
import lifetime.util.StyleClassName;
import lifetime.util.Translator;

/**
 *
 * @author lifetime
 */
public class ContactButton extends LifetimeButtonLink {

    public ContactButton(String language) {
        super(Translator.getTranslation("Contact", language), language, FontAwesome.COFFEE);
        setId(StyleClassName.CONTACT_BUTTON.getId());
        addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                getUI().getNavigator().navigateTo(Navigation.CONTACT_VIEW.getName());
            }
        });
    }

}
