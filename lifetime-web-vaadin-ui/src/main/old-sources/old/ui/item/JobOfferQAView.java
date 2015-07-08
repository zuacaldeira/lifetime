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
package old.ui.item;

import java.util.HashSet;
import old.util.ServiceLocator;
import java.util.Set;
import lifetime.business.persistence.JobOffer;
import old.ui.button.ApplyNowButton;
import old.ui.form.JobOfferFormEdit;
import old.ui.window.LifetimeWindow;

/**
 *
 * @author lifetime
 */
public class JobOfferQAView extends QAView<JobOffer> {
    private ApplyNowButton applyButton;

    public JobOfferQAView(Integer userId, String language, JobOffer job) {
        super(userId, language, job);
        showApplyButton();
    }
    
    
    private void showApplyButton() {
        applyButton = new ApplyNowButton(getUserId(), getLanguage(), getItem());
        addComponent(applyButton);
    }

    
    

    @Override
    protected Set<String> getNotTranslatedLanguages() {
        return new HashSet();//ServiceLocator.findLifetimeService().getNotTranslatedLanguages(getLanguage(), getItem());
    }

    @Override
    protected void showEditForm() {
        JobOfferFormEdit edit = new JobOfferFormEdit(getItem(), getList());
        LifetimeWindow window = new LifetimeWindow(getUserId(), getLanguage(), "Edit Job Offer");
        window.setContent(edit);
        getUI().addWindow(window);                
    }

    @Override
    protected void showTranslateTo(String language) {
    }

    @Override
    protected void deleteDataFormServer() {
        ServiceLocator.findLifetimeService().delete(getItem());
    }

}
