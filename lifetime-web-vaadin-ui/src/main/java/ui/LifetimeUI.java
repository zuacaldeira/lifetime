package ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import java.security.Principal;
import lifetime.business.persistence.User;
import util.ServiceLocator;

/**
 *
 */
@Theme("mytheme")
@Widgetset("lifetime.MyAppWidgetset")
public abstract class LifetimeUI extends UI  {

    @Override
    protected abstract void init(VaadinRequest request);

    protected String getLanguage(VaadinRequest request) {
        Principal p = request.getUserPrincipal();
        if (p != null) {
            String name = p.getName();
            Integer userId = ServiceLocator.findLifetimeService().getUserId(name);
            User u = ServiceLocator.findLifetimeService().getUser(userId);
            return u.getMotherLanguage();
        } else {
            return "en";
        }
    }

}
