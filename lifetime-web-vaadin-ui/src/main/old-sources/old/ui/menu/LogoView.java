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
package old.ui.menu;

import old.ui.helper.UserNavigationContext;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author lifetime
 */
public class LogoView extends VerticalLayout {

    private final HorizontalLayout names;

    public LogoView(Integer userId, String language, Integer visitorId) {
        names = new UserNavigationContext(userId, visitorId, language);
        names.setStyleName("logo-username");

        addComponent(names);
        //setComponentAlignment(names, Alignment.MIDDLE_CENTER);
        setStyleName("logo");
    }

}
