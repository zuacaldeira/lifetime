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
import old.ui.form.JobApplicationForm;
import old.ui.form.LifetimeForm;
import old.ui.item.ItemView;
import old.ui.item.JobApplicationInfoView;
import old.util.ServiceLocator;

/**
 *
 * @author lifetime
 */
public class JobApplicationList extends LifetimeList<JobApplication> {

    public JobApplicationList(Integer userId, String language) {
        super(userId, language);
        getAddButton().setVisible(false);
    }

    @Override
    protected ItemView getItemView(JobApplication item) {
        return new ItemView(new JobApplicationInfoView(getUserId(), getLanguage(), item), item.getCreatedAt(), null, getLanguage()) {
        };
    }

    @Override
    protected List<JobApplication> getDataFromServer() {
        return ServiceLocator.findLifetimeService().getJobApplications(getUserId(), getLanguage());
    }

    @Override
    public LifetimeForm<JobApplication> getFormNew() {
        final JobApplication jobApplication = new JobApplication();
        jobApplication.setLanguage(getLanguage());
        jobApplication.setUserId(getUserId());
        return new JobApplicationForm(jobApplication, this);
    }

}
