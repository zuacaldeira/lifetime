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
import lifetime.backend.persistence.Contact;

/**
 *
 * @author zua
 */
class ContactLayout extends AbsoluteLayout {

    private final Contact contact;
    private VerticalLayout contactLayout;

    public ContactLayout(Contact contact) {
        this.contact = contact;
        initContactLayout();
    }

    public Contact getContact() {
        return contact;
    }

    
    private void initContactLayout() {
        // personal telephone
        Label phone = new Label(contact.getTelephone1());
        Label phoneIcon = new Label(FontAwesome.PHONE.getHtml(), ContentMode.HTML);
        HorizontalLayout phoneLayout = new HorizontalLayout(phoneIcon, phone);
        phoneLayout.setSpacing(true);
        // mobile
        Label mobile = new Label(contact.getMobile1());
        Label mobileIcon = new Label(FontAwesome.MOBILE.getHtml(), ContentMode.HTML);
        HorizontalLayout mobileLayout = new HorizontalLayout(mobileIcon, mobile);
        mobileLayout.setSpacing(true);
        // contacts container
        contactLayout = new VerticalLayout(phoneLayout, mobileLayout);
        // add to base panel
        addComponent(contactLayout);
    }

}
