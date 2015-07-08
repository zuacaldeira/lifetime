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
package old.ui.welcome;

import old.ui.action.HorizontalActionBar;
import old.ui.button.LifetimeHomeButton;
import old.ui.button.LightsOnOffButton;
import old.ui.button.CommentButton;
import old.ui.menu.Desk;
import old.ui.button.RegisterButton;
import old.ui.button.LoginButton;

/**
 *
 * @author lifetime
 */
public class WelcomeActions extends HorizontalActionBar {

    public WelcomeActions(String language, Desk desk) {
        super(null, language);
        addAction(new RegisterButton(language));
        addAction(new LifetimeHomeButton(language));
        addAction(new LoginButton(language));
        addAction(new CommentButton(null, language));
        addAction(new LightsOnOffButton(language));
    }

}
