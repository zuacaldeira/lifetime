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

import java.util.Date;
import lifetime.business.persistence.Project;
import old.ui.data.ProjectDataContainer;
import old.util.ServiceLocator;

/**
 *
 * @author lifetime
 */
public class ProjectComboBox extends LifetimeComboBox {
    private final String language;

    public ProjectComboBox(String language) {
        super("Project Name", language, new ProjectDataContainer(language));
        this.language = language;
        setNewItemsAllowed(true);
        setImmediate(true);
        setRequired(true);
        setNewItemHandler(new NewItemHandler() {
            @Override
            public void addNewItem(String newItemCaption) {
                Project project = new Project();
                project.setName(newItemCaption);
                project.setLanguage(getLanguage());
                project.setCreatedAt(new Date());
                ServiceLocator.findLifetimeService().add(project);
                addItem(project);
                setValue(project);
            }
        });
    }
    
    @Override
    public Project getValue() {
        return (Project) super.getValue();
    }
    
}
