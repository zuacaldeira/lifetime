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

import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import old.util.Translator;

/**
 *
 * @author lifetime
 */
public class LogoutButton extends LifetimeButtonLink implements Button.ClickListener {
    private final String caption;
    private final String language;

    public LogoutButton(Integer userId, String language) {
        super("",FontAwesome.POWER_OFF);
        this.language = language;
        this.caption = Translator.getTranslation("Logout", language);
        addClickListener(this);
        setDescription(caption);
    }

    @Override
    public void buttonClick(ClickEvent event) {
        VaadinSession.getCurrent().close();
        VaadinSession.getCurrent().getSession().invalidate();
        String path = VaadinService.getCurrentRequest().getContextPath();
        Page.getCurrent().setLocation(path);
        String msg = Translator.getTranslation("Loging out...", language);
        Notification.show(msg , Notification.Type.TRAY_NOTIFICATION);
        UI.getCurrent().close();
    }
    
}
