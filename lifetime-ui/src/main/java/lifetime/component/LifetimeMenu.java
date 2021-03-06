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
package lifetime.component;

import lifetime.component.custom.LifetimeButtonLink;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import java.util.Objects;
import lifetime.util.StyleClassName;

/**
 *
 * @author zua
 */
public abstract class LifetimeMenu extends HorizontalLayout {

    private final String language;
    private HorizontalLayout controls;

    public LifetimeMenu(String language) {
        this.language = language;
        initControls();
        addComponent(controls);
        setComponentAlignment(controls, Alignment.MIDDLE_RIGHT);
        setStyleName(StyleClassName.LIFETIME_MENU.getStyleName());
        setSizeFull();
    }

    public HorizontalLayout getControls() {
        return controls;
    }

    public String getLanguage() {
        return language;
    }

    public void addControl(LifetimeButtonLink lifetimeButton) {
        controls.addComponent(lifetimeButton);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 93 * hash + Objects.hashCode(this.language);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.language, ((LifetimeMenu) obj).language);
    }

    private void initControls() {
        controls = new HorizontalLayout();
        controls.setWidthUndefined();
        addControls();
    }

    protected abstract void addControls();

}
