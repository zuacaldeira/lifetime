/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.label;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import old.util.Translator;

/**
 *
 * @author azc
 */
public class LifetimeLabel extends Label {

    public LifetimeLabel(String caption) {
        super(caption);
    }
    public LifetimeLabel(String caption, ContentMode contentMode) {
        super(caption, contentMode);
    }
    public LifetimeLabel(String caption, String language) {
        super(Translator.getTranslation(caption, language));
    }

    public LifetimeLabel(String caption, String language, ContentMode contentMode) {
        super(Translator.getTranslation(caption, language), contentMode);
    }
}
