/*
 * Copyright 2016 zuacaldeira.
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
package lifetime.component;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.VerticalLayout;
import lifetime.component.custom.LifetimeButtonLink;

/**
 * View class that organizes a set of links in a vertical layout.
 * @author zuacaldeira
 */
public class VerticalLinksLayout extends VerticalLayout {
    
    /**
     * Instantiates a new vertical links holder
     */
    public VerticalLinksLayout() {
        setSizeUndefined();
    }
    
    /**
     * Adds a new link
     * @param caption   The visible link
     * @param target    The view we should travel to
     */
    public void addLink(String caption, String target) {
        LifetimeButtonLink link = new LifetimeButtonLink(caption, null, FontAwesome.ARROW_LEFT);
        addComponent(link);
    }
}
