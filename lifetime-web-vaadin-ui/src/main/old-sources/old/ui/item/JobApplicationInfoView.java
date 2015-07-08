/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import lifetime.business.persistence.JobApplication;
import old.ui.label.LifetimeLabel;

/**
 *
 * @author azc
 */
public class JobApplicationInfoView extends InfoView<JobApplication> {

    public JobApplicationInfoView(Integer userId, String language, JobApplication jobApplication) {
        super(userId, language, jobApplication);
        // Title
        getTitle().addComponent(new LifetimeLabel(String.valueOf(jobApplication.getJobOfferId())));
        // Body
        Label email = new LifetimeLabel(jobApplication.getEmailText(), ContentMode.HTML);
        HorizontalLayout contact = new HorizontalLayout(email);
        contact.setSpacing(true);
        contact.setSizeFull();
        getBody().addComponent(contact);
    }

    @Override
    protected QAView getQAView() {
        return new JobApplicationQAView(getUserId(), getLanguage(), getItem());
    }

}
