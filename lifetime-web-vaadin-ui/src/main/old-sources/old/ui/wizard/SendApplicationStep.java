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
package old.ui.wizard;

import old.ui.label.LifetimeLabel;
import old.util.ServiceLocator;
import com.vaadin.ui.Component;
import lifetime.business.persistence.JobApplication;
import lifetime.business.persistence.JobOffer;

/**
 *
 * @author lifetime
 */
public class SendApplicationStep extends LifetimeWizardStep {
    private byte[][] documents;
    private String emailText;
    private JobApplication jobApplication;
    private JobOffer jobOffer;

    public SendApplicationStep(Integer userId, String language) {
        super(userId, language);
    }

    public JobApplication getJobApplication() {
        return jobApplication;
    }

    public void setJobApplication(JobApplication jobApplication) {
        this.jobApplication = jobApplication;
    }

    public JobOffer getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(JobOffer jobOffer) {
        this.jobOffer = jobOffer;
    }

    public byte[][] getDocuments() {
        return documents;
    }
    
    

    @Override
    public String getCaption() {
        return "Application Summary";
    }

    @Override
    public Component getContent() {
        return new LifetimeLabel("Application ready", getLanguage());
    }

    @Override
    public boolean onAdvance() {
        if(emailText != null) {
            jobApplication.setEmailText(emailText);
        }
        ServiceLocator.findLifetimeService().add(jobApplication);
        //ServiceLocator.findLifetimeService().sendJobApplication(getUserId(), getLanguage(), jobApplication, documents);
        return true;
    }

    @Override
    public boolean onBack() {
        return true;
    }
    
    public void setDocuments(byte[][] documents) {
        this.documents = documents;
    }

    public String getEmailText() {
        return emailText;
    }

    public void setEmailText(String emailText) {
        this.emailText = emailText;
    }
    
    
}
