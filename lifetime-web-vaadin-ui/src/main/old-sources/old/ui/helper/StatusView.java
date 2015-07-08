/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.helper;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author azc
 */
public class StatusView extends VerticalLayout {
    private final Label status;

    public StatusView(String astatus) {
        setSizeFull();
        status = new Label(astatus);
    }
    
}
