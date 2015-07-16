/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import java.util.Objects;
import util.Translator;

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
        showCaption();
    }

    public LifetimeButton(String caption, Resource icon) {
        super("", icon);
        this.language = "en";
        setDescription(caption);
        showCaption();
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
        int hash = 7 + super.hashCode();
        hash = 31 * hash + Objects.hashCode(this.userId);
        hash = 31 * hash + Objects.hashCode(this.language);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        final LifetimeButton other = (LifetimeButton) obj;
        return Objects.equals(this.userId, other.userId)
                && Objects.equals(this.language, other.language);
    }

}
