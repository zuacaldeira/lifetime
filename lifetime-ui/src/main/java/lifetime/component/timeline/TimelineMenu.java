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
package lifetime.component.timeline;

import com.vaadin.server.FontAwesome;
import lifetime.component.custom.BackToProfileButton;
import lifetime.component.LifetimeMenu;
import lifetime.component.custom.LifetimeButtonLink;

/**
 *
 * @author zua
 */
class TimelineMenu extends LifetimeMenu {
    private final String username;
    private LifetimeButtonLink zoomIn;
    private LifetimeButtonLink zoomOut;
    private BackToProfileButton profileButton;

    public TimelineMenu(String username, String language) {
        super(language);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    protected void addControls() {
        profileButton = new BackToProfileButton(username, getLanguage());
        zoomIn = new LifetimeButtonLink(username, getLanguage(), "Zoon In", FontAwesome.PLUS_CIRCLE);
        zoomOut = new LifetimeButtonLink(username, getLanguage(), "Zoon Out", FontAwesome.MINUS_CIRCLE);
        addControl(profileButton);
        addControl(zoomIn);
        addControl(zoomOut);
    }
    
    
    
    
    
}
