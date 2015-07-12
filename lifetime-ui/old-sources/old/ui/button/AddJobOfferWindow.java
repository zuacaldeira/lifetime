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
package old.ui.button;

import lifetime.business.persistence.JobOffer;
import old.ui.form.JobOfferForm;
import old.ui.list.JobOfferList;
import old.ui.window.LifetimeWindow;

/**
 *
 * @author lifetime
 */
class AddJobOfferWindow extends LifetimeWindow {
    private final JobOfferForm form;

    public AddJobOfferWindow(Integer userId, String language, JobOfferList list) {
        super(userId, language, "New Job Offer");
        JobOffer offer = new JobOffer();
        offer.setLanguage(language);
        form = new JobOfferForm(userId, language, offer, list);
        setContent(form);
    }
    
}
