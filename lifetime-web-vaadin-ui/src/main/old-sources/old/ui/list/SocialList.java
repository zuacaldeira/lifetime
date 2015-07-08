/*
 * To change this license header, choose License Headers in Social Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.list;

import old.ui.item.SocialItemView;
import old.ui.form.SocialFormNew;
import old.ui.item.ItemView;
import old.util.ServiceLocator;
import java.util.List;
import lifetime.business.persistence.Social;

/**
 *
 * @author azc
 */
public class SocialList extends LifetimeList<Social> {

    public SocialList(Integer userId, String language) {
        super(userId, language);
    }

    @Override
    protected ItemView getItemView(Social achievement) {
        return new SocialItemView(achievement);
    }

    @Override
    protected List<Social> getDataFromServer() {
        return ServiceLocator.findLifetimeService().getSocials(getUserId(), getLanguage());
    }

    @Override
    protected SocialFormNew getFormNew() {
        Social s = new Social();
        s.setUserId(getUserId());
        s.setLanguage(getLanguage());
        return new SocialFormNew(s, this);
    }

}
