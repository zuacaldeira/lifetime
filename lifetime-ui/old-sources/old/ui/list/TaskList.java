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
package old.ui.list;

import old.util.ServiceLocator;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.Notification;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import lifetime.business.persistence.Task;

/**
 *
 * @author lifetime
 */
public class TaskList extends SelectList {

    public TaskList(String caption, Integer userId, String language) {
        super(caption, userId, language, new DataSource(language));
        initNewItemHandler();
    }

    @Override
    protected AbstractSelect.NewItemHandler getNewItemHandler() {
        return new AbstractSelect.NewItemHandler() {

            @Override
            public void addNewItem(String newItemCaption) {
                Task task = new Task();
                task.setTask(newItemCaption);
                task.setLanguage(getLanguage());
                task.setCreatedAt(new Date());
                ServiceLocator.findLifetimeService().addTask(task);
                Notification.show("Task Added", Notification.Type.ERROR_MESSAGE);
                getOptions().addItem(task);
            }
        };
    }

    public List<Task> getTasks() {
        return new LinkedList((Set<Task>)super.getOptions().getValue());
    }
    

    private static class DataSource extends IndexedContainer {

        public DataSource(String language) {
            super(getTasks(language));
        }
        
        private static List<Task> getTasks(String language) {
            return ServiceLocator.findLifetimeService().getTasks(language);
        }
    }
    
    
    
}
