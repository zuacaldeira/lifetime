package lifetime.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import lifetime.view.welcome.WelcomeView;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import javax.servlet.annotation.WebServlet;
import lifetime.view.welcome.contact.ContactView;
import lifetime.view.welcome.register.RegisterView;
import lifetime.view.StyleClassName;

@Theme("mytheme")
public class WelcomeUI extends LifetimeUI {

    @Override
    protected void init(VaadinRequest request) {
        setStyleName(StyleClassName.LIFETIME_UI);
        setId(StyleClassName.LIFETIME_UI);
        setNavigator(new Navigator(this, this));
        getNavigator().addViewChangeListener(new ViewChangeListener() {

            @Override
            public boolean beforeViewChange(ViewChangeEvent event) {
                return true;
            }

            @Override
            public void afterViewChange(ViewChangeEvent event) {
                setLifetimeView((WelcomeView) event.getNewView());
            }
        });
        getNavigator().addView(Navigation.WELCOME_VIEW, new WelcomeView(getLanguage()));
        getNavigator().addView(Navigation.REGISTER_VIEW, new RegisterView(getLanguage()));
        getNavigator().addView(Navigation.CONTACT_VIEW, new ContactView(getLanguage()));
        getNavigator().navigateTo(Navigation.WELCOME_VIEW);
    }

    /**
     * Returns the current active view. By design contract this class must keep
     * a reference to a {@link WelcomeView}. The governing design pattern is the
     * <b>bridge design pattern</b>.
     *
     * @return
     */
    @Override
    public WelcomeView getLifetimeView() {
        return (WelcomeView) super.getLifetimeView();
    }

    /**
     * Servlet listening to requests at non secure part of the application.
     */
    @WebServlet(urlPatterns = "/*", name = "WelcomeUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = WelcomeUI.class, productionMode = false)
    public static class WelcomeUIServlet extends VaadinServlet {
    }
}
