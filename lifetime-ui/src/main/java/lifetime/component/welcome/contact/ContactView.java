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
package lifetime.component.welcome.contact;

import lifetime.component.welcome.WelcomeView;
import lifetime.component.welcome.WelcomeBackground;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import lifetime.component.LifetimeBackground;
import lifetime.component.LifetimeContent;
import lifetime.component.LifetimeMenu;

/**
 *
 * @author zua
 */
public class ContactView extends WelcomeView {

    public ContactView(String language) {
        super(language);
        VerticalLayout contactView = new VerticalLayout();
        contactView.setSizeUndefined();
        contactView.setCaption("Contact");
        contactView.addComponent(new Label("Contact"));
    }

    @Override
    protected LifetimeMenu createMenu() {
        return new ContactMenu(getLanguage());
    }

    @Override
    protected LifetimeContent createContent() {
        return new ContactContent(getLanguage());
    }

    @Override
    protected LifetimeBackground createBackground() {
        return new WelcomeBackground(getLanguage());
    }
    
}
