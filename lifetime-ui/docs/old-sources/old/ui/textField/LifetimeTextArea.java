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
package old.ui.textField;

import com.vaadin.ui.RichTextArea;
import old.util.Translator;

/**
 *
 * @author lifetime
 */
public class LifetimeTextArea extends RichTextArea {
    private final String language;

    public LifetimeTextArea(String caption) {
        this(caption, "en");
    }
    
    public LifetimeTextArea(String caption, String language) {
        super(Translator.getTranslation(caption, language));
        this.language = language;
        setWidth("400px");
    }

    public String getLanguage() {
        return language;
    }
    
    
    
}
