package ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import java.security.Principal;
import lifetime.persistence.LifetimeUser;
import util.ServiceLocator;
import views.LifetimeView;

/**
 *
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
     * @param request The incoming request with user information
     * @return The current user language
     *
     * @todo The system language should be a persistent value and hard-coded
     */
    protected String getLanguage(VaadinRequest request) {
        Principal p = request.getUserPrincipal();
        if (p == null) {
            //TODO
            return "en";
        }

        try {
            String name = p.getName();
            LifetimeUser u = ServiceLocator.findLifetimeAccountService().getUser(name);
            return u.getMotherLanguage();
        } catch (Exception ex) {
            return "en";
        }
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

}
