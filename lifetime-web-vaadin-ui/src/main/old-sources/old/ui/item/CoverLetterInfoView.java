/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import lifetime.business.persistence.CoverLetter;
import old.ui.label.LifetimeLabel;

/**
 *
 * @author azc
 */
public class CoverLetterInfoView extends InfoView<CoverLetter> {

    public CoverLetterInfoView(Integer userId, String language, CoverLetter item) {
        super(userId, language, item);
        getTitle().addComponent(new LifetimeLabel(item.toString(), item.getLanguage()));
        getBody().addComponent(new LifetimeLabel(item.getIntroduction()));
        getBody().addComponent(new LifetimeLabel(item.getWhyMe()));
        getBody().addComponent(new LifetimeLabel(item.getWhyYou()));
        getBody().addComponent(new LifetimeLabel(item.getConclusion()));
    }

    @Override
    protected QAView getQAView() {
        return new CoverLetterQAView(getUserId(), getLanguage(), getItem());
    }

}
