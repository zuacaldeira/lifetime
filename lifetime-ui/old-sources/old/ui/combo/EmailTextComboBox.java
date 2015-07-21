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
package old.ui.combo;

import lifetime.business.persistence.JobApplication;
import old.ui.data.JobApplicationsDataContainer;

/**
 *
 * @author lifetime
 */
public class EmailTextComboBox extends LifetimeComboBox {

    public EmailTextComboBox(final Integer userId, final String language) {
        super("Job Application", language, new JobApplicationsDataContainer(userId, language));
    }

    @Override
    public JobApplication getValue() {
        return (JobApplication) super.getValue(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
