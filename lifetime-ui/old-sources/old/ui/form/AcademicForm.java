/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.form;

import com.vaadin.ui.Button;
import lifetime.business.persistence.Academic;
import old.ui.list.AcademicList;

/**
 *
 * @author azc
 */
public abstract class AcademicForm extends LifetimeForm<Academic> implements Button.ClickListener {

    public AcademicForm(Academic academic, AcademicList list) {
        super(academic.getUserId(), academic.getLanguage(), academic, list);
        //addLanguage(academic.getLanguage());
        addDegree(academic.getDegree());
        // addTitle(academic.getTitle());
        addCourse(academic.getCourse());
        addGrade(String.valueOf(academic.getGrade()));
        addOrganization(academic.getOrganization());
        addStatus(academic.getStatus());
        addDescription(academic.getDescription());
        addStart(academic.getStart());
        addEnd(academic.getEnd());
    }

}
