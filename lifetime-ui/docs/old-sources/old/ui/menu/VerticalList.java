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

import old.ui.button.VisitButton;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import lifetime.business.persistence.User;

/**
 *
 * @author lifetime
 */
public class VerticalList extends VerticalLayout {
    
    private Component selected;
    private final Integer userId;
    private final String language;
    
    public VerticalList(Integer userId, String language) {
        setSizeFull();
        this.userId = userId;
        this.language = language;
    }
    
    public void add(User u) {
        VisitButton b = new VisitButton(userId, u.getId(), u.getFirstname() + " " + u.getLastname(), language);
        addComponent(b);
        selected = b;
    }
    
}
