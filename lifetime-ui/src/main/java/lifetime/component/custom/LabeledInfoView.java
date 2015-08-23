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
package lifetime.component.custom;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import java.util.Objects;

/**
 *
 * @author zua
 */
public class LabeledInfoView extends VerticalLayout {

    private final Label key;
    private final Component info;

    public LabeledInfoView(Label key, Component info) {
        this.key = key;
        this.info = info;
        setSizeUndefined();
        key.setStyleName("tag");
        info.setStyleName("value");
        addComponents(key, info);
    }

    public Label getKey() {
        return key;
    }

    public Component getInfo() {
        return info;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.key.getValue());
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
        final LabeledInfoView other = (LabeledInfoView) obj;
        return Objects.equals(this.key.getValue(), other.key.getValue());
    }

}