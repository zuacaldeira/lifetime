/*
 * To change this license header, choose License Headers in Sport Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.list;

import old.ui.item.OtherItemView;
import old.ui.form.OtherFormNew;
import lifetime.business.persistence.Other;
import old.ui.item.ItemView;
import old.util.ServiceLocator;
import java.util.Date;
import java.util.List;

/**
 *
 * @author azc
 */
public class OtherList extends LifetimeList<Other> {

    public OtherList(Integer userId, String language) {
        super(userId, language);
    }

    @Override
    protected ItemView getItemView(Other achievement) {
        return new OtherItemView(achievement);
    }

    @Override
    protected List<Other> getDataFromServer() {
        return ServiceLocator.findLifetimeService().getOthers(getUserId(), getLanguage());
    }

    @Override
    protected OtherFormNew getFormNew() {
        Other s = new Other();
        s.setUserId(getUserId());
        s.setLanguage(getLanguage());
        s.setCreatedAt(new Date());
        return new OtherFormNew(s, this);
    }

}
