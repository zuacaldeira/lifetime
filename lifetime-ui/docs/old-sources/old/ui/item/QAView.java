/*
 * Copyright 2015 lifetime.
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
package old.ui.item;

import old.util.LifetimeUtils;
import old.ui.window.LifetimeWindow;
import old.ui.button.LifetimeButtonLink;
import old.ui.form.ConfirmForm;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HasComponents;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import java.util.Set;
import lifetime.business.persistence.Achievement;
import old.ui.button.AddCertificateButton;
import old.ui.button.AddToolButton;
import old.ui.list.LifetimeList;

/**
 *
 * @author lifetime
 */
public abstract class QAView<T> extends HorizontalLayout implements ClickListener {

    private final T item;
    private LifetimeButtonLink editButton;
    private LifetimeButtonLink hideButton;
    private LifetimeButtonLink deleteButton;
    private AddCertificateButton addCertificateButton;
    private final Integer userId;
    private final String language;
    private AddToolButton<T> addToolButton;

    public QAView(Integer userId, String language, T item) {
        this.userId = userId;
        this.language = language;
        this.item = item;
        showMissingTranslationsIfAny();
        showMissingDocumentsIfAny();
        showEdit();
        if(item instanceof  Achievement) {
            showHide();
        }
        showDelete();
        showAddTool();
        setStyleName("qa");
    }

    private void showAddTool() {
        addToolButton = new AddToolButton<T>(getUserId(), getLanguage(), getItem());
        addComponent(addToolButton);
    }

    private void showEdit() {
        editButton = new LifetimeButtonLink("Edit", FontAwesome.PENCIL);
        editButton.addClickListener(this);
        addComponent(editButton);
    }

    private void showHide() {
        hideButton = new LifetimeButtonLink("Hide", FontAwesome.EYE_SLASH);
        hideButton.addClickListener(this);
        addComponent(hideButton);
    }

    private void showDelete() {
        deleteButton = new LifetimeButtonLink("Delete", FontAwesome.TRASH_O);
        deleteButton.addClickListener(this);
        addComponent(deleteButton);
    }

    private void showMissingTranslationsIfAny() {
        if (item instanceof Achievement) {
            Achievement a = (Achievement) item;
            Set<String> langs = getNotTranslatedLanguages();
            for (String lang : langs) {
                if (!lang.equals(a.getLanguage())) {
                    Button b = new LifetimeButtonLink(lang, LifetimeUtils.getFlag(lang));
                    b.addClickListener(this);
                    addComponent(b);
                }
            }
        }
    }

    protected abstract Set<String> getNotTranslatedLanguages();

    public T getItem() {
        return item;
    }

    public LifetimeButtonLink getEditButton() {
        return editButton;
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        if (event.getButton().equals(editButton)) {
            showEditForm();
        } else if (event.getButton().equals(deleteButton)) {
            showDeleteConfirm();
        } else if (event.getButton().getData() != null) {
            showTranslateTo((String) event.getButton().getData());
        } 

    }

    protected abstract void showEditForm();

    protected abstract void showTranslateTo(String language);

    protected void showDeleteConfirm() {
        ConfirmForm form = new ConfirmForm<T>(item, getList());
        final Window window = new LifetimeWindow(userId, language, "Confirm Delete?");
        window.setContent(form);

        form.getCancel().addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                window.close();
            }
        });

        form.getDelete().addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                deleteDataFormServer();
                getList().update();
                window.close();
            }
        });

        window.setSizeUndefined();
        getUI().addWindow(window);
    }

    protected abstract void deleteDataFormServer();

    public LifetimeList<T> getList() {
        HasComponents hc = getParent();
        while (hc != null && !(hc instanceof UI)) {
            if (hc instanceof LifetimeList) {
                return (LifetimeList<T>) hc;
            }
            hc = hc.getParent();
        }
        return null;
    }

    private void showMissingDocumentsIfAny() {
        if (item != null && (item instanceof Achievement)) {
            addCertificateButton = new AddCertificateButton(userId, language, (Achievement) item);
            addComponent(addCertificateButton);
        }
    }

    public T getAchievement() {
        return item;
    }

    public LifetimeButtonLink getDeleteButton() {
        return deleteButton;
    }

    public AddCertificateButton getAddCertificateButton() {
        return addCertificateButton;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getLanguage() {
        return language;
    }

    public LifetimeButtonLink getHideButton() {
        return hideButton;
    }

    public void setHideButton(LifetimeButtonLink hideButton) {
        this.hideButton = hideButton;
    }
    
    

    
}
