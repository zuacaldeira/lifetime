/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import lifetime.business.persistence.Other;

/**
 *
 * @author azc
 */
public class OtherItemView extends ItemView {

    public OtherItemView(Other achievement) {
        super(new OtherInfoView(achievement), achievement.getStart(), achievement.getEnd(), achievement.getLanguage());
    }
}
