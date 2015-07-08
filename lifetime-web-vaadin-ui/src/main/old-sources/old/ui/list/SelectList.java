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

import com.vaadin.data.Container;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author lifetime
 */
public abstract class SelectList extends VerticalLayout {
    private final OptionGroup options;
    private final String language;
    private final Integer userId;
    public SelectList(String caption, Integer userId, String language, Container dataSource) {
        setCaption(caption);
        setWidth("400px");
        this.language = language;
        this.userId = userId;
        options = new OptionGroup("Select all that apply");
        options.setContainerDataSource(dataSource);
        options.setMultiSelect(true);
        options.setNewItemsAllowed(true);
        addComponent(options);
        setStyleName("a-list");
    }

    protected void initNewItemHandler() {
        options.setNewItemHandler(getNewItemHandler());
    }
    protected abstract AbstractSelect.NewItemHandler getNewItemHandler();

    public OptionGroup getOptions() {
        return options;
    }

    public String getLanguage() {
        return language;
    }

    public Integer getUserId() {
        return userId;
    }

}
