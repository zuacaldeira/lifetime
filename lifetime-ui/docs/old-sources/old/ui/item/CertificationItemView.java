/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import lifetime.business.persistence.Certification;

/**
 *
 * @author azc
 */
public class CertificationItemView extends ItemView {
    
    public CertificationItemView(Certification achievement) {
        super(new CertificationInfoView(achievement), achievement.getStart(), achievement.getEnd(), achievement.getLanguage());
    }

    

}
