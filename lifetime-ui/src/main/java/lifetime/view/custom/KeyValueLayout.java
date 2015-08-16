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
package lifetime.view.custom;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import java.util.Objects;

/**
 *
 * @author zua
 */
public class KeyValueLayout extends HorizontalLayout {

    private final Label keyLabel;
    private final Label valueLabel;

    public KeyValueLayout(String key, String value) {
        this.keyLabel = new Label(key);
        this.valueLabel = new Label(value);
        addComponents(keyLabel, valueLabel);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.keyLabel.getValue());
        hash = 43 * hash + Objects.hashCode(this.valueLabel.getValue());
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
        final KeyValueLayout other = (KeyValueLayout) obj;
        if (!Objects.equals(this.keyLabel.getValue(), other.keyLabel.getValue())) {
            return false;
        }
        return Objects.equals(this.valueLabel.getValue(), other.valueLabel.getValue());
    }

}
