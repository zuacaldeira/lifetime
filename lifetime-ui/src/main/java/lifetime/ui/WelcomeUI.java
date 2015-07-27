package lifetime.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import javax.servlet.annotation.WebServlet;
import lifetime.view.StyleClassName;

@Theme("mytheme")
public class WelcomeUI extends LifetimeUI {

    @Override
    protected void init(VaadinRequest request) {
        setStyleName(StyleClassName.WELCOME_UI);
        setId(StyleClassName.WELCOME_UI);
        setNavigator(new Navigator(this, this));
        getNavigator().addProvider(LifetimeViewProvider.getWelcomeViewProvider(getLanguage()));
        getNavigator().navigateTo(Navigation.WELCOME_VIEW);
    }

    /**
     * Servlet listening to requests at non secure part of the application.
     */
    @WebServlet(urlPatterns = "/*", name = "WelcomeUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = WelcomeUI.class, productionMode = false)
    public static class WelcomeUIServlet extends VaadinServlet {
    }
}
