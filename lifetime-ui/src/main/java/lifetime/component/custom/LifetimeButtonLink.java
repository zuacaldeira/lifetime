/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.component.custom;

import com.vaadin.server.Resource;
import com.vaadin.ui.themes.Reindeer;

/**
 * Lifetime's link button, with specific customization to be used throughout our
 * application.
 *
 * @author azc
 */
public class LifetimeButtonLink extends LifetimeButton {

    public LifetimeButtonLink(String username, String language, String caption, Resource icon) {
        super(username, language, caption, icon);
        setDescription(caption);
        setData(language);
        setStyleName(Reindeer.BUTTON_LINK);
        setHeight("1cm");
    }

    public LifetimeButtonLink(String caption, String language, Resource icon) {
        this(null, language, caption, icon);
    }

}
