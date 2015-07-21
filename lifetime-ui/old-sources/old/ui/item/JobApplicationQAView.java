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
import lifetime.business.persistence.JobApplication;
import old.ui.button.ApplyNowButton;
import old.ui.form.JobApplicationFormEdit;
import old.ui.window.LifetimeWindow;

/**
 *
 * @author lifetime
 */
public class JobApplicationQAView extends QAView<JobApplication> implements ClickListener {
    private ApplyNowButton applyButton;

    public JobApplicationQAView(Integer userId, String language, JobApplication jobApplication) {
        super(userId, language, jobApplication);
        /*applyButton = new ApplyNowButton(userId, language, jobApplication);
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
        JobApplicationFormEdit edit = new JobApplicationFormEdit(getItem(), getList());
        LifetimeWindow window = new LifetimeWindow(getUserId(), getLanguage(), "Edit Job Application");
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
