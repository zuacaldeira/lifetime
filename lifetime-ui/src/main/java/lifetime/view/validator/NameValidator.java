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
public class NameValidator implements Validator {

    public NameValidator() {
    }

    @Override
    public void validate(Object value) {
        if (value instanceof String) {
            String stringValue = (String) value;
            if (stringValue.length() == 0) {
                throw new InvalidValueException("Zero lenght name");
            }
            
            for(int i = 0; i < stringValue.length(); i++) {
                boolean validNameCharacter = Character.isLetter(stringValue.charAt(i)) || Character.isSpaceChar(stringValue.charAt(i)) || stringValue.charAt(i) == '-';
                if(! validNameCharacter) {
                    throw new InvalidValueException("Invalid name character: " + stringValue.charAt(i));
                }
            }
            
        } else {
            throw new InvalidValueException("Null name");
        }
    }

}
