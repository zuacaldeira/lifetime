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
package lifetime.component.custom;

import com.vaadin.ui.InlineDateField;
import java.util.Objects;
import lifetime.util.Translator;

/**
 *
 * @author lifetime
 */
public class LifetimeDateField extends InlineDateField {

    private final String language;

    public LifetimeDateField(String caption, String language) {
        super(Translator.getTranslation(caption, language));
        this.language = language;
        setImmediate(true);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.language);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LifetimeDateField other = (LifetimeDateField) obj;
        return Objects.equals(this.language, other.language);
    }

    public String getLanguage() {
        return language;
    }

    
}
