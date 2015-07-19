package lifetime.ui;

import com.vaadin.annotations.Theme;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import lifetime.view.RegisterView;
import lifetime.view.StyleClassName;

@Theme("mytheme")
public class RegisterUI extends LifetimeUI  {

    @Override
    protected void init(VaadinRequest request) {
        setContent(new RegisterView(getLanguage()));
        setStyleName(StyleClassName.LIFETIME_UI);
        setId(StyleClassName.LIFETIME_UI);
    }


    @WebServlet(urlPatterns = "/register/*", name = "RegisterUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = RegisterUI.class, productionMode = false)
    public static class RegisterUIServlet extends VaadinServlet {

    }
}
