/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.helper;

import old.util.ServiceLocator;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author azc
 */
public class UserArea extends VerticalLayout {
    public UserArea(Integer userId, String language) {
        setSizeFull();
        Embedded e = new Embedded(getFullName(userId), getResource(userId));
        e.setSizeFull();
        addComponents(e);
    }   

    private String getFullName(Integer userId) {
        if(userId == null)
            return "lifetime";
        return ServiceLocator.findLifetimeService().getUser(userId).getFirstname();
    }

    private Resource getResource(Integer userId) {
        if(userId != null) {
            return new ThemeResource("../img/photo.jpg");
        }
        return new ThemeResource("../img/space3.jpg");
    }
}
