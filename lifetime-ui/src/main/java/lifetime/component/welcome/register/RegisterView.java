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
package lifetime.component.welcome.register;

import lifetime.component.welcome.WelcomeView;
import lifetime.component.welcome.WelcomeBackground;
import lifetime.component.LifetimeBackground;
import lifetime.component.LifetimeContent;
import lifetime.component.LifetimeMenu;
import lifetime.util.StyleClassName;

/**
 *
 * The Register View.
 * <p>
 * The RegisterView extends from LifetimeView application starts.
 * </p>
 * <p>
 * The <code>WelcomeView</code> is
 * </p>
 *
 * @author lifetime
 *
 */
public class RegisterView extends WelcomeView {

    public RegisterView(String language) {
        super(language);
        setStyleName(StyleClassName.REGISTER_VIEW.getStyleName());
        setId(StyleClassName.REGISTER_VIEW.getId());
    }

    @Override
    protected LifetimeMenu createMenu() {
        return new RegisterMenu(getLanguage());
    }

    @Override
    protected LifetimeContent createContent() {
        return new RegisterContent(getLanguage());
    }

    @Override
    protected LifetimeBackground createBackground() {
        return new WelcomeBackground(getLanguage());
    }

    @Override
    public RegisterMenu getMenu() {
        return (RegisterMenu) super.getMenu();
    }

    @Override
    public RegisterContent getContent() {
        return (RegisterContent) super.getContent();
    }

}
