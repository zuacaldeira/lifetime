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

import java.util.Objects;
import lifetime.view.LifetimeMenu;
import lifetime.util.StyleClassName;
import lifetime.view.custom.LifetimeHomeButton;

/**
 *
 * @author zua
 */
class UserMenu extends LifetimeMenu {

    private final LifetimeHomeButton homeButton;
    private final VitaeButton vitaeButton;
    private final TimelineButton timelineButton;
    private final YellowPagesButton yellowPagesButton;

    public UserMenu(String language) {
        super(language);
        setId(StyleClassName.USER_MENU.getId());
        setStyleName(StyleClassName.USER_MENU.getStyleName());
        homeButton = new LifetimeHomeButton(language);
        vitaeButton = new VitaeButton(language);
        timelineButton = new TimelineButton(language);
        yellowPagesButton = new YellowPagesButton(language);

        addControl(homeButton);
        addControl(vitaeButton);
        addControl(timelineButton);
        addControl(yellowPagesButton);
    }

    public LifetimeHomeButton getHomeButton() {
        return homeButton;
    }

    public VitaeButton getVitaeButton() {
        return vitaeButton;
    }

    public TimelineButton getTimelineButton() {
        return timelineButton;
    }

    public YellowPagesButton getYellowPagesButton() {
        return yellowPagesButton;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(getLanguage());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof UserMenu)) {
            return false;
        }
        final UserMenu other = (UserMenu) obj;
        return Objects.equals(getLanguage(), other.getLanguage());
    }

}
