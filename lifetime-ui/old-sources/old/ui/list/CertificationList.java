/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.list;

import old.ui.item.CertificationItemView;
import old.ui.form.CertificationFormNew;
import com.vaadin.event.LayoutEvents;
import old.ui.item.ItemView;
import old.util.ServiceLocator;
import java.util.List;
import lifetime.business.persistence.Certification;

/**
 *
 * @author azc
 */
public class CertificationList extends LifetimeList<Certification> implements LayoutEvents.LayoutClickListener {

    public CertificationList(Integer userId, String language) {
        super(userId, language);
    }

    @Override
    protected ItemView getItemView(Certification achievement) {
        return new CertificationItemView(achievement);
    }

    @Override
    protected List<Certification> getDataFromServer() {
        return ServiceLocator.findLifetimeService().getCertifications(getUserId(), getLanguage());
    }

    @Override
    protected CertificationFormNew getFormNew() {
        Certification c = new Certification();
        c.setLanguage(getLanguage());
        c.setUserId(getUserId());
        return new CertificationFormNew(c, this);
    }
}
