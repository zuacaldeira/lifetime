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

import lifetime.component.LifetimeBackground;
import lifetime.component.LifetimeContent;
import lifetime.component.LifetimeMenu;
import lifetime.component.LifetimeView;
import lifetime.util.StyleClassName;

/**
 *
 * The Welcome View. This is the visible part of the user interface where the
 * use cases with the application starts.
 * <p>
 * The {@code WelcomeView} extends from {@code LifetimeView}, and implements the
 * structural and navigational requirements of the application specified by it's
 * session type.
 * <p>
 * The session type of the {@code WelcomeView} is
 *
 * {@code
 *      WelcomeView = &{WelcomeMenuView.home:     WelcomeView,
 *                      WelcomeMenuView.register: RegisterView,
 *                      WelcomeMenuView.login:    LoginView,
 *                      WelcomeMenuView.contact:  ContactView}
 * }
 *
 * <p>
 * We can read this session type as follow: <i>The Welcome View has a menu of
 * type {@link WelcomeMenu} with four actions, which allows a client to interact
 * with the system. As a result of this interaction the system may navigate the
 * user to another view.</i>
 * <p>
 * {@see LifetimeView}
 *
 * @author Zua Caldeira - zuacaldeira@gmail.com
 *
 */
public class WelcomeView extends LifetimeView {

    public WelcomeView(String language) {
        super(null, language);
        setStyleName(StyleClassName.WELCOME_VIEW.getStyleName());
        setId(StyleClassName.WELCOME_VIEW.getId());
    }

    /**
     * Creates a new welcome menu
     * @return A {@link WelcomeMenu}
     */
    @Override
    protected LifetimeMenu createMenu() {
        return new WelcomeMenu(getLanguage());
    }

    /**
     * Creates a new welcome content data
     * @return A {@link WelcomeMenu}
     */
    @Override
    protected LifetimeContent createContent() {
        return new WelcomeContent(getLanguage());
    }

    /**
     * Creates a new welcome background, with a fixed background.
     * @return A {@link Welcomebackground}
     */
    @Override
    protected LifetimeBackground createBackground() {
        return new WelcomeBackground(getLanguage());
    }



}
