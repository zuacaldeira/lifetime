/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import com.vaadin.ui.Button;
import old.ui.label.DescriptionLabel;
import lifetime.business.persistence.Entrepeneurship;
import old.ui.label.KeyLabel;
import old.ui.label.LifetimeLabel;
import old.ui.label.OrganizationLabel;
import old.ui.label.ToolsLabel;
import old.util.ServiceLocator;

/**
 *
 * @author azc
 */
public class EntrepeneurshipInfoView extends InfoView<Entrepeneurship> {

    public EntrepeneurshipInfoView(Entrepeneurship achievement) {
        super(achievement.getUserId(), achievement.getLanguage(), achievement);
        if (achievement.getPosition() != null) {
            getTitle().addComponent(new LifetimeLabel(achievement.getPosition().getName(), achievement.getLanguage()));
            getTitle().addComponent(new KeyLabel(" at ", achievement.getLanguage()));
        }
        if (achievement.getProject() != null) {
            getTitle().addComponent(new LifetimeLabel(achievement.getProject().getName(), achievement.getLanguage()));
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
        return new EntrepeneurshipQAView(getItem());
    }
    
}
