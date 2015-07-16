package ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import java.util.Objects;
import views.LifetimeView;

/**
 * Top level class of our application UI hierarchy.
 */
@Theme("mytheme")
public abstract class LifetimeUI extends UI {

    /**
     * The single view for user interaction. Subclasses will bridge this class
     * providing a concrete implementation as required by they contract.
     */
    private LifetimeView lifetimeView;

    /**
     * LifetimeUser interaction view initialization procedure. Initiates the
     * view for user interaction, depending on the incoming request. Subclasses
     * must respect, at least, the <b>bridge design pattern</b> and the security
     * specification.
     *
     * @param request The current internal of an http request
     */
    @Override
    protected abstract void init(VaadinRequest request);

    /**
     * Extracts the language of the security principal from the incoming
     * request. This method extracts the principal information from the request,
     * asks the backend for the mother language of the user with the principal
     * username. If there is no principal, we return the system language.
     *
     * @return The current user language
     */
    protected String getLanguage() {
        return "en";
    }

    /**
     * Returns the current lifetime view.
     *
     * @return The lifetime view
     */
    public LifetimeView getLifetimeView() {
        return lifetimeView;
    }

    /**
     * Updates the current lifetime view.
     *
     * @param lifetimeView The new lifetime view
     */
    public void setLifetimeView(LifetimeView lifetimeView) {
        this.lifetimeView = lifetimeView;
    }

    /**
     * Calculates this Object hash code.
     *
     * @return the current instance hash code
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.lifetimeView);
        return hash;
    }

    /**
     * Compares this UI with another for equality.
     *
     * @param obj The other object we are comparing this object with
     * @return {@code true} if they both semantically equivalent
     */
    @Override
    public boolean equals(Object obj) {
        if (null == obj || getClass() != obj.getClass()) {
            return false;
        }
        final LifetimeUI other = (LifetimeUI) obj;
        return Objects.equals(this.lifetimeView, other.lifetimeView);
    }

}
