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
package lifetime.view;

import com.vaadin.server.FontAwesome;
import java.util.Objects;
import util.Translator;

/**
 *
 * @author lifetime
 */
public class VitaeButton extends LifetimeButtonLink {
    private final String text;

    public VitaeButton(String language) {
        super(Translator.getTranslation("Login", language), language, FontAwesome.USER);
        this.text = Translator.getTranslation("Login", language);
        setDescription(text);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.text);
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
        final VitaeButton other = (VitaeButton) obj;
        return Objects.equals(this.text, other.text);
    }
    
    
    
}
