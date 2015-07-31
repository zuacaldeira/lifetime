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
package lifetime.view.user;

import lifetime.view.LifetimeBackground;
import lifetime.view.LifetimeContent;
import lifetime.view.LifetimeMenu;
import lifetime.view.LifetimeView;
import lifetime.util.StyleClassName;
import lifetime.view.welcome.WelcomeBackground;

/**
 *
 * @author zua
 */
public class UserView extends LifetimeView {

    public UserView(String language) {
        super(language);
        setId(StyleClassName.USER_VIEW);
        setStyleName(StyleClassName.USER_VIEW);
    }

    @Override
    protected LifetimeMenu createMenu() {
        return new UserMenu(getLanguage());
    }

    @Override
    protected LifetimeContent createContent() {
        return new UserContent(getLanguage());
    }

    @Override
    protected LifetimeBackground createBackground() {
        return new WelcomeBackground(getLanguage());
    }

}
