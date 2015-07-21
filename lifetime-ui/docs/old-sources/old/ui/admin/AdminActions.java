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

import old.ui.menu.Desk;
import old.ui.action.HorizontalActionBar;

/**
 *
 * @author lifetime
 */
class AdminActions extends HorizontalActionBar {

    public AdminActions(Integer guestId, String language, Desk desk) {
        super(guestId, language);
        addAction(new UserManagerButton(guestId, language));
    }
    
}
