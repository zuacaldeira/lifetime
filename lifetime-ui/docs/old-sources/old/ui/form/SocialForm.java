/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.form;

import lifetime.business.persistence.Social;
import old.ui.list.SocialList;

/**
 *
 * @author azc
 */
public abstract class SocialForm extends LifetimeForm<Social> { 
    public SocialForm(Social social, SocialList list) {
        super(social.getUserId(), social.getLanguage(), social, list);
        addLanguage(social.getLanguage());
        addOrganization(social.getOrganization());
        addDescription(social.getDescription());
        addStatus(social.getStatus());
        addStart(social.getStart());
        addEnd(social.getEnd());
    }

}
