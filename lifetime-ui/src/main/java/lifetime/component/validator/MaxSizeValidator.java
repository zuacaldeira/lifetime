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
package lifetime.component.validator;

import com.vaadin.data.Validator;

/**
 *
 * @author zua
 */
class MaxSizeValidator implements Validator {
    public static final int MAX_SIZE = 16;

    public MaxSizeValidator() {
    }

    @Override
    public void validate(Object value) {
        if (((String) value).length() > MAX_SIZE) {
            throw new InvalidValueException("Too big");
        }
    }

}
