/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import lifetime.business.persistence.Academic;
import old.ui.label.KeyLabel;
import old.ui.label.LifetimeLabel;
import old.ui.label.OrganizationLabel;
import old.ui.label.ToolsLabel;

/**
 *
 * @author azc
 */
public class AcademicInfoView extends InfoView<Academic> {

    public AcademicInfoView(Academic achievement) {
        super(achievement.getUserId(), achievement.getLanguage(), achievement);
        if (achievement.getDegree() != null) {
            getTitle().addComponent(new LifetimeLabel(achievement.getDegree().getFullname(), achievement.getLanguage()));
            getTitle().addComponent(new KeyLabel("in", achievement.getLanguage()));
        }
        if(achievement.getCourse() != null) {
            getTitle().addComponent(new LifetimeLabel(achievement.getCourse().getName(), achievement.getLanguage()));
        }
        if (achievement.getOrganization() != null) {
            getBody().addComponents(
                    new OrganizationLabel(achievement.getOrganization(), achievement.getLanguage()));
        }
        if (achievement.getTools() != null) {
            getBody().addComponents(new ToolsLabel(achievement.getTools().toString(), achievement.getLanguage()));
        }
    }

    @Override
    protected QAView getQAView() {
        return new AcademicQAView(getItem());
    }

}
