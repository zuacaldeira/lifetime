package ui;

import views.WelcomeView;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import views.ContactView;
import views.RegisterView;

/**
 *
 */
@Theme("mytheme")
@Widgetset("lifetime.web.vaadin.MyAppWidgetset")
public class WelcomeUI extends LifetimeUI /* implements Button.ClickListener */ /* implements Button.ClickListener */ {

    @Override
    protected void init(VaadinRequest request) {
        new Navigator(this, this);
        getNavigator().addView("Welcome",new WelcomeView(getLanguage(request)));
        getNavigator().addView("Register",new RegisterView(getLanguage(request)));
        getNavigator().addView("Contact",new ContactView(getLanguage(request)));
        getNavigator().navigateTo("Welcome");
    }


    @WebServlet(urlPatterns = "/*", name = "WelcomesUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = WelcomeUI.class, productionMode = false)
    public static class WelcomeUIServlet extends VaadinServlet {

    }
}
