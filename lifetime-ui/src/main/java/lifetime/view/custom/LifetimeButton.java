/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.view.custom;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import java.util.Objects;
import lifetime.util.Translator;

/**
 * Lifetime buttons are stylized extensions of vaadin buttons. This is
 * temporary, since all components infrastructure will be redesigned to allow
 * translations, development and other decorations.
 *
 * @author azc
 */
public abstract class LifetimeButton extends Button {

    /**
     * The currently interacting user.
     */
    private String username;
    /**
     * The interaction language.
     */
    private String language;

    /**
     * Creates a new lifetime button, with description and caption set with and
     * properly translated.
     *
     * @param username The currently interacting user
     * @param language The interaction language
     * @param caption Caption
     * @param icon The Button icon
     */
    public LifetimeButton(String username, String language, String caption, Resource icon) {
        super("", icon);
        this.username = username;
        this.language = language;
        setDescription(Translator.getTranslation(caption, language));
        setCaption(getDescription());
    }

    protected LifetimeButton(String caption, String language, Resource icon) {
        super("", icon);
        this.language = language;
        setDescription(caption);
        setCaption(getDescription());
    }

    public String getUsername() {
        return username;
    }

    public String getLanguage() {
        return language;
    }

    public void showCaption() {
        setCaption(getDescription());
    }

    public void hideCaption() {
        setCaption(null);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.username);
        hash = 97 * hash + Objects.hashCode(this.language);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof LifetimeButton)) {
            return false;
        }
        final LifetimeButton other = (LifetimeButton) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.language, other.language) && Objects.equals(this.getCaption(), other.getCaption());
    }

}
