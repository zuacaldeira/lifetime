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

import com.vaadin.data.Property;
import com.vaadin.ui.ComboBox;
import old.ui.data.AchievementTypeDataSource;

/**
 *
 * @author lifetime
 */
public class AchievementComboBox extends ComboBox implements Property.ValueChangeListener {

    public AchievementComboBox(String caption) {
        super(caption, new AchievementTypeDataSource());
        setWidth("5cm");
    }
    
    
    
}
