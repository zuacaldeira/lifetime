package old.ui.visitor;

import old.util.ServiceLocator;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import ui.LifetimeUI;

/**
 *
 */
@Theme("mytheme")
@Widgetset("lifetime.web.vaadin.MyAppWidgetset")
public class VisitorUI extends LifetimeUI /* implements Button.ClickListener */ /* implements Button.ClickListener */ {
    private Integer hostId;

    @Override
    protected void init(VaadinRequest request) {
        Integer guestId = ServiceLocator.findLifetimeService().getUserId(request.getUserPrincipal().getName());
         hostId = ServiceLocator.findLifetimeService().getHostId(guestId);
        setContent(new VisitorView(getLanguage(request), hostId));
    }

    @Override
    public VisitorView getContent() {
        return (VisitorView) super.getContent();
    }


    @WebServlet(urlPatterns = "/visitor/*", name = "VisitorUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = VisitorUI.class, productionMode = false)
    public static class VisitorUIServlet extends VaadinServlet {

    }

}
