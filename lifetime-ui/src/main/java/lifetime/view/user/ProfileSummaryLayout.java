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

import com.vaadin.server.ExternalResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.AbsoluteLayout;
import java.text.DateFormat;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import lifetime.backend.persistence.User;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author zua
 */
class ProfileSummaryLayout extends AbsoluteLayout {

    private final DateFormat df = DateFormat.getDateInstance();
    private String username;
    private User user;
    private Component map;
    private PhotoLayout photo;
    private VerticalLayout birth;

    public ProfileSummaryLayout(String username, User user) {
        this.username = username;
        this.user = user;
        setSizeFull();
        initPhoto();
        initBackground();
        initBirthData();
        addComponents(map, photo, birth);
        setBirthDataPosition();
    }

    private void initPhoto() {
        photo = new PhotoLayout(username, user.getLanguage());
    }
    
    private void initBirthData() {
        Label name = new Label(user.getFirstname() + " " + user.getLastname());
        name.setIcon(FontAwesome.USER);
        
        Label birthdate = new Label(df.format(user.getBirthDate()));
        birthdate.setIcon(FontAwesome.CLOCK_O);
        
        Label birthplace = new Label(user.getBirthPlace());
        birthplace.setIcon(FontAwesome.MAP_MARKER);
        
        birth = new VerticalLayout(name, birthdate, birthplace);
        birth.setStyleName("birthdata");
        birth.setSizeUndefined();
        //birth.setSpacing(true);
        birth.setMargin(true);
        
    }

    private void initBackground() {
        Logger.getLogger(ProfileSummaryLayout.class.getName()).log(Level.INFO, null, "init user background");
        try {
            map = new BrowserFrame("", new ExternalResource("https://www.google.com/maps?q=-8.31,14.25&z=2" + "&output=embed"));
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
        bottomRight.setBottom(30f, Unit.PERCENTAGE);
        bottomRight.setRight(1f, Unit.PERCENTAGE);                
        setPosition(birth, bottomRight);
    }


}
