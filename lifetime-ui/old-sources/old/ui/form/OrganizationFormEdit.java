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
package old.ui.form;

import com.vaadin.ui.Notification;
import old.util.ServiceLocator;
import lifetime.business.persistence.Organization;
import old.ui.combo.EmailTextComboBox;
import old.ui.list.LifetimeList;
import old.ui.textField.LifetimeTextField;

/**
 *
 * @author lifetime
 */
public class OrganizationFormEdit extends LifetimeForm<Organization> {
    private EmailTextComboBox emailCombo;
    private LifetimeTextField fullnameTextField;
    private LifetimeTextField shortnameTextField;
    private LifetimeTextField urlTextField;

    public OrganizationFormEdit(Organization organization, LifetimeList<Organization> list) {
        super(null, organization.getLanguage(), organization, list);
        addOrganizationFullname(organization.getFullname());
        addOrganizationShortname(organization.getShortname());
        addOrganizationUrl(organization.getUrl());
    }

    @Override
    public void fillItem() {
        Organization t = getItem();
        t.setFullname(getOrganizationFullname());
        if(getOrganizationFullname() != null) {
            t.setShortname(getOrganizationShortname());
        }
        if(getOrganizationUrl() != null) {
            t.setUrl(getOrganizationUrl());
        }
    }

    @Override
    protected void commitItem() {
        ServiceLocator.findLifetimeService().update(getItem());
        Notification.show("Updated item " + getItem());
    }

    public EmailTextComboBox getEmailCombo() {
        return emailCombo;
    }

    private void addOrganizationFullname(String fullname) {
        fullnameTextField = new LifetimeTextField("Fullname");
        fullnameTextField.setRequired(true);
        fullnameTextField.setImmediate(true);
        if(fullname != null) {
            fullnameTextField.setValue(fullname);
        }
        getMain().addComponent(fullnameTextField);
    }

    private void addOrganizationShortname(String shortname) {
        shortnameTextField = new LifetimeTextField("Shortname");
        shortnameTextField.setImmediate(true);
        if(shortname != null) {
            shortnameTextField.setValue(shortname);
        }
        getMain().addComponent(shortnameTextField);
    }

    private void addOrganizationUrl(String url) {
        urlTextField = new LifetimeTextField("Url");
        urlTextField.setImmediate(true);
        if(url != null) {
            urlTextField.setValue(url);
        }
        getMain().addComponent(urlTextField);
    }

    private String getOrganizationFullname() {
        return fullnameTextField.getValue();
    }

    private String getOrganizationShortname() {
        return shortnameTextField.getValue();
    }

    private String getOrganizationUrl() {
        return urlTextField.getValue();
    }
}
