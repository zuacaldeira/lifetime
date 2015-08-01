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
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import java.text.DateFormat;
import java.util.Objects;
import lifetime.persistence.Contact;
import lifetime.service.LifetimeAccountBusiness;
import lifetime.util.ServiceLocator;
import lifetime.view.custom.InfoView;

/**
 *
 * @author zua
 */
public class AccountDetailsLayout extends TabSheet {

    private final ProfileSummaryLayout profile;
    private final String username;

    public AccountDetailsLayout(String username) {
        profile = new ProfileSummaryLayout(username);
        this.username = username;
        Tab t1 = addTab(profile, "Personal");
        t1.setIcon(FontAwesome.INFO);
        setStyleName("account-details");
        setSizeFull();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.profile);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AccountDetailsLayout)) {
            return false;
        }
        final AccountDetailsLayout other = (AccountDetailsLayout) obj;
        return Objects.equals(this.username, other.username);
    }

}

class ProfileSummaryLayout extends VerticalLayout {

    private transient LifetimeAccountBusiness service;
    private final DateFormat df = DateFormat.getDateInstance();
    private String username;

    public ProfileSummaryLayout(String username) {
        this.username = username;
        setSpacing(true);
        setSizeFull();
    }

    @Override
    public void attach() {
        super.attach(); //To change body of generated methods, choose Tools | Templates.
        init();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ProfileSummaryLayout)) {
            return false;
        }
        final ProfileSummaryLayout other = (ProfileSummaryLayout) obj;
        return Objects.equals(this.username, other.username);
    }

    private void init() {
        this.service = ServiceLocator.findLifetimeAccountService();
        if (service != null && username != null) {
            // Name
            InfoView name = new InfoView("Name", service.getFullName(username));
            // Birthdate & Birthplace
            InfoView birth = new InfoView("Birthdate & Birthplace", df.format(service.getBirthdate(username)) + " - " + service.getBirthPlace(username));
            // Address
            InfoView address = new InfoView("Address", service.getAddress(username).toString());
            // Contact
            Contact contact = service.getContact(username);
            InfoView phone = new InfoView("Telephone", contact.getTelephone1());
            InfoView mobile = new InfoView("Mobile", contact.getMobile1());
            HorizontalLayout contacts = new HorizontalLayout(phone, mobile);
            contacts.setSpacing(true);
            // Add all to the base layout
            addComponents(name, birth, address, contacts);
        }
    }

}
