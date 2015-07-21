/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.list;

import old.ui.item.ProfessionalItemView;
import old.ui.form.ProfessionalFormNew;
import old.ui.item.ItemView;
import old.util.ServiceLocator;
import java.util.List;
import lifetime.business.persistence.Professional;

/**
 *
 * @author azc
 */
public class ProfessionalList extends LifetimeList<Professional> {

    public ProfessionalList(Integer userId, String language) {
        super(userId, language);
    }

    @Override
    protected ItemView getItemView(Professional achievement) {
        return new ProfessionalItemView(achievement);
    }

    @Override
    protected List<Professional> getDataFromServer() {
        return ServiceLocator.findLifetimeService().getProfessionals(getUserId(), getLanguage());
    }

    @Override
    protected ProfessionalFormNew getFormNew() {
        Professional p = new Professional();
        p.setUserId(getUserId());
        p.setLanguage(getLanguage());
        return new ProfessionalFormNew(p, this);
    }

}
