/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import lifetime.business.persistence.Organization;
import old.ui.label.LifetimeLabel;

/**
 *
 * @author azc
 */
public class OrganizationInfoView extends InfoView<Organization> {

    public OrganizationInfoView(Integer userId, String language, Organization organization) {
        super(userId, language, organization);
        // Title
        getTitle().addComponent(new LifetimeLabel(String.valueOf(organization.getFullname())));
        // Body
        Label url = new LifetimeLabel(organization.getUrl(), ContentMode.HTML);
        HorizontalLayout urlLayout = new HorizontalLayout(url);
        urlLayout.setSpacing(true);
        urlLayout.setSizeFull();
        getBody().addComponent(urlLayout);
    }

    @Override
    protected QAView getQAView() {
        return new OrganizationQAView(getUserId(), getLanguage(), getItem());
    }

}
