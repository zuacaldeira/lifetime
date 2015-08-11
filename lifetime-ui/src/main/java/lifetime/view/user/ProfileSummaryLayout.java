/*
 * Copyright 2015 zua.
 *
 * Liactcensed under the Apache License, Version 2.0 (the "License");
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

import com.vaadin.event.LayoutEvents;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import java.text.DateFormat;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import lifetime.backend.persistence.User;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author zua
 */
class ProfileSummaryLayout extends AbsoluteLayout {

    private final DateFormat df = DateFormat.getDateInstance();
    private String username;
    private User user;
    private Map<Component, Component> components;
    private Component map;
    private ProfileView photo;
    private HorizontalLayout birth;

    public ProfileSummaryLayout(String username, User user) {
        this.username = username;
        this.user = user;
        setSizeFull();
        initComponents();
    }

    private void initComponents() {
        initPhoto();
        initBackground();
        initBirthData();
        components = new HashMap();
        components.put(photo, map);
        components.put(map, birth);
        components.put(birth, photo);
        addComponent(photo);
    }

    private void initPhoto() {
        photo = new ProfileView(username, user.getLanguage());
    }

    private void initBirthData() {
        Label name = new Label(FontAwesome.USER.getHtml() + "  " + user.getFirstname() + "  " + user.getLastname(), ContentMode.HTML);
        name.setSizeUndefined();
        

        Label birthdate = new Label(FontAwesome.CLOCK_O.getHtml() + "  " + df.format(user.getBirthDate()), ContentMode.HTML);
        birthdate.setSizeUndefined();

        Label birthplace = new Label(FontAwesome.MAP_MARKER.getHtml() + "  " + user.getBirthPlace(), ContentMode.HTML);
        birthplace.setSizeUndefined();
        birthplace.setDescription("Click to hide map");

        birth = new HorizontalLayout(name, birthdate, birthplace);
        birth.setComponentAlignment(name, Alignment.MIDDLE_RIGHT);
        birth.setComponentAlignment(birthdate, Alignment.MIDDLE_CENTER);
        birth.setComponentAlignment(birthplace, Alignment.MIDDLE_LEFT);
        birth.setStyleName("birthdata");
        birth.setWidth("100%");
        birth.setHeightUndefined();
        birth.setSpacing(true);
        birth.addLayoutClickListener(new LayoutEvents.LayoutClickListener() {

            @Override
            public void layoutClick(LayoutEvents.LayoutClickEvent event) {
                if (event.getClickedComponent() == name) {
                    Notification.show(name.getValue());
                }
                if (event.getClickedComponent() == birthdate) {
                    Notification.show(birthdate.getValue());
                }
                if (event.getClickedComponent() == birthplace) {
                    Notification.show(birthplace.getValue());
                    if (map.isVisible()) {
                        map.setVisible(false);
                        birthplace.setDescription("Click show map");
                    } else {
                        removeAllComponents();
                        initComponents();
                    }
                }
            }
        });

    }

    private void initBackground() {
        Logger.getLogger(ProfileSummaryLayout.class.getName()).log(Level.INFO, null, "init user background");
        try {
            map = new BrowserFrame("", new ExternalResource("https://www.google.com/maps?q=-8.31,14.25&z=3" + "&output=embed"));
            map.setIcon(FontAwesome.MAP_MARKER);
            map.setSizeFull();
            //map.setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(ProfileSummaryLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ProfileSummaryLayout)) {
            return false;
        }
        final ProfileSummaryLayout other = (ProfileSummaryLayout) obj;
        return Objects.equals(this.username, other.username);
    }

    private void setBirthDataPosition() {
        ComponentPosition bottomRight = new ComponentPosition();
        bottomRight.setBottom(10f, Unit.PERCENTAGE);
        setPosition(birth, bottomRight);
    }

}
