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
package old.translation;

import old.ui.label.LifetimeLabel;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import old.ui.textField.LifetimeTextField;

/**
 *
 * @author lifetime
 */
public class EditabeWordCard extends HorizontalLayout {
    private LifetimeTextField lword;
    private LifetimeLabel llanguage;
    
    public EditabeWordCard(String word, String language) {
        lword = new LifetimeTextField();
        llanguage = new LifetimeLabel(language, language);
        addComponents(llanguage, lword);
        setComponentAlignment(lword, Alignment.MIDDLE_LEFT);
        setComponentAlignment(llanguage, Alignment.MIDDLE_RIGHT);
    }

    public LifetimeTextField getWord() {
        return lword;
    }

    public LifetimeLabel getLanguage() {
        return llanguage;
    }
    
    
    
}
