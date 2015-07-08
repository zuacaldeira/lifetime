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
package old.ui.admin;

import old.ui.button.LifetimeButtonLink;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import ui.LifetimeUI;
import old.util.Translator;
import old.ui.window.UsersWindow;

/**
 *
 * @author lifetime
 */
public class UserManagerButton extends LifetimeButtonLink {

    public UserManagerButton(final Integer userId, final String language) {
        super(Translator.getTranslation("View Users", language), FontAwesome.USERS);
        addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                showUsers();
            }

            private void showUsers() {
                UsersWindow uList = new UsersWindow(userId, language);
                getUI().addWindow(uList);
            }
        });
        
        setDescription(Translator.getTranslation("View Users", language));
    }

    @Override
    public LifetimeUI getUI() {
        return (LifetimeUI) super.getUI();
    }

}
