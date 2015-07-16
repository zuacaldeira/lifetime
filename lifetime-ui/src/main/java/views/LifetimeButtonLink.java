/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.vaadin.server.Resource;
import com.vaadin.ui.themes.Reindeer;

/**
 *
 * @author azc
 */
public class LifetimeButtonLink extends LifetimeButton {

    public LifetimeButtonLink(Integer userId, String language, String caption, Resource icon) {
        super(userId, language, caption, icon);
        setDescription(caption);
        setData(language);
        setStyleName(Reindeer.BUTTON_LINK);
    }

    public LifetimeButtonLink(String caption, String language, Resource icon) {
        super(caption, language, icon);
        setDescription(caption);
        setStyleName(Reindeer.BUTTON_LINK);
    }


}
