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
import lifetime.business.persistence.JobOffer;
import old.ui.list.LifetimeList;

/**
 *
 * @author lifetime
 */
public class JobOfferFormEdit extends LifetimeForm<JobOffer> {

    public JobOfferFormEdit(JobOffer achievement, LifetimeList<JobOffer> list) {
        super(null, achievement.getLanguage(), achievement, list);
        addPosition(achievement.getPosition());
        addReference(achievement.getReference());
        addContactTitle(achievement.getContactTitle());
        addContactName(achievement.getContactName());
        addContactEmail(achievement.getContactEmail());
        addOrganization(achievement.getOrganization());
        addDescription(achievement.getDescription());
        addStart(achievement.getStart());
        addEnd(achievement.getEnd());
    }

    @Override
    public void fillItem() {
        JobOffer t = getItem();
        //
        if(getPosition().getValue() != null) {
            t.setPosition(getPosition().getValue());
        }
        
        t.setReference(getReference().getValue());
        //
        Notification.show("Updated title " +  ((Enum<ContactTitle>) getContactTitle().getValue()).name());
        t.setContactTitle( ((Enum<ContactTitle>) getContactTitle().getValue()).name());
        t.setContactName(getContactName().getValue());
        t.setContactEmail(getContactEmail().getValue());
        // Job description
        t.setDescription(getDesc().getValue());
        t.setLanguage(getLanguage());
        t.setOrganization(getOrganization().getValue());
        // Time interval
        t.setStart(getStart().getValue());
        t.setEnd(getEnd().getValue());
    }

    @Override
    protected void commitItem() {
        ServiceLocator.findLifetimeService().update(getItem());
        Notification.show("Updated item " + getItem());
    }

}
