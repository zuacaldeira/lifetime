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
package old.ui.user;

import old.ui.helper.DataLayout;
import old.ui.data.PersonalDataLayout;
import old.util.ServiceLocator;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Image;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import lifetime.business.logic.UserWithoutPhotoException;
import lifetime.business.persistence.Photo;
import lifetime.business.persistence.User;
import old.ui.menu.OldLifetimeMenu;

/**
 *
 * @author lifetime
 */
public class UserView extends AbsoluteLayout {

    private final String language;
    private final UserBackground background;
    private final UserDesk desk;
    private final OldLifetimeMenu menu;
    private final Integer userId;

    public UserView(final String language, Integer userId) {
        setSizeFull();
        this.language = language;
        this.userId = userId;
        background = new UserBackground(language, getUserImage(userId, language));
        desk = new UserDesk(userId, language);
        menu = new OldLifetimeMenu(userId, language);
        addComponent(background);
        addComponent(desk, "top:20%");
        addComponent(menu);
    }


    private static Image getUserImage(final Integer userId, String language) {
        return new Image("", new StreamResource(new StreamResource.StreamSource() {

            @Override
            public InputStream getStream() {
                try {
                    Photo photo = ServiceLocator.findLifetimeService().getUserPhoto(userId);
                    return new ByteArrayInputStream(photo.getImage());
                } catch (UserWithoutPhotoException ex) {
                    Logger.getLogger(UserView.class.getName()).log(Level.SEVERE, null, ex);
                    return new ByteArrayInputStream(new byte[]{});
                }
            }
        }, "user_" + userId));
    }

    private static DataLayout getUserDataLayout(Integer userId, String language) {
        User u = ServiceLocator.findLifetimeService().getUser(userId);
        String fullname = u.getFirstname() + " " + u.getLastname();
        String email = u.getEmail();
        return new PersonalDataLayout(language, fullname, email, u.getBirthdate());
    }

    public String getLanguage() {
        return language;
    }

    public UserDesk getDesk() {
        return desk;
    }

    public UserBackground getBackground() {
        return background;
    }

}
