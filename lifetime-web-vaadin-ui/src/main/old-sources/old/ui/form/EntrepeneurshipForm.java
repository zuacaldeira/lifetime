/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.form;

import com.vaadin.ui.Button;
import lifetime.business.persistence.Entrepeneurship;
import old.ui.list.EntrepeneurshipList;

/**
 *
 * @author azc
 */
public abstract class EntrepeneurshipForm extends LifetimeForm<Entrepeneurship> implements Button.ClickListener {

    public EntrepeneurshipForm(Entrepeneurship project, EntrepeneurshipList list) {
        super(project.getUserId(), project.getLanguage(), project, list);
        addLanguage(project.getLanguage());
        addPosition(project.getPosition());
        addOrganization(project.getOrganization());
        addDescription(project.getDescription());
        addStatus(project.getStatus());
        addStart(project.getStart());
        addEnd(project.getEnd());
    }

}
