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

import com.vaadin.server.FontAwesome;
import lifetime.util.StyleClassName;
import lifetime.view.custom.LifetimeButtonLink;

/**
 * A CRUD lifetime menu. A CRUD menu adds menu action to create, read, update
 * and delete entities from the underlying database. it extends
 * {@link LifetimeMenu} in adherence with design requirements of the
 * application.
 *
 * @author zua
 */
public abstract class CrudMenu extends LifetimeMenu {

    /**
     * Create.
     */
    private LifetimeButtonLink addButton;
    /**
     * Read.
     */
    private LifetimeButtonLink readButton;
    /**
     * Update.
     */
    private LifetimeButtonLink updateButton;
    /**
     * Delete.
     */
    private LifetimeButtonLink deleteButton;

    /**
     * The interacting user.
     */
    private final String username;

    /**
     * Creates a new instance of a crud menu.
     *
     * @param username The user interacting with the system
     * @param language The interaction language
     */
    public CrudMenu(String username, String language) {
        super(language);
        this.username = username;
    }

    /**
     * Add crud specific control buttons, one for each crud action.
     */
    @Override
    protected void addControls() {
        addButton = new LifetimeButtonLink(username, getLanguage(), "Create", FontAwesome.PLUS);
        addButton.setId(StyleClassName.C_BUTTON.getId());

        readButton = new LifetimeButtonLink(username, getLanguage(), "Read", FontAwesome.EYE);
        readButton.setId(StyleClassName.R_BUTTON.getId());

        updateButton = new LifetimeButtonLink(username, getLanguage(), "Update", FontAwesome.EDIT);
        updateButton.setId(StyleClassName.U_BUTTON.getId());

        deleteButton = new LifetimeButtonLink(username, getLanguage(), "Delete", FontAwesome.TRASH_O);
        deleteButton.setId(StyleClassName.D_BUTTON.getId());

        addControl(addButton);
        addControl(readButton);
        addControl(updateButton);
        addControl(deleteButton);
    }

    public LifetimeButtonLink getAddButton() {
        return addButton;
    }

    public LifetimeButtonLink getReadButton() {
        return readButton;
    }

    public LifetimeButtonLink getUpdateButton() {
        return updateButton;
    }

    public LifetimeButtonLink getDeleteButton() {
        return deleteButton;
    }

    public String getUsername() {
        return username;
    }

}
