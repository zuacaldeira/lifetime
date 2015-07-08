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
package old.ui.window;

import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import java.util.Date;
import lifetime.business.persistence.JobApplication;
import lifetime.business.persistence.JobOffer;
import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.WizardProgressBar;
import org.vaadin.teemu.wizards.event.WizardCancelledEvent;
import org.vaadin.teemu.wizards.event.WizardCompletedEvent;
import org.vaadin.teemu.wizards.event.WizardProgressListener;
import org.vaadin.teemu.wizards.event.WizardStepActivationEvent;
import org.vaadin.teemu.wizards.event.WizardStepSetChangedEvent;
import old.ui.wizard.CVStep;
import old.ui.wizard.CreateEmailStep;
import old.ui.wizard.CreateLetterStep;
import old.ui.wizard.SendApplicationStep;

/**
 *
 * @author lifetime
 */
public class ApplyNowWindow extends LifetimeWindow implements
        WizardProgressListener {

    private Wizard wizard;
    private CVStep cvProcess;
    private CreateLetterStep letterProcess;
    private SendApplicationStep sendApplicationProcess;
    private final JobOffer jobOffer;
    private CreateEmailStep emailProcess;
    private JobApplication jobApplication;

    public ApplyNowWindow(Integer userId, String language, JobOffer job) {
        super(userId, language, "Job Application");
        this.jobOffer = job;
        jobApplication = new JobApplication(null, jobOffer.getId(), language, new Date(), userId);
        setSizeFull();
        setContent(getApplicationDialog());
    }

    public JobOffer getJob() {
        return jobOffer;
    }

    private Component getApplicationDialog() {
        wizard = new Wizard();
        wizard.addListener(this);

        cvProcess = new CVStep(getUserId(), getLanguage());
        wizard.addStep(cvProcess);

        letterProcess = new CreateLetterStep(getUserId(), getLanguage(), getJob());
        wizard.addStep(letterProcess);

        emailProcess = new CreateEmailStep(getJob(), jobApplication);
        wizard.addStep(emailProcess);

        sendApplicationProcess = new SendApplicationStep(getUserId(), getLanguage());
        wizard.addStep(sendApplicationProcess);

        wizard.setSizeFull();

        // setup the progress bar
        WizardProgressBar progressBar = new WizardProgressBar(wizard);
        wizard.addListener(progressBar);
        wizard.setHeader(progressBar);
        return wizard;
    }

    @Override
    public void wizardCompleted(WizardCompletedEvent event) {
        wizard.setVisible(false);
        Notification.show("Wizard Completed!", Notification.Type.HUMANIZED_MESSAGE);
        getContent().setCaption("Wizard Completed!");
        close();
    }

    @Override
    public void activeStepChanged(WizardStepActivationEvent event) {
        // display the step caption as the window title
        Notification.show("activeStepChanged");
        setCaption(event.getActivatedStep().getCaption());
        if (event.getActivatedStep() == cvProcess) {

        } else if (event.getActivatedStep() == letterProcess) {
            // letterProcess.setPosition(jobOfferProcess.getContent().getPosition());
            //letterProcess.setTasks(jobOfferProcess.getContent().getTasks().getTasks());
            //letterProcess.setTools(jobOfferProcess.getContent().getTools().getTools());
        } else if (event.getActivatedStep() == emailProcess) {
            // letterProcess.setPosition(jobOfferProcess.getContent().getPosition());
            //letterProcess.setTasks(jobOfferProcess.getContent().getTasks().getTasks());
            //letterProcess.setTools(jobOfferProcess.getContent().getTools().getTools());
        } else if (event.getActivatedStep() == sendApplicationProcess) {
            jobApplication.setCoverLetterId(letterProcess.getCoverLetter().getId());
            jobApplication.setCoverLetterImage(letterProcess.getBytes());
            jobApplication.setResumeeImage(cvProcess.getBytes());
            sendApplicationProcess.setDocuments(cvProcess.getDocuments());
            sendApplicationProcess.setJobApplication(jobApplication);
            sendApplicationProcess.setEmailText(emailProcess.getEmailText());
        } else {
            Notification.show("Unknown Wizard Step", Type.ERROR_MESSAGE);
        }

    }

    @Override
    public void stepSetChanged(WizardStepSetChangedEvent event) {
        Notification.show("stepSetChanged");
    }

    @Override
    public void wizardCancelled(WizardCancelledEvent event) {
        Notification.show("wizardCancelled");
        close();
    }
}
