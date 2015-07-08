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
package old.ui.validator;

import com.vaadin.data.Validator;
import com.vaadin.ui.Notification;

/**
 *
 * @author lifetime
 */
public class PersonNameValidator implements Validator {

    public PersonNameValidator() {
    }

    @Override
    public void validate(Object value) throws Validator.InvalidValueException {

        if (value == null) {
            throw new Validator.InvalidValueException("Names cannot be null");
        }
        Notification.show(value.getClass().getName(), Notification.Type.HUMANIZED_MESSAGE);
        if (value.toString().trim().length() < 1) {
            throw new Validator.InvalidValueException("Names cannot be empty");
        }
        if (!isValid(((String) value).trim())) {
            throw new Validator.InvalidValueException("Names cannot be empty");
        }

    }

    private boolean isValid(String value) {
        return isLettersOnly(value);
    }

    private boolean isLettersOnly(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isAlphabetic(value.codePointAt(i))) {
                return false;
            }
        }
        return true;
    }

}
