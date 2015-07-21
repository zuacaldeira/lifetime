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
package old.ui.button;

import old.util.ServiceLocator;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

/**
 *
 * @author lifetime
 */
public class VisitButton extends LifetimeButtonSmall {

    private final Integer guest;
    private final Integer host;
    private final String language;

    public VisitButton(final Integer userId, final Integer hostId, String hostname, String language) {
        super(hostname, FontAwesome.LINK);
        this.guest = userId;
        this.host = hostId;
        this.language = language;
        addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                ServiceLocator.findLifetimeService().setHostId(guest, host);
                String path = VaadinService.getCurrentRequest().getContextPath();
                Page.getCurrent().setLocation(path + "/visitor");
            }
        });
    }

}
