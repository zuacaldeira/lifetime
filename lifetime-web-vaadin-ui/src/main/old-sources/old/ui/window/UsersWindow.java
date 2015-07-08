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
package old.ui.window;

import old.util.ServiceLocator;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;
import java.util.List;
import lifetime.business.persistence.User;
import old.util.Translator;
import old.ui.menu.VerticalList;

/**
 *
 * @author lifetime
 */
public class UsersWindow extends Window {
    
    public UsersWindow(Integer userId, String language) {
        super(Translator.getTranslation("User Management Tool", language));
        setWidth("33%");
        setHeight("75%");
        center();

        List<User> users = ServiceLocator.findLifetimeService().getAllUsers();
        
        VerticalList vList = new VerticalList(userId, language);
        vList.setHeightUndefined();
        for(User u: users) {
            vList.add(u);
        }
        Panel panel = new Panel(vList);
        panel.setSizeFull();
        setContent(panel);
        addCloseListener(new CloseListener() {

            @Override
            public void windowClose(CloseEvent e) {
                close();
            }
        });
        setStyleName("window");
    }
}
