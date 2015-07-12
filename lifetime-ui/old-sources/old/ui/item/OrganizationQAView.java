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

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import java.util.HashSet;
import old.util.ServiceLocator;
import java.util.Set;
import lifetime.business.persistence.Organization;
import old.ui.button.ApplyNowButton;
import old.ui.form.OrganizationFormEdit;
import old.ui.window.LifetimeWindow;

/**
 *
 * @author lifetime
 */
public class OrganizationQAView extends QAView<Organization> implements ClickListener {
    private ApplyNowButton applyButton;

    public OrganizationQAView(Integer userId, String language, Organization organization) {
        super(userId, language, organization);
        /*applyButton = new ApplyNowButton(userId, language, organization);
        applyButton.addClickListener(this);
        addComponent(applyButton);*/
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        if(event.getButton() == applyButton) {
            Notification.show("Starting job application", Type.HUMANIZED_MESSAGE);
        }
        else {
            super.buttonClick(event);
        }
    }
    
    

    @Override
    protected Set<String> getNotTranslatedLanguages() {
        return new HashSet();//ServiceLocator.findLifetimeService().getNotTranslatedLanguages(getLanguage(), getItem());
    }

    @Override
    protected void showEditForm() {
        OrganizationFormEdit edit = new OrganizationFormEdit(getItem(), getList());
        LifetimeWindow window = new LifetimeWindow(getUserId(), getLanguage(), "Edit Organization");
        window.setContent(edit);
        getUI().addWindow(window);                
    }

    @Override
    protected void showTranslateTo(String language) {
    }

    @Override
    protected void deleteDataFormServer() {
        ServiceLocator.findLifetimeService().delete(getItem());
    }

}
