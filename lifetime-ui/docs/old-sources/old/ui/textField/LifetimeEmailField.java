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

import old.util.ServiceLocator;
import old.util.Translator;
import com.vaadin.data.Validator;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.ui.TextField;

/**
 *
 * @author lifetime
 */
public class LifetimeEmailField extends TextField {

    public LifetimeEmailField(String language) {
        super(Translator.getTranslation("Email (username)", language));
        setWidth("300px");
        setRequired(true);
        addValidator(new LifetimeEmailValidator(language));
    }

    private static class LifetimeEmailValidator implements Validator {

        private final String language;

        public LifetimeEmailValidator(String language) {
            this.language = language;
        }

        @Override
        public void validate(Object value) throws InvalidValueException {
            String s = ((String) value).trim();
            EmailValidator ev = new EmailValidator("Invalid Email");
            ev.validate(s);
            //
            if (ServiceLocator.findLifetimeService().usernameExists(s)) {
                throw new InvalidValueException(Translator.getTranslation("Username already given", language));
            }
        }
    }

}
