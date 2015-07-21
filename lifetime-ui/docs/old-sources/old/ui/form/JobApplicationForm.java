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
import java.util.Date;
import old.util.ServiceLocator;
import lifetime.business.persistence.JobApplication;
import old.ui.combo.EmailTextComboBox;
import old.ui.list.LifetimeList;

/**
 *
 * @author lifetime
 */
public class JobApplicationForm extends LifetimeForm<JobApplication> {
    private EmailTextComboBox emailCombo;

    public JobApplicationForm(JobApplication achievement, LifetimeList<JobApplication> list) {
        super(achievement.getUserId(), achievement.getLanguage(), achievement, list);
        addLanguage(achievement.getLanguage());
        addJobApplication(achievement);
        addEmailText(achievement.getEmailText());
    }

    @Override
    public void fillItem() {
        JobApplication t = getItem();
        t.setEmailText(getEmailText().getValue());
        t.setLanguage(getLanguageComboBox().getValue());
        t.setCreatedAt(new Date());
    }

    @Override
    protected void commitItem() {
        ServiceLocator.findLifetimeService().add(getItem());
        Notification.show("Updated item " + getItem());
    }

    private void addJobApplication(JobApplication achievement) {
        emailCombo = new EmailTextComboBox(getUserId(), getLanguage());
        emailCombo.setRequired(false);
        emailCombo.setNewItemsAllowed(false);
        emailCombo.setImmediate(true);
        emailCombo.setNullSelectionAllowed(false);
        emailCombo.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                if (emailCombo.getValue() != null) {
                    if(getEmailText() != null) {
                        getEmailText().setValue(emailCombo.getValue().getEmailText());
                    }
                }
            }
        });
    }

    public EmailTextComboBox getEmailCombo() {
        return emailCombo;
    }

}
