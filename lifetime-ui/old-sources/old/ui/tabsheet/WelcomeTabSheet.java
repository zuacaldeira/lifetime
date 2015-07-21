/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.tabsheet;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author azc
 */
public class WelcomeTabSheet extends TabSheet {

    public WelcomeTabSheet(Integer userId, String language) {
        setSizeFull();
        addTab(new HorizontalLayout(), "Users");
        addTab(new HorizontalLayout(), "Partners");
        addTab(new HorizontalLayout(), "Contact");
        setStyleName(ValoTheme.TABSHEET_CENTERED_TABS);
    }

}
