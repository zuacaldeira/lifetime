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

import com.vaadin.server.FontAwesome;
import lifetime.util.Navigation;
import lifetime.component.custom.LifetimeButtonLink;

/**
 *
 * @author zua
 */
class TimelineButton extends LifetimeButtonLink {

    public TimelineButton(String language) {
        super("Timeline", language, FontAwesome.CLOCK_O);
        addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                getUI().getNavigator().navigateTo(Navigation.TIMELINE_VIEW.getName());
            }
        });
    }

}
