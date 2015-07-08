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
package old.ui.list;

import java.util.List;
import lifetime.business.persistence.Organization;
import old.ui.form.LifetimeForm;
import old.ui.form.OrganizationForm;
import old.ui.item.ItemView;
import old.ui.item.OrganizationInfoView;
import old.util.ServiceLocator;

/**
 *
 * @author lifetime
 */
public class OrganizationList extends LifetimeList<Organization> {

    public OrganizationList(Integer userId, String language) {
        super(userId, language);
        getAddButton().setVisible(false);
    }

    @Override
    protected ItemView getItemView(Organization item) {
        return new ItemView(new OrganizationInfoView(getUserId(), getLanguage(), item), null, null, getLanguage()) {
        };
    }

    @Override
    protected List<Organization> getDataFromServer() {
        return ServiceLocator.findLifetimeService().getOrganizations(getLanguage());
    }

    @Override
    public LifetimeForm<Organization> getFormNew() {
        final Organization organization = new Organization();
        organization.setLanguage(getLanguage());
        return new OrganizationForm(organization, this);
    }

}
