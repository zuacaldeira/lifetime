/*
 * Copyright 2015 zua.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package lifetime.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import java.util.Objects;

/**
 * <p>
 * The Lifetime Abstract View. This class represents the structural template for
 * the top-level view presented to the user. This template is composed by two
 * components: {@code LifetimeMenu} and {@code LifetimeContent}.
 *
 * This class defines both the a user interface as well as a navigation pattern.
 * {@code LifetimeView}, defines a and implements the structural and
 * navigational requirements of the application specified by it's session type.
 * <p>
 * The session type of the {@code LifetimeView} is
 *
 * {@code
 *      LifetimeView = &{LifetimeMenu.action: LifetimeView...}
 *      LifetimeView = &{LifetimeContent.action: LifetimeView...} }
 *
 * <p>
 * We can read this session type as follow: <i>Lifetime View instances have a
 * menu of type {@link LifetimeMenu} with actions that allow a client to
 * interact with the system. As a result of this interaction the system may
 * navigate the user to another view, instance of LifetimeView, the user
 * presentable user interface. Alternatively, the actions can also be activated
 * from the current content view, a subclass of {@code LifetimeContent}</i>
 * <p>
 *
 * This class uses {@link LifetimeMenu} and {@link LifetimeContent}, also
 * abstract classes. This classes act as <b>adapters</b> of concrete menus and
 * view-specific content data.
 *
 * <i>Bridge Design Pattern</i> provide us with a clean solution for the problem
 * of instantiating the correct menus and content data for each subclass of
 * {@code LifetimeView}. The contract of this abstract class includes concrete
 * implementations for the following abstract methods:
 * {@link LifetimeView#createBackground()}, {@link LifetimeView#createMenu()}
 * and {@link LifetimeView#createContent()}.
 *
 *
 * @author Zua Caldeira - zuacaldeira@gmail.com
 *
 */
public abstract class LifetimeView extends AbsoluteLayout implements View {

    /**
     * The view-specific background image
     */
    private LifetimeBackground background;
    /**
     * The view-specific menu
     */
    private LifetimeMenu menu;
    /**
     * The view-specific content data
     */
    private LifetimeContent content;
    /**
     * The current user or system language
     */
    private final String language;
    /**
     * A composition base to group the menu and the content views the default UI
     * layer of this absolute layout
     */
    private final VerticalLayout base;

    /**
     * Initializes the structure of user interface. Delegates the choice of
     * individual adapters to subclasses.
     *
     * @param language The language the user is interacting with the system.
     */
    public LifetimeView(String language) {
        this.language = language;
        // Let subclasses initiate the adapters for the background, menu and content
        initBackground();
        initMenu();
        initContent();
        // Compose the view structure
        setSizeFull();
        base = new VerticalLayout(menu, content);
        base.setSizeFull();
        base.setExpandRatio(menu, .1f);
        base.setExpandRatio(content, .9f);
        addComponents(background, base);
        setStyleName(StyleClassName.LIFETIME_VIEW);
        setId(StyleClassName.LIFETIME_VIEW);
    }

    /**
     * Retrieves the current view background.
     *
     * @return The view background.
     */
    public LifetimeBackground getBackground() {
        return background;
    }

    /**
     * Retrieves the current view menu.
     *
     * @return The view menu
     */
    public LifetimeMenu getMenu() {
        return menu;
    }

    /**
     * Retrieves the current view content data
     *
     * @return the current content data
     */
    public LifetimeContent getContent() {
        return content;
    }

    /**
     * Returns the language currently used to interact with the user.
     *
     * @return the language, for instance, "en", "de", "pt"
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Delegates the creation of the menu adapter to subclasses
     */
    private void initBackground() {
        background = createBackground();
    }

    /**
     * Delegates the creation of the menu adapter to subclasses
     */
    private void initMenu() {
        menu = createMenu();
    }

    /**
     * Delegates the creation of the menu adapter to subclasses
     */
    private void initContent() {
        content = createContent();
    }

    /**
     * Creates a new menu compatible with the view concrete implementation.
     * Implementors must provide an implementation of the adapter class
     * LifetimeMenu. This imposes a requirement on concrete subclass to provide
     * an implementation of a {@link LifetimeMenu}.
     *
     * @return and instance of {@link LifetimeMenu}
     */
    protected abstract LifetimeMenu createMenu();

    /**
     * Creates a new content data view, compatible with the concrete
     * implementation. Implementors must provide an implementation of the
     * adapter class LifetimeContent. This imposes a requirement on concrete
     * subclasses to provide an implementation of a {@link LifetimeContent}.
     *
     * @return an instance of {@link LifetimeContent}.
     */
    protected abstract LifetimeContent createContent();

    /**
     * Creates a new background wrapper class, compatible with the concrete
     * implementation. Implementors must provide an implementation of the
     * adapter class LifetimeBackground. This imposes a requirement on concrete
     * subclasses to provide an implementation of a {@link LifetimeBackground}.
     *
     * @return an instance of {@link LifetimeBackground}.
     */
    protected abstract LifetimeBackground createBackground();

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("new view is " + event.getViewName());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.background);
        hash = 29 * hash + Objects.hashCode(this.menu);
        hash = 29 * hash + Objects.hashCode(this.content);
        hash = 29 * hash + Objects.hashCode(this.language);
        hash = 29 * hash + Objects.hashCode(this.base);
        return hash;
    }

    /**
     * Compares this view with another object for equality.
     *
     * @param obj The object we are comparing with
     * @return {@code true} if the current object and {@code obj}
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        final LifetimeView other = (LifetimeView) obj;
        return equalBase(other) && equalStructure(other) && Objects.equals(this.language, other.language);
    }

    private boolean equalBase(LifetimeView other) {
        return Objects.equals(this.background, other.background)
                && Objects.equals(this.base, other.base);
    }

    private boolean equalStructure(LifetimeView other) {
        return Objects.equals(this.menu, other.menu)
                && Objects.equals(this.content, other.content);
    }

}
