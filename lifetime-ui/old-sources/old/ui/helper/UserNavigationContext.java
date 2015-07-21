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
package old.ui.helper;

import old.util.ServiceLocator;
import old.ui.label.LifetimeLabel;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.HorizontalLayout;
import lifetime.business.persistence.User;

/**
 *
 * @author lifetime
 */
public class UserNavigationContext extends HorizontalLayout {

    private final LifetimeLabel label;

    public UserNavigationContext(Integer hostId, Integer visitorId, String language) {
        label = new LifetimeLabel(getNames(hostId, "vitae"), language);
        //setMargin(true);
        setMargin(new MarginInfo(false, false, false, true));
        addComponent(label);
        setStyleName("navigation");
    }

    private static String getNames(Integer userId, String alternative) {
        if (userId != null) {
            User user = ServiceLocator.findLifetimeService().getUser(userId);
            if (user.getFirstname() != null && user.getLastname() != null) {
                return user.getFirstname() + " " + user.getLastname();
            } 
            if(user.getFirstname() != null) {
                return user.getFirstname();
            }
            if(user.getLastname()!= null) {
                return user.getFirstname();
            }
        }

        return alternative;
    }

}
