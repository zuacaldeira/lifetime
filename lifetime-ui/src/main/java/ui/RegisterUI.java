package ui;

import com.vaadin.annotations.Theme;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import views.RegisterView;

@Theme("mytheme")
public class RegisterUI extends LifetimeUI /* implements Button.ClickListener */ /* implements Button.ClickListener */ {

    @Override
    protected void init(VaadinRequest request) {
        setContent(new RegisterView(getLanguage(request)));
    }


    @WebServlet(urlPatterns = "/register/*", name = "RegisterUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = RegisterUI.class, productionMode = false)
    public static class RegisterUIServlet extends VaadinServlet {

    }
}
