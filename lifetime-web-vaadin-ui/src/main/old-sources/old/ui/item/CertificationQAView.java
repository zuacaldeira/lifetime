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
import old.ui.form.CertificationFormEdit;
import old.ui.form.CertificationFormTranslate;
import old.util.ServiceLocator;
import old.ui.window.EditAchievementWindow;
import old.ui.window.TranslateAchievementWindow;
import com.vaadin.ui.Window;
import java.util.Set;
import lifetime.business.persistence.Certification;

/**
 *
 * @author lifetime
 */
public class CertificationQAView extends QAView<Certification> {

    public CertificationQAView(Certification item) {
        super(item.getUserId(), item.getLanguage(), item);
    }

    @Override
    protected Set<String> getNotTranslatedLanguages() {
        return ServiceLocator.findLifetimeService().getNotTranslatedLanguages(getItem().getUserId(), getItem());
    }

    @Override
    protected void showEditForm() {
        CertificationFormEdit afe = new CertificationFormEdit(getItem(), getList());
        Window window = new EditAchievementWindow(getItem().getUserId(), getItem().getLanguage(), afe);
        getUI().addWindow(window);
    }

    @Override
    protected void showTranslateTo(String language) {
        CertificationFormTranslate aftt = new CertificationFormTranslate(getItem(), language, getList());
        Window window = new TranslateAchievementWindow(getItem().getUserId(), getItem().getLanguage(), aftt);
        getUI().addWindow(window);
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
