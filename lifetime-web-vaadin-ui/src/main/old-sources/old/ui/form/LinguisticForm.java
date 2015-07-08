/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.form;

import com.vaadin.ui.Button;
import lifetime.business.persistence.Linguistic;
import old.ui.list.LinguisticList;

/**
 *
 * @author azc
 */
public abstract class LinguisticForm extends LifetimeForm<Linguistic> implements Button.ClickListener {
    public LinguisticForm(Linguistic l, LinguisticList list) {
        super(l.getUserId(), l.getLanguage(), l, list);
        addLanguage(l.getLanguage());
        addLinguisticSkillName(l.getName());
        //addCourse(certification.getCourse());
        //addGrade(String.valueOf(certification.getGrade()));
        addOrganization(l.getOrganization());
        addStatus(l.getStatus());
        addDescription(l.getDescription());
        addStart(l.getStart());
        addEnd(l.getEnd());
    }

}
