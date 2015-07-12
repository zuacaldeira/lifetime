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
package views;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;

/**
 *
 * @author zua
 */
public abstract class LifetimeMenu extends HorizontalLayout {
    private final String language;
    private final HorizontalLayout controls;

    public LifetimeMenu(String language) {
        this.language = language;
        controls = new HorizontalLayout();
        addComponent(controls);
        setComponentAlignment(controls, Alignment.MIDDLE_RIGHT);
        setStyleName("menu");

    }

    public String getLanguage() {
        return language;
    }

    public void addControl(LifetimeButtonLink lifetimeButton) {
        controls.addComponent(lifetimeButton);
    }
    
    public void addClickListener(ClickListener listener) {
        for(int i = 0; i < controls.getComponentCount(); i++) {
            ((Button)controls.getComponent(i)).addClickListener(listener);
        }
    }
    
    
    
}
