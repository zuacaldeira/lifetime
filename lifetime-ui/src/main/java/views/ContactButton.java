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
package views;

import com.vaadin.server.FontAwesome;
import java.util.Objects;
import util.Translator;

/**
 *
 * @author lifetime
 */
public class ContactButton extends LifetimeButtonLink {

    private final String text;

    public ContactButton(String language) {
        super(Translator.getTranslation("Contact", language), FontAwesome.USER);
        this.text = Translator.getTranslation("Contact", language);
        setDescription(text);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.text);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        final ContactButton other = (ContactButton) obj;
        return Objects.equals(this.text, other.text);
    }

}
