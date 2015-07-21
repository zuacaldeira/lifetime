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
package old.ui.combo;

import com.vaadin.ui.Notification;
import lifetime.business.persistence.Organization;
import old.ui.data.OrganizationDataContainer;
import old.util.ServiceLocator;

/**
 *
 * @author lifetime
 */
public class OrganizationComboBox extends LifetimeComboBox {

    public OrganizationComboBox(String language) {
        super("Organization", language, new OrganizationDataContainer(language));
        setNewItemsAllowed(true);
        setImmediate(true);
        setRequired(true);
        setNewItemHandler(new NewItemHandler() {
            @Override
            public void addNewItem(String newItemCaption) {
                Organization org = new Organization(null, newItemCaption,getLanguage());
                ServiceLocator.findLifetimeService().add(org);
                Notification.show("Retrieved organization " + org);
                addItem(org);
                setValue(org);
            }
        });
    }
    
    @Override
    public Organization getValue() {
        return (Organization) super.getValue();
    }
    
}
