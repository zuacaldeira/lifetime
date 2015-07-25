/*
 * Copyright 2015 zua.
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
package lifetime.view.validator;

import com.vaadin.data.Validator;

/**
 *
 * @author zua
 */
class AllCharTypesValidator implements Validator {

    public AllCharTypesValidator() {
    }

    /**
     * Default validation method. It performs no validation, allowing weak
     * passwords.
     *
     * @param value The value to validate.
     * @throws com.vaadin.data.Validator.InvalidValueException Never thrown in
     * this default implementation.
     */
    @Override
    public void validate(Object value) {
        if (!(value instanceof String)) {
            throw new InvalidValueException("Invalid Value. Expecting a String");
        }
        String v = (String) value;
        int size = v.length();

        if (size < 6) {
            throw new InvalidValueException("Too small: " + v);
        }

        int nlowers = 0;
        int nUppers = 0;
        int nDigits = 0;
        int nSpecial = 0;

        for (int i = 0; i < size; i++) {
            char c = v.charAt(i);
            if (Character.isDigit(c)) {
                nDigits++;
            } else if (Character.isUpperCase(c)) {
                nUppers++;
            } else if (Character.isLowerCase(c)) {
                nlowers++;
            } else if (Character.isWhitespace(c)) {
                throw new InvalidValueException("White spaces not allowed at index : " + i);
            } else {
                nSpecial++;
            }
        }
        
        if(nlowers == 0) {
                throw new InvalidValueException("At least one character must be a lower case");
        }
        if(nUppers == 0) {
                throw new InvalidValueException("At least one character must be an uppercase");
        }
        if(nDigits == 0) {
                throw new InvalidValueException("At least one character must be a digit");
        }
        if(nSpecial == 0) {
                throw new InvalidValueException("At least one character must be a special character");
        }
    }

}
