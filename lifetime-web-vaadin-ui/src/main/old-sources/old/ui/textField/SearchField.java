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
package old.ui.textField;

import old.util.ServiceLocator;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

/**
 *
 * @author lifetime
 */
public class SearchField extends TextField  implements ValueChangeListener {

    public SearchField() {
        setInputPrompt("Search vitae");
        //setIcon(FontAwesome.SEARCH);
        addValueChangeListener(this);
        //setPropertyDataSource(new L);
        setImmediate(true);
        setStyleName("search");
    }
    
            @Override
    public void valueChange(Property.ValueChangeEvent event) {
        Notification.show("Want to VISIT user " + getValue());
        //Users.setHostId(getUserId((String) getValue()));
        UI.getCurrent().getPage().setLocation("/lifetime-web-vaadin-ui/visitor");
    }
    
    private Integer getUserId(String fullname) {
        String[] names = fullname.split(" ", 2);
        Notification.show(names[0] + "--" + names[1]);
        Integer userId = ServiceLocator.findLifetimeService().getUserId(names[0], names[1]);
        return userId;
    }

    
}
