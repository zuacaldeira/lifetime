/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.view.custom;

import com.vaadin.ui.ComboBox;
import com.vaadin.data.Container;
import java.util.Objects;
import lifetime.util.Translator;

/**
 *
 * @author azc
 */
public abstract class LifetimeComboBox extends ComboBox {

    private final String language;

    protected LifetimeComboBox(String caption, String language, Container source) {
        super(Translator.getTranslation(caption, language), source);
        this.language = language;
        setWidth("400px");
        setImmediate(true);
        setInvalidAllowed(false);
        setComponentError(null);
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof LifetimeComboBox)) {
            return false;
        }
        final LifetimeComboBox other = (LifetimeComboBox) obj;
        return Objects.equals(this.language, other.language);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.language);
        return hash;
    }

}
