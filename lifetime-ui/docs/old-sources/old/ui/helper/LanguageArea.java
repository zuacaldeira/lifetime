/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.helper;

import old.util.ServiceLocator;
import old.util.LifetimeUtils;
import old.ui.button.LifetimeButtonLink;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.util.Set;
import ui.LifetimeUI;

/**
 *
 * @author azc
 */
public class LanguageArea extends VerticalLayout implements Button.ClickListener {

    private Button selected;
    
    public LanguageArea(Integer userId, String language) {
        setStyleName("menu-language");
        Set<String> languages = ServiceLocator.findLifetimeService().getUserLanguages(userId);
        languages.add(ServiceLocator.findLifetimeService().getMotherLanguage(userId));
        for (String lang : languages) {
            if (lang.length() > 0) {
                Button e = new LifetimeButtonLink(lang, LifetimeUtils.getFlag(lang));
                e.setData(lang);
                e.setSizeUndefined();
                e.addClickListener(this);
                addComponent(e);
                if(language.equalsIgnoreCase(lang)) {
                    selected = e;
                    selected.setStyleName("button-selected");
                }
            }
        }
    }


    @Override
    public void buttonClick(Button.ClickEvent event) {
        String language = (String)event.getButton().getData();
        Notification.show("Translated to " + language);
        //((LifetimeUI)UI.getCurrent()).translateTo(language);
//        Button current = event.getButton();
//        if(current != selected) {
//            selected.setStyleName("menu");
//            current.setStyleName("menu-item-select");
//        }
    }

}
