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

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import java.text.DecimalFormat;
import java.util.Objects;

/**
 *
 * @author zua
 */
public class NumericStatsView extends VerticalLayout {

    private final String key;
    private final Integer value;

    public NumericStatsView(String label, int i) {
        this.key = label;
        this.value = i;
        setSizeUndefined();
        DecimalFormat format = new DecimalFormat("###,###");
        // Tags ans values
        Label tag = new Label(label);
        tag.setSizeUndefined();
        Label lvalue = new Label(format.format(i));
        addComponents(tag, lvalue);
        // Component alignment
        setComponentAlignment(tag, Alignment.MIDDLE_CENTER);
        setComponentAlignment(lvalue, Alignment.MIDDLE_CENTER);
        // css styles
        tag.setStyleName("tag");
        lvalue.setStyleName("value");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.key);
        hash = 79 * hash + Objects.hashCode(this.value);
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
        final NumericStatsView other = (NumericStatsView) obj;
        return Objects.equals(this.key, other.key) && Objects.equals(this.value, other.value);
    }

}
