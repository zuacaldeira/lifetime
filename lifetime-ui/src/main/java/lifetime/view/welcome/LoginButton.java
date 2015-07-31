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
package lifetime.view.welcome;

import com.vaadin.server.FontAwesome;
import java.util.Objects;
import lifetime.util.StyleClassName;
import lifetime.util.Translator;
import lifetime.view.custom.LifetimeButtonLink;

/**
 *
 * @author lifetime
 */
public class LoginButton extends LifetimeButtonLink {

    private final String text;

    public LoginButton(String language) {
        super(Translator.getTranslation("Login", language), language, FontAwesome.KEY);
        this.text = Translator.getTranslation("Login", language);
        setDescription(text);
        setId(StyleClassName.LOGIN_BUTTON);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.text);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        final LoginButton other = (LoginButton) obj;
        return Objects.equals(this.text, other.text);
    }

}
