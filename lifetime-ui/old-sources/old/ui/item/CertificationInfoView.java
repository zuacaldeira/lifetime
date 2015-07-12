/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import lifetime.business.persistence.Certification;
import old.ui.label.KeyLabel;
import old.ui.label.LifetimeLabel;
import old.ui.label.OrganizationLabel;
import old.ui.label.ToolsLabel;
import old.util.Translator;

/**
 *
 * @author azc
 */
public class CertificationInfoView extends InfoView<Certification> {

    public CertificationInfoView(Certification item) {
        super(item.getUserId(), item.getLanguage(), item);
        if (item.getDegree()!= null) {
            getTitle().addComponent(new LifetimeLabel(item.getDegree().getFullname(), item.getLanguage()));
            String in = Translator.getTranslation("in", item.getLanguage());
            getTitle().addComponent(new KeyLabel(in, item.getLanguage()));
        }
        if(item.getCourse() != null) {
            getTitle().addComponent(new LifetimeLabel(item.getCourse().getName(), item.getLanguage()));
        }
        if (item.getOrganization() != null) {
            getBody().addComponents(
                    new OrganizationLabel(item.getOrganization(), item.getLanguage()));
        }
        if (item.getTools() != null) {
            getBody().addComponents(new ToolsLabel(item.getTools().toString(), item.getLanguage()));
        }
    }

    @Override
    protected QAView getQAView() {
        return new CertificationQAView(getItem());
    }
}
