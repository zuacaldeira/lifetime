package lifetime.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import javax.servlet.annotation.WebServlet;
import lifetime.util.StyleClassName;

@Theme("mytheme")
@Title("Me@Lifetime")
public class UserUI extends LifetimeUI {

    @Override
    protected void init(VaadinRequest request) {
        setStyleName(StyleClassName.USER_UI);
        setId(StyleClassName.USER_UI);
        setNavigator(new Navigator(this, this));
        getNavigator().addProvider(LifetimeViewProvider.getUserViewProvider(getLanguage()));
        getNavigator().navigateTo(Navigation.USER_VIEW.getName());
    }

    /**
     * Servlet listening to requests at non secure part of the application.
     */
    @WebServlet(urlPatterns = {"/user/*"}, name = "UserUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = UserUI.class, productionMode = false)
    public static class UserUIServlet extends VaadinServlet {
    }
}
