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
import lifetime.business.persistence.JobApplication;
import lifetime.business.persistence.JobOffer;
import old.ui.form.LifetimeForm;
import old.ui.form.JobOfferForm;
import old.ui.item.ItemView;
import old.ui.item.JobOfferInfoView;
import old.util.ServiceLocator;

/**
 *
 * @author lifetime
 */
public class JobOfferList extends LifetimeList<JobOffer> {

    public JobOfferList(Integer userId, String language) {
        super(userId, language);
    }

    @Override
    protected ItemView getItemView(JobOffer item) {
        return new ItemView(new JobOfferInfoView(getUserId(), getLanguage(), item), item.getStart(), item.getEnd(), getLanguage()) {
        };
        /*   JobApplication ja = getJobApplication(item, getUserId());
         if(ja == null) {
         return new ItemView(new JobOfferInfoView(getUserId(), getLanguage(), item), item.getStart(), item.getEnd(), getLanguage()) {};
         }
         return null;*/
    }

    @Override
    protected List<JobOffer> getDataFromServer() {
        return ServiceLocator.findLifetimeService().getJobOffers(getLanguage());
    }

    @Override
    public LifetimeForm<JobOffer> getFormNew() {
        final JobOffer jOffer = new JobOffer();
        return new JobOfferForm(getUserId(), getLanguage(), jOffer, this);
    }

    private JobApplication getJobApplication(JobOffer item, Integer userId) {
        return ServiceLocator.findLifetimeService().getJobApplication(item.getId(), getUserId());
    }

}
