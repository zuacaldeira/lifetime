package old.ui.admin;

import com.vaadin.annotations.PreserveOnRefresh;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import old.ui.user.UserUI;

/**
 *
 */
@Theme("mytheme")
@Widgetset("lifetime.web.vaadin.MyAppWidgetset")
@PreserveOnRefresh
public class AdminUI extends UserUI /* implements Button.ClickListener */ {



    @Override
    protected void init(VaadinRequest request) {
        super.init(request);
    }


    @WebServlet(urlPatterns = "/admin/*", name = "AdminUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = AdminUI.class, productionMode = false)
    public static class AdminUIServlet extends VaadinServlet {

    }
}
