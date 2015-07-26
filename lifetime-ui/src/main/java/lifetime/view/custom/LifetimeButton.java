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
 *
 * @author azc
 */
public abstract class LifetimeButton extends Button {

    private Integer userId;
    private String language;

    public LifetimeButton(Integer userId, String language, String caption, Resource icon) {
        super("", icon);
        this.userId = userId;
        this.language = language;
        setDescription(Translator.getTranslation(caption, language));
        setCaption(getDescription());
    }

    public LifetimeButton(String caption, String language, Resource icon) {
        super("", icon);
        this.language = language;
        setDescription(caption);
        setCaption(getDescription());
    }

    public Integer getUserId() {
        return userId;
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
        hash = 97 * hash + Objects.hashCode(this.userId);
        hash = 97 * hash + Objects.hashCode(this.language);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof LifetimeButton)) {
            return false;
        }
        final LifetimeButton other = (LifetimeButton) obj;
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return Objects.equals(this.language, other.language) && Objects.equals(this.getCaption(), other.getCaption());
    }

}
