package ui;

import com.vaadin.annotations.Theme;
import views.WelcomeView;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import views.ContactView;
import views.RegisterView;

@Theme("mytheme")
//@Widgetset("ui.lifetimeWidgetSet")
public class WelcomeUI extends LifetimeUI implements ViewChangeListener  {

    @Override
    protected void init(VaadinRequest request) {
        setNavigator(new Navigator(this, this));
        getNavigator().addView(Navigation.WELCOME_VIEW, new WelcomeView(getLanguage()));
        getNavigator().addView(Navigation.REGISTER_VIEW, new RegisterView(getLanguage()));
        getNavigator().addView(Navigation.CONTACT_VIEW, new ContactView(getLanguage()));
        getNavigator().navigateTo(Navigation.WELCOME_VIEW);
        getNavigator().addViewChangeListener(this);
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
     * Defines the set of actions that must be performed before the navigator
     * changes the view for this UI.
     *
     * @param event The event being fired
     * @return <b>true</b> iff the view must change.
     */
    @Override
    public boolean beforeViewChange(ViewChangeEvent event) {
        return true;
    }

    /**
     * Defines actions that must be performed immediately after a view change.
     *
     * @param event The event being fired
     */
    @Override
    public void afterViewChange(ViewChangeEvent event) {
        setLifetimeView((WelcomeView) event.getNewView());
    }

    /**
     * Servlet listening to requests at non secure part of the application.
     */
    @WebServlet(urlPatterns = "/*", name = "WelcomesUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = WelcomeUI.class, productionMode = false)
    public static class WelcomeUIServlet extends VaadinServlet {

    }
}
