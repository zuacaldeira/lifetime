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
package old.ui.combo;

import com.vaadin.data.util.IndexedContainer;
import java.util.Collection;

/**
 *
 * @author lifetime
 */
class YearComboBox extends LifetimeComboBox {

    public YearComboBox(String label, String language, Collection<?> years) {
        super(label, language, new IndexedContainer(years));
        setWidth("3cm");
        //setConverter(new StringToIntConverter());
        //setImmediate(true);
        //setNullSelectionAllowed(true);
    }
    
}
