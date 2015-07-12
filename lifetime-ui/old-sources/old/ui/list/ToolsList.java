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
import com.vaadin.ui.OptionGroup;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import lifetime.business.persistence.Tool;

/**
 *
 * @author lifetime
 */
public class ToolsList extends OptionGroup {
    private final String language;

    public ToolsList(String caption, Integer userId, final String language) {
        super(caption, new DataSource(language));
        this.language = language;
        setNewItemsAllowed(true);
        setMultiSelect(true);
        setNewItemHandler(new DefaultNewItemHandler() {
            @Override
            public void addNewItem(String newItemCaption) {
                super.addNewItem(newItemCaption);
                Tool tool = new Tool();
                tool.setName(newItemCaption);
                tool.setLanguage(language);
                tool.setCreatedAt(new Date());
                ServiceLocator.findLifetimeService().addTool(tool);
                addItem(tool);
            }
        });
    }

    public List<Tool> getTools() {
        return new LinkedList((Set<Tool>) getValue());
    }

    private static class DataSource extends IndexedContainer {

        public DataSource(String language) {
            super(getTools(language));
        }

        private static List<Tool> getTools(String language) {
            return ServiceLocator.findLifetimeService().getTools(language);
        }
    }

}
