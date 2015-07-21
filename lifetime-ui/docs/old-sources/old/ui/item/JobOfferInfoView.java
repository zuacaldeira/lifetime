/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import lifetime.business.persistence.JobOffer;
import old.ui.label.KeyLabel;
import old.ui.label.LifetimeLabel;
import old.ui.label.OrganizationLabel;
import old.ui.label.ToolsLabel;

/**
 *
 * @author azc
 */
public class JobOfferInfoView extends InfoView<JobOffer> {

    public JobOfferInfoView(Integer userId, String language, JobOffer jobOffer) {
        super(userId, language, jobOffer);
        if (jobOffer.getPosition() != null) {
            getTitle().addComponent(new LifetimeLabel(jobOffer.getPosition().getName(), getLanguage()));
        }
        if(jobOffer.getReference() != null) {
            getTitle().addComponent(new KeyLabel(" ref ", jobOffer.getLanguage()));
            getTitle().addComponent(new LifetimeLabel(jobOffer.getReference(), getLanguage()));
        }
        if(jobOffer.getOrganization() != null) {
            getBody().addComponents(new OrganizationLabel(jobOffer.getOrganization(), getLanguage()));
        }

        Label tit = new LifetimeLabel(jobOffer.getContactTitle(), getLanguage());
        Label name = new LifetimeLabel(jobOffer.getContactName(), getLanguage());
        Label email = new LifetimeLabel(jobOffer.getContactEmail(), getLanguage());
        HorizontalLayout contact = new HorizontalLayout(tit, name, email);
        contact.setSpacing(true);
        getBody().addComponent(contact);
        getBody().addComponent(new LifetimeLabel(jobOffer.getDescription(), ContentMode.HTML));
        if (jobOffer.getTools() != null) {
            getBody().addComponents(new ToolsLabel(jobOffer.getTools().toString(), jobOffer.getLanguage()));
        }
    }

    @Override
    protected QAView getQAView() {
        return new JobOfferQAView(getUserId(), getLanguage(), getItem());
    }

}
