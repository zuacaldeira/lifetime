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
package old.ui.wizard;

import org.vaadin.teemu.wizards.WizardStep;

/**
 *
 * @author lifetime
 */
abstract class LifetimeWizardStep implements WizardStep {

    private final Integer userId;
    private final String language;

    public LifetimeWizardStep(Integer userId, String language) {
        this.userId = userId;
        this.language = language;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getLanguage() {
        return language;
    }
    
    
    

}
