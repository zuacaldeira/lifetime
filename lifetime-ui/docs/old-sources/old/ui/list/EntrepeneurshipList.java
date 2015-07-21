/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.list;

import old.ui.item.EntrepeneurshipItemView;
import old.ui.form.EntrepeneurshipFormNew;
import old.ui.item.ItemView;
import old.util.ServiceLocator;
import lifetime.business.persistence.Entrepeneurship;
import com.vaadin.ui.Button;
import java.util.List;

/**
 *
 * @author azc
 */
public class EntrepeneurshipList extends LifetimeList<Entrepeneurship> {

    public EntrepeneurshipList(Integer userId, String language) {
        super(userId, language);
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        super.buttonClick(event);
    }

    @Override
    protected ItemView getItemView(Entrepeneurship achievement) {
            return new EntrepeneurshipItemView(achievement);
    }

    @Override
    protected List<Entrepeneurship> getDataFromServer() {
        return ServiceLocator.findLifetimeService().getEntrepeneurship(getUserId(), getLanguage());
    }

    @Override
    protected EntrepeneurshipFormNew getFormNew() {
        Entrepeneurship p = new Entrepeneurship();
        p.setUserId(getUserId());
        p.setLanguage(getLanguage());
        return new EntrepeneurshipFormNew(p, this);
    }


}
