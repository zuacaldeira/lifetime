/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.helper;

import old.ui.label.KeyLabel;
import old.ui.label.ValueLabel;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

/**
 *
 * @author azc
 */
public class PairView extends HorizontalLayout {
    private  KeyLabel keyComponent;
    private  Component valueComponent;

    public PairView(String key, String value, String language) {
        //setSizeFull();
        //setMargin(true);
        setSpacing(true); 
        keyComponent = new KeyLabel(key, language);
        valueComponent = new ValueLabel(value, language);
        addComponents(keyComponent, valueComponent);
        setComponentAlignment(keyComponent, Alignment.MIDDLE_RIGHT);
        setComponentAlignment(valueComponent, Alignment.MIDDLE_LEFT);
        setStyleName("pair");
    }
    
    public PairView(String key, Component value, String language) {
        //setSizeFull();
        //setMargin(true);
        setSpacing(true); 
        keyComponent = new KeyLabel(key, language);
        valueComponent = value;
        addComponents(keyComponent, valueComponent);
        setComponentAlignment(keyComponent, Alignment.MIDDLE_RIGHT);
        setComponentAlignment(valueComponent, Alignment.MIDDLE_LEFT);
        setStyleName("pair");
    }
    
}
