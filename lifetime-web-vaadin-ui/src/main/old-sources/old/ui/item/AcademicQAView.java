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
import old.ui.form.AcademicFormTranslate;
import old.ui.form.AcademicFormEdit;
import old.util.ServiceLocator;
import old.ui.window.EditAchievementWindow;
import old.ui.window.TranslateAchievementWindow;
import com.vaadin.ui.Window;
import java.util.Set;
import lifetime.business.persistence.Academic;

/**
 *
 * @author lifetime
 */
public class AcademicQAView extends QAView<Academic> {

    public AcademicQAView(Academic academic) {
        super(academic.getUserId(), academic.getLanguage(), academic);
        
    }

    @Override
    protected Set<String> getNotTranslatedLanguages() {
        return ServiceLocator.findLifetimeService().getNotTranslatedLanguages(getItem().getUserId(), getItem());
    }

    @Override
    protected void showEditForm() {
        AcademicFormEdit afe = new AcademicFormEdit(getItem(), getList());
        Window editWindow = new EditAchievementWindow(getItem().getUserId(), getItem().getLanguage(), afe);
        getUI().addWindow(editWindow);
    }

    @Override
    protected void showTranslateTo(String language) {
        AcademicFormTranslate aftt = new AcademicFormTranslate(getItem(), language, getList());
        Window translationWindow = new TranslateAchievementWindow(getItem().getUserId(), getItem().getLanguage(), aftt);
        getUI().addWindow(translationWindow);
    }


    @Override
    protected void deleteDataFormServer() {
        ServiceLocator.findLifetimeService().delete(getItem());
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        if(event.getButton() == getHideButton()) {
            getItem().setHidden(true);
            ServiceLocator.findLifetimeService().update(getItem());
        }
        else {
            super.buttonClick(event);
        }
    }
    
    

}
