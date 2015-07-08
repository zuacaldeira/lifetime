/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.form;

import com.vaadin.ui.Button;
import lifetime.business.persistence.Certification;
import old.ui.list.CertificationList;

/**
 *
 * @author azc
 */
public abstract class CertificationForm extends LifetimeForm<Certification> implements Button.ClickListener {

    public CertificationForm(Certification certification, CertificationList list) {
        super(certification.getUserId(), certification.getLanguage(), certification, list);
        addLanguage(certification.getLanguage());
        addDegree(certification.getDegree());
        //addCourse(certification.getCourse());
        //addGrade(String.valueOf(certification.getGrade()));
        addOrganization(certification.getOrganization());
        addStatus(certification.getStatus());
        addDescription(certification.getDescription());
        addStart(certification.getStart());
        addEnd(certification.getEnd());
    }


}
