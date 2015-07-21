/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import lifetime.business.persistence.Professional;

/**
 *
 * @author azc
 */
public class ProfessionalItemView extends ItemView {
    public ProfessionalItemView(Professional achievement) {
        super(new ProfessionalInfoView(achievement), achievement.getStart(), achievement.getEnd(), achievement.getLanguage());
    }
    
}
