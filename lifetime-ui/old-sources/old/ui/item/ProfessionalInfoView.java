/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import old.ui.label.OrganizationLabel;
import old.ui.label.DescriptionLabel;
import lifetime.business.persistence.Professional;
import old.ui.label.LifetimeLabel;
import old.ui.label.ToolsLabel;

/**
 *
 * @author azc
 */
public class ProfessionalInfoView extends InfoView<Professional> {

    public ProfessionalInfoView(Professional achievement) {
        super(achievement.getUserId(), achievement.getLanguage(), achievement);
        if(achievement.getPosition() != null) {
            getTitle().addComponent(new LifetimeLabel(achievement.getPosition().getName(), achievement.getLanguage()));
        }
        if (achievement.getOrganization() != null) {
            getBody().addComponent(new OrganizationLabel(achievement.getOrganization(), achievement.getLanguage()));
        }
        if (achievement.getDescription() != null && achievement.getDescription().length() > 0) {
            getBody().addComponent(new DescriptionLabel(achievement.getDescription(), achievement.getLanguage()));
        }
        if (achievement.getTools() != null) {
            getBody().addComponents(new ToolsLabel(achievement.getTools().toString(), achievement.getLanguage()));
        }
    }

    @Override
    protected QAView getQAView() {
        return new ProfessionalQAView(getItem());
    }
}
