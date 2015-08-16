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
package lifetime.view.user.vitae;

import lifetime.util.Navigation;
import lifetime.view.CrudMenu;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import lifetime.view.custom.LifetimeButtonLink;

/**
 *
 * @author zua
 */
public class VitaeMenu extends CrudMenu {

    private final String username;
    private LifetimeButtonLink profileButton;

    public VitaeMenu(String username, String language) {
        super(username, language);
        this.username = username;
    }

    @Override
    protected void addControls() {
        profileButton = new LifetimeButtonLink("Back to Profile", getLanguage(), FontAwesome.BACKWARD);
        profileButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(Navigation.USER_VIEW.getName());
            }
        });
        addControl(profileButton);
        super.addControls();
    }

    public String getUsername() {
        return username;
    }

    public LifetimeButtonLink getProfileButton() {
        return profileButton;
    }

}
