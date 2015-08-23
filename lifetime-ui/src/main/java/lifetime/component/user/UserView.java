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
package lifetime.component.user;

import lifetime.component.LifetimeBackground;
import lifetime.component.LifetimeContent;
import lifetime.component.LifetimeMenu;
import lifetime.component.LifetimeView;
import lifetime.util.StyleClassName;

/**
 *
 * @author zua
 */
public class UserView extends LifetimeView {

    public UserView(String username, String language) {
        super(username, language);
        System.out.println("UserView#UserView(): USERNAME IN USER_VIEW -> " + getUsername());
        setId(StyleClassName.USER_VIEW.getId());
        setStyleName(StyleClassName.LIFETIME_VIEW.getStyleName());
    }

    @Override
    protected LifetimeMenu createMenu() {
        return new UserMenu(getUsername(), getLanguage());
    }

    @Override
    protected LifetimeContent createContent() {
        return new ProfileView(getUsername(), getLanguage());
    }

    @Override
    protected LifetimeBackground createBackground() {
        return new UserBackground(getLanguage());
    }

}
