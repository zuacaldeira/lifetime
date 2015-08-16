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
import lifetime.backend.persistence.User;

/**
 *
 * @author zua
 */
public class BirthDataLayout extends AbsoluteLayout {

    private final User user;
    private VerticalLayout birthDataLayout;

    public BirthDataLayout(User user) {
        this.user = user;
        initPersonalDataLayout();
    }

    public User getUser() {
        return user;
    }

    private void initPersonalDataLayout() {
        // Name
        Label name = new Label(user.getFirstname() + " " + user.getLastname());
        // Date
        Label date = new Label(DateFormat.getInstance().format(user.getBirthDate()));
        Label dateIcon = new Label(FontAwesome.CLOCK_O.getHtml(), ContentMode.HTML);
        HorizontalLayout dateLayout = new HorizontalLayout(dateIcon, date);
        dateLayout.setSpacing(true);
        // Place
        Label place = new Label(user.getBirthPlace());
        Label placeIcon = new Label(FontAwesome.MAP_MARKER.getHtml(), ContentMode.HTML);
        HorizontalLayout placeLayout = new HorizontalLayout(placeIcon, place);
        placeLayout.setSpacing(true);
        // Container layout
        birthDataLayout = new VerticalLayout(name, dateLayout, placeLayout);
        // add the data container to the panel
        addComponent(birthDataLayout);
    }

}
