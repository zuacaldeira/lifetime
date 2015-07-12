/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import lifetime.business.persistence.Entrepeneurship;

/**
 *
 * @author azc
 */
public class EntrepeneurshipItemView extends ItemView {
    public EntrepeneurshipItemView(Entrepeneurship achievement) {
        super(new EntrepeneurshipInfoView(achievement), achievement.getStart(), achievement.getEnd(), achievement.getLanguage());
    }
}
