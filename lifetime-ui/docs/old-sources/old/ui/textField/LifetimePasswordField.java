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

import old.util.Translator;
import com.vaadin.data.Validator;
import com.vaadin.ui.PasswordField;

/**
 *
 * @author lifetime
 */
public class LifetimePasswordField extends PasswordField {
    private PasswordField password;

    public LifetimePasswordField(String language) {
        super(Translator.getTranslation("Password:", language));
        setWidth("300px");
        setRequired(true);
        setImmediate(true);
        setComponentError(null);
    }

    public LifetimePasswordField(String language, PasswordField password) {
        this(language);
        this.password = password;
        setRequired(true);
        setImmediate(true);
        setComponentError(null);
    }

    private class PasswordValidator implements Validator {
        private final String pass;

        public PasswordValidator(String pass) {
            this.pass = pass.trim();
        }

        @Override
        public void validate(Object value) throws InvalidValueException {
            String s = ((String) value).trim();
            checkIsValid(s);
        }

        private void checkIsValid(String value) {
            /*int upppers = 0, lowers = 0, letters = 0, digits = 0;
            for (int i = 0; i < value.length(); i++) {
                char c = value.charAt(i);
                if (Character.isLetter(c)) {
                    letters++;
                    if (Character.isUpperCase(c)) {
                        upppers++;
                    } else if (Character.isLowerCase(c)) {
                        lowers++;
                    } else {
                        throw new InvalidValueException("Invalid character: " + c);
                    }
                } else if (Character.isDigit(c)) {
                    digits++;
                }
            }
            */
            if (value.length() < 8) {
                throw new InvalidValueException("Too Small. MINIMUM 8");
            }

            /*            if(upppers < 1) {
             throw new InvalidValueException("At least one UPPERCASE");
             }

             if(lowers < 1) {
             throw new InvalidValueException("At least one LOWERCASE");
             }            
             if(digits < 1) {
             throw new InvalidValueException("At least one DIGIT");
             }
             if(letters < 1) {
             throw new InvalidValueException("At least one LETTER");
             }        
             */
            
            if(pass != null && !value.equals(pass)) {
                throw new InvalidValueException("Passwords are not equal");
            }
        }

    }

}
