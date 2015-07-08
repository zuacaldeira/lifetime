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

import com.vaadin.ui.Button.ClickListener;
import java.util.Date;
import lifetime.business.persistence.JobOffer;
import old.ui.list.JobOfferList;
import old.util.ServiceLocator;

/**
 *
 * @author lifetime
 */
public class JobOfferForm extends LifetimeForm<JobOffer> implements ClickListener {

    public JobOfferForm(Integer userId, String language, JobOffer jOffer, JobOfferList list) {
        super(userId, language, jOffer, list);
        addPosition(jOffer.getPosition());
        addReference(jOffer.getReference());
        addOrganization(jOffer.getOrganization());
        addContactTitle(jOffer.getContactTitle());
        addContactName(jOffer.getContactName());
        addContactEmail(jOffer.getContactEmail());
        addDescription(jOffer.getDescription());
        addStart(jOffer.getStart());
        addEnd(jOffer.getEnd());
    }

    @Override
    public void fillItem() {
        JobOffer t = getItem();
        t.setPosition(getPosition().getValue());
        t.setReference(getReference().getValue());
        t.setContactEmail(getContactEmail().getValue());
        t.setContactTitle( ((Enum<ContactTitle>) getContactTitle().getValue()).name());
        t.setContactName(getContactName().getValue());
        t.setDescription(getDesc().getValue());
        t.setLanguage(getLanguage());
        t.setOrganization(getOrganization().getValue());
        t.setCreatedAt(new Date());
        t.setStart(getStart().getValue());
        t.setEnd(getEnd().getValue());
    }

    @Override
    protected void commitItem() {
        ServiceLocator.findLifetimeService().add(getItem());
    }


}
