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
package old.ui.window;

import com.vaadin.ui.Window;
import old.ui.user.MissingTranslationsView;
import old.util.Translator;

/**
 *
 * @author lifetime
 */
public class TranslationWindow extends Window {

    public TranslationWindow(Integer userId, String language) {
        super(Translator.getTranslation("Missing translations", language));
        setContent(new MissingTranslationsView(userId, language));
       
        setWidth("50%");
        setHeight("50%");
        center();
        setResizable(true);
        setModal(true);
        addCloseListener(new CloseListener() {
            @Override
            public void windowClose(CloseEvent e) {
                close();
            }
        });
        setStyleName("window");
    }

}
