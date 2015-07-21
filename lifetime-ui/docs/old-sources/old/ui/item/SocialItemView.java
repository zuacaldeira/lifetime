/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import lifetime.business.persistence.Social;

/**
 *
 * @author azc
 */
public class SocialItemView extends ItemView {

    public SocialItemView(Social achievement) {
        super(new SocialInfoView(achievement), achievement.getStart(), achievement.getEnd(), achievement.getLanguage());
    }
}
