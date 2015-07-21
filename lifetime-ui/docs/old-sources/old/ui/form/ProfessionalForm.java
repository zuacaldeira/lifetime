/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.form;

import com.vaadin.ui.Button;
import lifetime.business.persistence.Professional;
import old.ui.list.ProfessionalList;

/**
 *
 * @author azc
 */
public abstract class ProfessionalForm extends LifetimeForm<Professional> implements Button.ClickListener {

    public ProfessionalForm(Professional professional, ProfessionalList list) {
        super(professional.getUserId(), professional.getLanguage(), professional, list);
        addLanguage(professional.getLanguage());
        addPosition(professional.getPosition());
        addOrganization(professional.getOrganization());
        addDescription(professional.getDescription());
        addStatus(professional.getStatus());
        addStart(professional.getStart());
        addEnd(professional.getEnd());
    }

}
