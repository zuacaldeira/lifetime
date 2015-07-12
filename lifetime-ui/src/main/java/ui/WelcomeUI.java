package ui;

import views.WelcomeView;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import views.ContactView;
import views.RegisterView;

/**
 *
@Theme("mytheme")
@Widgetset("lifetime.MyAppWidgetset")
 */
public class WelcomeUI extends LifetimeUI implements ViewChangeListener /* implements Button.ClickListener */ {

    @Override
    protected void init(VaadinRequest request) {
        new Navigator(this, this);
        getNavigator().addView("Welcome", new WelcomeView(getLanguage(request)));
        getNavigator().addView("Register", new RegisterView(getLanguage(request)));
        getNavigator().addView("Contact", new ContactView(getLanguage(request)));
        getNavigator().navigateTo("Welcome");
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
     * @todo Javadoc
     * @param event
     * @return
     */
    @Override
    public boolean beforeViewChange(ViewChangeEvent event) {
        return true;
    }

    /**
     * @todo Javadoc
     */
    @Override
    public void afterViewChange(ViewChangeEvent event) {
        setLifetimeView((WelcomeView) event.getNewView());
    }

    @WebServlet(urlPatterns = "/*", name = "WelcomesUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = WelcomeUI.class, productionMode = false)
    public static class WelcomeUIServlet extends VaadinServlet {

    }
}
