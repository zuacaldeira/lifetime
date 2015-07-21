package old.ui.user;

import old.util.ServiceLocator;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import lifetime.business.persistence.User;
import views.LifetimeBackground;
import ui.LifetimeUI;

/**
 *
 */
@Theme("mytheme")
@Widgetset("lifetime.web.vaadin.MyAppWidgetset")
public class UserUI extends LifetimeUI {

    private Integer userId;

    @WebServlet(urlPatterns = "/user/*", name = "UserUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = UserUI.class, productionMode = false)
    public static class UserUIServlet extends VaadinServlet {

    }

    @Override
    protected void init(VaadinRequest request) {
        //Notification.show("Service = " + ServiceLocator.findLifetimeService(), Notification.Type.HUMANIZED_MESSAGE);
        userId = ServiceLocator.findLifetimeService().getUserId(request.getUserPrincipal().getName());
        User u = ServiceLocator.findLifetimeService().getUser(userId);
        String uLanguage = u.getMotherLanguage();
        setContent(new UserView(uLanguage, userId));
    }

    public LifetimeBackground getBackground() {
        return getContent().getBackground();
    }

    @Override
    public UserView getContent() {
        return (UserView) super.getContent();
    }

}
