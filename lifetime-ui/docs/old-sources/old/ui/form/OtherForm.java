/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.form;

import lifetime.business.persistence.Other;
import old.ui.list.OtherList;

/**
 *
 * @author azc
 */
public abstract class OtherForm extends LifetimeForm<Other> { 
    public OtherForm(Other item, OtherList list) {
        super(item.getUserId(), item.getLanguage(), item, list);
        addLanguage(item.getLanguage());
        addOrganization(item.getOrganization());
        addDescription(item.getDescription());
        addStatus(item.getStatus());
        addStart(item.getStart());
        addEnd(item.getEnd());
    }

}
