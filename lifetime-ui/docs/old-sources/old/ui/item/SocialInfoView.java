/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import lifetime.business.persistence.Social;
import old.ui.label.LifetimeLabel;
import old.ui.label.DescriptionLabel;
import old.ui.label.OrganizationLabel;
import old.ui.label.ToolsLabel;

/**
 *
 * @author azc
 */
public class SocialInfoView extends InfoView<Social> {

    public SocialInfoView(Social achievement) {
        super(achievement.getUserId(), achievement.getLanguage(), achievement);
        getTitle().addComponent(new LifetimeLabel(achievement.getTitle(), achievement.getLanguage()));
        if (achievement.getOrganization() != null) {
            getBody().addComponent(
                    new OrganizationLabel(achievement.getOrganization(), achievement.getLanguage()));
        }
        if (achievement.getDescription()!= null) {
            getBody().addComponent(new DescriptionLabel(achievement.getDescription(), achievement.getLanguage()));
        }
        if (achievement.getTools() != null) {
            getBody().addComponents(new ToolsLabel(achievement.getTools().toString(), achievement.getLanguage()));
        }
    }

    @Override
    protected QAView getQAView() {
        return new SocialQAView(getItem());
    }
}
