/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.view.custom;

import com.vaadin.ui.ComboBox;
import com.vaadin.data.Container;
import java.util.Collection;
import lifetime.util.Translator;

/**
 *
 * @author azc
 */
public abstract class LifetimeComboBox extends ComboBox {
    private final String language;

    protected LifetimeComboBox(String caption, String language, Collection options) {
        super(Translator.getTranslation(caption, language), options);
        this.language = language;
        setWidth("400px");
        setImmediate(true);
        setInvalidAllowed(false);
        setComponentError(null);
    }

    protected LifetimeComboBox(String caption, String language, Container source) {
        super(Translator.getTranslation(caption, language), source);
        this.language = language;
        setWidth("400px");
        setImmediate(true);
        setInvalidAllowed(false);
        setComponentError(null);
    }

    protected LifetimeComboBox(String caption, String language, String value) {
        super(Translator.getTranslation(caption, language));
        this.language = language;
        setValue(value);
        setImmediate(true);
        setInvalidAllowed(false);
        setComponentError(null);
    }

    public String getLanguage() {
        return language;
    }
    
    

}
