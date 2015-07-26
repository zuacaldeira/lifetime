/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.view.custom;

import com.vaadin.server.Resource;
import com.vaadin.ui.themes.Reindeer;

/**
 *
 * @author azc
 */
public class LifetimeButtonSmall extends LifetimeButton {

    public LifetimeButtonSmall(Integer userId, String language, String caption, Resource icon) {
        super(userId, language, caption, icon);
        setDescription(caption);
        setStyleName(Reindeer.BUTTON_SMALL);
    }

}
