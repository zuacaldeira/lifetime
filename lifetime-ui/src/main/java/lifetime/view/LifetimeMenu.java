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
package lifetime.view;

import lifetime.view.custom.LifetimeButtonLink;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import java.util.Objects;

/**
 *
 * @author zua
 */
public abstract class LifetimeMenu extends CustomComponent {
    private final String language;
    private final HorizontalLayout controls;
    private final HorizontalLayout base;
    

    public LifetimeMenu(String language) {
        this.language = language;
        controls = new HorizontalLayout();
        controls.setSizeUndefined();
        base = new HorizontalLayout(controls);
        base.setSizeFull();
        base.setComponentAlignment(controls, Alignment.MIDDLE_RIGHT);
        setCompositionRoot(base);
        setStyleName(StyleClassName.LIFETIME_MENU);
        setId(StyleClassName.LIFETIME_MENU);
        
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
    
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.language);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LifetimeMenu other = (LifetimeMenu) obj;
        return Objects.equals(this.language, other.language);
    }


    
    
    
    
    
    
}
