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
package old.ui.button;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Window;
import ui.LifetimeUI;
import old.util.Translator;
import old.ui.window.TranslationWindow;

/**
 *
 * @author lifetime
 */
public class TranslateButton extends LifetimeButtonLink implements ClickListener {
    private final Integer userId;
    private final String language;

    public TranslateButton(final Integer userId, final String language) {
        super(Translator.getTranslation("Translate", language), FontAwesome.LANGUAGE);
        this.userId = userId;
        this.language = language;
        addClickListener(this);
        setDescription(Translator.getTranslation("Show missing translations", language));
    }

    @Override
    public void buttonClick(ClickEvent event) {
        showMissingTranslations();
    }

    private void showMissingTranslations() {
        Window window = new TranslationWindow(userId, language);
        getUI().addWindow(window);
                
    }

    @Override
    public LifetimeUI getUI() {
        return (LifetimeUI) super.getUI();
    }

}
