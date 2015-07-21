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

import old.ui.button.LifetimeButtonSmall;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.FormLayout;

/**
 *
 * @author lifetime
 */
public class TranslationCard extends FormLayout {
    private WordCard original;
    private EditabeWordCard translation;
    private final LifetimeButtonSmall translate;
    
    public TranslationCard(final Integer userId, final String word, final String from, final String to) {
        original = new WordCard(word, from);
        translation = new EditabeWordCard(word, to);
        translate = new LifetimeButtonSmall("Translate", FontAwesome.CHECK);
        addComponents(original, translation, translate);
    }

    public LifetimeButtonSmall getTranslate() {
        return translate;
    }

    public WordCard getOriginal() {
        return original;
    }

    public EditabeWordCard getTranslation() {
        return translation;
    }
    
    
    
    
}
