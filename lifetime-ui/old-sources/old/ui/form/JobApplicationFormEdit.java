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
package old.ui.form;

import com.vaadin.data.Property;
import com.vaadin.ui.Notification;
import old.util.ServiceLocator;
import lifetime.business.persistence.JobApplication;
import old.ui.combo.EmailTextComboBox;
import old.ui.list.LifetimeList;

/**
 *
 * @author lifetime
 */
public class JobApplicationFormEdit extends LifetimeForm<JobApplication> {

    private EmailTextComboBox emailCombo;

    public JobApplicationFormEdit(JobApplication achievement, LifetimeList<JobApplication> list) {
        super(achievement.getUserId(), achievement.getLanguage(), achievement, list);
        addLanguage(achievement.getLanguage());
        addJobApplication();
        addEmailText(achievement.getEmailText());
    }

    @Override
    public void fillItem() {
        JobApplication t = getItem();
        t.setEmailText(getEmailText().getValue());
        if(getLanguageComboBox().getValue() != null) {
            t.setLanguage(getLanguageComboBox().getValue());
        }
        
    }

    @Override
    protected void commitItem() {
        ServiceLocator.findLifetimeService().update(getItem());
        Notification.show("Updated item " + getItem());
    }

    private void addJobApplication() {
        emailCombo = new EmailTextComboBox(getUserId(), getLanguage());
        emailCombo.setRequired(false);
        emailCombo.setNewItemsAllowed(true);
        emailCombo.setImmediate(true);
        emailCombo.setNullSelectionAllowed(false);
        emailCombo.setValue(getItem());
        emailCombo.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                if (emailCombo.getValue() != null) {
                    getEmailText().setValue(emailCombo.getValue().getEmailText());
                }
            }
        });
        getMain().addComponent(emailCombo);
    }

    public EmailTextComboBox getEmailCombo() {
        return emailCombo;
    }

}
