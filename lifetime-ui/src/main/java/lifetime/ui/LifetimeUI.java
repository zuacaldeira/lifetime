package lifetime.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * Top level class of our application UI hierarchy.
 */
@Theme("mytheme")
//@Widgetset("LifetimeWidgetSet")
public abstract class LifetimeUI extends UI {

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
    public String getLanguage() {
        return "en";
    }
}
