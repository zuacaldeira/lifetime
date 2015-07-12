/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.label;

import com.vaadin.ui.Label;

/**
 *
 * @author azc
 */
public class ValueLabel extends Label {

    public ValueLabel(String value, String language) {
        super(value);
        setStyleName("value");
    }
    
}
