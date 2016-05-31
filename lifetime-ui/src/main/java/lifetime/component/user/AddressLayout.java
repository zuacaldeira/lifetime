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
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import lifetime.backend.persistence.jooq.tables.Address;

/**
 *
 * @author zua
 */
public class AddressLayout extends AbsoluteLayout {

    private final Address address;
    private VerticalLayout layout;

    public AddressLayout(Address address) {
        this.address = address;
        initLayout();
    }

    public Address getAddress() {
        return address;
    }

    private void initLayout() {
        // Street, door and floor coordinates
        HorizontalLayout street = new HorizontalLayout(
                new Label(address.STREET.toString()));
        street.setSpacing(true);
        Label streetIcon = new Label(FontAwesome.ENVELOPE.getHtml(), ContentMode.HTML);

        HorizontalLayout streetLayout = new HorizontalLayout(streetIcon, street);
        streetLayout.setSpacing(true);

        // Postal code and city/locality
        HorizontalLayout locality = new HorizontalLayout(
                new Label(address.POSTAL_CODE.toString()),
                new Label(address.LOCALITY.toString()));
        locality.setSpacing(true);

        // Region and country
        HorizontalLayout country = new HorizontalLayout(
                new Label(address.COUNTRY.toString()));
        country.setSpacing(true);

        // Final address layout
        layout = new VerticalLayout(streetLayout, locality, country);
        // add in to base content
        addComponent(layout);
        //base.setComponentAlignment(addressLayout, Alignment.MIDDLE_RIGHT);
    }

}
