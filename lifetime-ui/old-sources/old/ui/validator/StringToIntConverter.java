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

import com.vaadin.data.util.converter.Converter;
import java.util.Locale;

/**
 *
 * @author lifetime
 */
class StringToIntConverter implements Converter<Object, Integer> {

    public StringToIntConverter() {
    }

    @Override
    public Class<Integer> getModelType() {
        return Integer.class;
    }


    @Override
    public Integer convertToModel(Object value, Class<? extends Integer> targetType, Locale locale) throws ConversionException {
        if(value == null) {
            return null;
        }
        if(value instanceof String) {
            return Integer.valueOf((String) value);
        }
        else{
            throw new ConversionException("Cannot convert from a " + value.getClass());
        }
    }

    @Override
    public Object convertToPresentation(Integer value, Class<? extends Object> targetType, Locale locale) throws ConversionException {
        if(value == null) {
            return null;
        }
        return String.valueOf(value);
    }

    @Override
    public Class<Object> getPresentationType() {
        return Object.class;
    }
    
}
