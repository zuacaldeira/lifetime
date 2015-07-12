/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.list;

import old.ui.item.AcademicItemView;
import old.ui.form.AcademicFormNew;
import com.vaadin.event.LayoutEvents;
import old.ui.item.ItemView;
import old.util.ServiceLocator;
import com.vaadin.ui.Button;
import java.util.List;
import lifetime.business.persistence.Academic;

/**
 *
 * @author azc
 */
public class AcademicList extends LifetimeList<Academic> implements LayoutEvents.LayoutClickListener {

    public AcademicList(Integer userId, String language) {
        super(userId, language);
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        super.buttonClick(event);
    }

    @Override
    protected ItemView getItemView(Academic achievement) {
            return new AcademicItemView(achievement);
    }

    @Override
    protected List<Academic> getDataFromServer() {
        return ServiceLocator.findLifetimeService().getAcademics(getUserId(), getLanguage());
    }

    @Override
    protected AcademicFormNew getFormNew() {
        Academic a = new Academic();
        a.setLanguage(getLanguage());
        a.setUserId(getUserId());
        return new AcademicFormNew(a, this);
    }
}
