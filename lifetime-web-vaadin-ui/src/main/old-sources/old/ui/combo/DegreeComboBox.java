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

import lifetime.business.persistence.Degree;
import old.ui.data.DegreeDataContainer;
import old.util.ServiceLocator;

/**
 *
 * @author lifetime
 */
public class DegreeComboBox extends LifetimeComboBox {
    private final String language;

    public DegreeComboBox(String language) {
        super("Degree", language, new DegreeDataContainer(language));
        this.language = language;
        setNewItemsAllowed(true);
        setImmediate(true);
        setRequired(true);
        setNewItemHandler(new NewItemHandler() {
            @Override
            public void addNewItem(String newItemCaption) {
                Degree degree = new Degree();
                degree.setFullname(newItemCaption);
                degree.setLanguage(getLanguage());
                ServiceLocator.findLifetimeService().add(degree);
                addItem(degree);
                setValue(degree);
            }
        });
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public Degree getValue() {
        return (Degree) super.getValue(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
    
}
