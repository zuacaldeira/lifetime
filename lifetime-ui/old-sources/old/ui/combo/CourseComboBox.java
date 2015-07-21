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

import lifetime.business.persistence.Course;
import old.ui.data.CourseDataContainer;
import old.util.ServiceLocator;

/**
 *
 * @author lifetime
 */
public class CourseComboBox extends LifetimeComboBox {
    private final String language;

    public CourseComboBox(String language) {
        super("Course", language, new CourseDataContainer(language));
        this.language = language;
        setNewItemsAllowed(true);
        setImmediate(true);
        setRequired(true);
        setNewItemHandler(new NewItemHandler() {
            @Override
            public void addNewItem(String newItemCaption) {
                Course course = new Course();
                course.setName(newItemCaption);
                course.setLanguage(getLanguage());
                ServiceLocator.findLifetimeService().add(course);
                addItem(course);
                setValue(course);
            }
        });
    }
    
        @Override
    public Course getValue() {
        return (Course) super.getValue(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
