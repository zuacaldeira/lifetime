/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import lifetime.business.persistence.Academic;

/**
 *
 * @author azc
 */
public class AcademicItemView extends ItemView {

    public AcademicItemView(Academic achievement) {
        super(new AcademicInfoView(achievement), achievement.getStart(), achievement.getEnd(), achievement.getLanguage());
        setSizeFull();
    }


}
