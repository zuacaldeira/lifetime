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

import com.vaadin.data.Property;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.RichTextArea;
import lifetime.business.persistence.JobApplication;
import lifetime.business.persistence.JobOffer;
import lifetime.business.persistence.User;
import old.ui.combo.EmailTextComboBox;
import old.ui.label.LifetimeLabel;
import old.util.ServiceLocator;

/**
 *
 * @author lifetime
 */
public class CreateEmailStep extends LifetimeWizardStep implements Property.ValueChangeListener {

    private final JobOffer jobOffer;
    private final RichTextArea email;
    private final LifetimeLabel output;
    private final JobApplication jobApplication;
    private final EmailTextComboBox template;

    public CreateEmailStep(JobOffer jobOffer, JobApplication jobApplication) {
        super(jobApplication.getUserId(), jobApplication.getLanguage());
        this.jobOffer = jobOffer;
        this.jobApplication = jobApplication;
        output = new LifetimeLabel("", getLanguage(), ContentMode.HTML);
        template = new EmailTextComboBox(getUserId(), getLanguage());
        template.addValueChangeListener(this);

        email = new RichTextArea("Email text");
        email.addValueChangeListener(this);
        email.setValue(getDefaultEmailBody());
        email.setSizeFull();
    }

    private String getDefaultEmailBody() {
        StringBuilder builder = new StringBuilder();
        // Salutation
        builder.append("<p>");
        builder.append("Dear ");
        builder.append(jobOffer.getContactTitle());
        builder.append(" ");
        builder.append(jobOffer.getContactName());
        builder.append("</p>");
        //
        builder.append("<p>");
        builder.append("</p>");
        builder.append("<p>");
        builder.append("</p>");
        builder.append("<p>");
        builder.append("</p>");
        builder.append("<p>");
        builder.append("</p>");
        builder.append("<p>");
        builder.append("Friendly regards");
        builder.append("</p>");
        // Signature
        User user = ServiceLocator.findLifetimeService().getUser(getUserId());
        builder.append("<p>");
        builder.append(user.getFirstname() + " " + user.getLastname());
        builder.append("</p>");
        return builder.toString();
    }

    @Override
    public String getCaption() {
        return "Write Email";
    }

    @Override
    public Component getContent() {
        HorizontalLayout view = new HorizontalLayout(email, output);
        view.setSpacing(true);
        view.setMargin(true);
        view.setSizeFull();
        return view;
    }

    @Override
    public boolean onAdvance() {
        jobApplication.setEmailText(email.getValue());
        return true;
    }

    @Override
    public boolean onBack() {
        return true;
    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        String s = "Property Type: " + event.getProperty().getType() + "\nProperty Value:" + event.getProperty().getValue();
        Notification.show("Value Change Event", s, Notification.Type.HUMANIZED_MESSAGE);
        
        if(template.getValue() != null) {
            email.setValue(template.getValue().getEmailText());
        }
        
        if (email.getValue() != null) {
            Notification.show("EMAIL TEXT", email.getValue(), Notification.Type.HUMANIZED_MESSAGE);
            output.setValue(email.getValue());
        }
    }

    public JobOffer getJobOffer() {
        return jobOffer;
    }

    public String getEmailText() {
        return email.getValue();
    }

}
