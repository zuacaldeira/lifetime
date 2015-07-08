/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import lifetime.business.persistence.Linguistic;
import old.ui.label.LifetimeLabel;
import old.ui.label.OrganizationLabel;
import old.ui.label.ToolsLabel;

/**
 *
 * @author azc
 */
public class LinguisticInfoView extends InfoView<Linguistic> {

    public LinguisticInfoView(Linguistic achievement) {
        super(achievement.getUserId(), achievement.getLanguage(), achievement);
        getTitle().addComponent(new LifetimeLabel(achievement.getName(), achievement.getLanguage()));
        //title.addComponent(new Label("in"));
        //title.addComponent(new LifetimeLabel(achievement.getCourse()));
        if (achievement.getOrganization() != null) {
            getBody().addComponent(
                    new OrganizationLabel(achievement.getOrganization(), achievement.getLanguage()));
        }
        if (achievement.getLevel() != null) {
            getBody().addComponent(new LifetimeLabel(achievement.getLevel(), achievement.getLanguage()));
        }
        if (achievement.getTools() != null) {
            getBody().addComponents(new ToolsLabel(achievement.getTools().toString(), achievement.getLanguage()));
        }
    }

    @Override
    protected QAView getQAView() {
        return new LinguisticQAView(getItem());
    }
}
