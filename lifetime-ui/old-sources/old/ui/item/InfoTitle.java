/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import old.ui.label.LifetimeLabel;
import com.vaadin.ui.HorizontalLayout;

/**
 *
 * @author azc
 */
public class InfoTitle extends HorizontalLayout {
    private LifetimeLabel titleLabel;

    public InfoTitle() {
        //setSizeFull();
        setSpacing(true);
        setStyleName("info-title");
    }

    public InfoTitle(LifetimeLabel titleLabel) {
        this();
        addComponent(titleLabel);
        this.titleLabel = titleLabel;
    }

    public LifetimeLabel getTitleLabel() {
        return titleLabel;
    }
    
    
}
