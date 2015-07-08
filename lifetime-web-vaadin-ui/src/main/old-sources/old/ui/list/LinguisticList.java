/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.list;

import old.ui.item.LinguisticItemView;
import old.ui.form.LinguisticFormNew;
import old.ui.item.ItemView;
import old.util.ServiceLocator;
import com.vaadin.ui.Button;
import java.util.List;
import lifetime.business.persistence.Linguistic;

/**
 *
 * @author azc
 */
public class LinguisticList extends LifetimeList<Linguistic> {

    public LinguisticList(Integer userId, String language) {
        super(userId, language);
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        super.buttonClick(event);
    }

    @Override
    protected ItemView getItemView(Linguistic achievement) {
        return new LinguisticItemView(achievement);
    }

    @Override
    protected List<Linguistic> getDataFromServer() {
        return ServiceLocator.findLifetimeService().getLinguistics(getUserId(), getLanguage());
    }

    @Override
    protected LinguisticFormNew getFormNew() {
        Linguistic l = new Linguistic();
        l.setUserId(getUserId());
        l.setLanguage(getLanguage());
        return new LinguisticFormNew(l, this);
    }

}
