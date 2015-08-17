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
package lifetime.view.user;

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import java.text.DateFormat;
import java.util.Date;
import lifetime.backend.persistence.User;

/**
 *
 * @author zua
 */
public class BirthDataLayout extends AbsoluteLayout {

    private final User user;
    private VerticalLayout birthDataLayout;
    private Label name;
    private Label date;
    private Label dateIcon;

    private HorizontalLayout dateLayout;
    private Label place;
    private Label placeIcon;
    private HorizontalLayout placeLayout;
    private String UNKNOWN;

    public BirthDataLayout(User user) {
        this.user = user;
        initPersonalDataLayout();
    }
    
    public User getUser() {
        return user;
    }

    private void initPersonalDataLayout() {
        // Name
        if (user.getFirstname() != null && user.getLastname() != null) {
            name = new Label(user.getFirstname() + " " + user.getLastname());
        }
        else {
            name = new Label(UNKNOWN);
        }
        // Date
        if (user.getBirthDate() != null) {
            date = new Label(DateFormat.getInstance().format(user.getBirthDate()));
        } else {
            date = new Label(DateFormat.getInstance().format(new Date()));
        }

        dateIcon = new Label(FontAwesome.CLOCK_O.getHtml(), ContentMode.HTML);
        dateLayout = new HorizontalLayout(dateIcon, date);
        dateLayout.setSpacing(true);
        // Place
        place = new Label(user.getBirthPlace());
        placeIcon = new Label(FontAwesome.MAP_MARKER.getHtml(), ContentMode.HTML);
        placeLayout = new HorizontalLayout(placeIcon, place);
        placeLayout.setSpacing(true);
        // Container layout
        birthDataLayout = new VerticalLayout(name, dateLayout, placeLayout);
        // add the data container to the panel
        addComponent(birthDataLayout);
    }

}
