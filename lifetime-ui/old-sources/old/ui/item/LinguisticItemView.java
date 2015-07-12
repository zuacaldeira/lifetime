/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import lifetime.business.persistence.Linguistic;

/**
 *
 * @author azc
 */
public class LinguisticItemView extends ItemView {

    public LinguisticItemView(Linguistic achievement) {
        super(new LinguisticInfoView(achievement), achievement.getStart(), achievement.getEnd(), achievement.getLanguage());
    }



    
}
