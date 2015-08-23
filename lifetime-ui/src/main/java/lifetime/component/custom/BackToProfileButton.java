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
package lifetime.component.custom;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import lifetime.util.Navigation;
import lifetime.util.StyleClassName;

/**
 *
 * @author zua
 */
public class BackToProfileButton extends LifetimeButtonLink {

    public BackToProfileButton(String username, String language) {
        super(username, language, "Back to Profile", FontAwesome.BACKWARD);
        setId(StyleClassName.BACK_TO_PROFILE_BUTTON.getId());
        addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(Navigation.USER_VIEW.getName());
            }
        });
    }

}
