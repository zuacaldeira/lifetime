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

import java.util.Objects;
import lifetime.component.LifetimeMenu;
import lifetime.util.StyleClassName;
import lifetime.component.custom.LifetimeHomeButton;

/**
 *
 * @author zua
 */
public class UserMenu extends LifetimeMenu {

    private LifetimeHomeButton homeButton;
    private VitaeButton vitaeButton;
    private TimelineButton timelineButton;
    private YellowPagesButton yellowPagesButton;
    private String username;
    private WorkButton work;

    public UserMenu(String username, String language) {
        super(language);
        this.username = username;
        System.out.println("USERNAME IN USER_MENU-> " + username);
        setId(StyleClassName.USER_MENU.getId());
        setStyleName(StyleClassName.LIFETIME_MENU.getStyleName());
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

    @Override
    protected void addControls() {
        homeButton = new LifetimeHomeButton(getLanguage());
        vitaeButton = new VitaeButton(getLanguage());
        timelineButton = new TimelineButton(getLanguage());
        yellowPagesButton = new YellowPagesButton(getLanguage());
        work = new WorkButton(getLanguage());
        addControl(homeButton);
        addControl(vitaeButton);
        addControl(timelineButton);
        addControl(yellowPagesButton);
        addControl(work);
    }

}
