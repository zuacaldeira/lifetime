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
package lifetime.component.user.vitae;

import com.vaadin.ui.Component;
import java.util.LinkedList;
import java.util.List;
import lifetime.backend.persistence.jooq.tables.LifetimeEvent;
import lifetime.component.LifetimeContent;

/**
 * Content view for showcase and management of curricular data.
 *
 * @author zua
 */
public class VitaeContent extends LifetimeContent {

    private final String username;

    /**
     * Instantiates a new instance of vitae content.
     *
     * @param username User owning the data
     * @param language The current interacting language
     */
    public VitaeContent(String username, String language) {
        super(language);
        this.username = username;
        addComponents(getEventViews());
    }

    private Component[] getEventViews() {
        List<LifetimeEvent> events = new LinkedList();
        List<LifetimeEventView> eventsViews = new LinkedList();
        for (LifetimeEvent event : events) {
            eventsViews.add(new LifetimeEventView(event));
        }
        Component[] result = new Component[eventsViews.size()];
        return eventsViews.toArray(result);
    }
    
    

}
