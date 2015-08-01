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

import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import java.util.Objects;
import lifetime.ui.Location;
import lifetime.ui.Navigation;
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
    private static final String NOT_IMPLEMENTED_YET = "Not Implememted Yet";

    public UserMenu(String language) {
        super(language);
        setId(StyleClassName.USER_MENU);
        setStyleName(StyleClassName.USER_MENU);
        homeButton = new LifetimeHomeButton(language);
        homeButton.addClickListener(this);
        vitaeButton = new VitaeButton(language);
        vitaeButton.addClickListener(this);
        timelineButton = new TimelineButton(language);
        timelineButton.addClickListener(this);
        yellowPagesButton = new YellowPagesButton(language);
        yellowPagesButton.addClickListener(this);

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
    public void buttonClick(Button.ClickEvent event) {
        Button b = event.getButton();
        if (b == homeButton) {
            Page.getCurrent().setLocation(Location.HOME);
        } else if (b == vitaeButton) {
            getUI().getNavigator().navigateTo(Navigation.VITAE_VIEW);
            Notification.show(NOT_IMPLEMENTED_YET, Notification.Type.ERROR_MESSAGE);
        } else if (b == timelineButton) {
            getUI().getNavigator().navigateTo(Navigation.TIMELINE_VIEW);
            Notification.show(NOT_IMPLEMENTED_YET, Notification.Type.ERROR_MESSAGE);
        } else if (b == yellowPagesButton) {
            getUI().getNavigator().navigateTo(Navigation.YELLOW_PAGES_VIEW);
            Notification.show(NOT_IMPLEMENTED_YET, Notification.Type.ERROR_MESSAGE);
        } else {
            Notification.show("Unknown button: " + b, Notification.Type.ERROR_MESSAGE);
        }
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
