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
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import java.text.DecimalFormat;

/**
 *
 * @author zua
 */
class NumericStatsView extends VerticalLayout {
    private final Label tag;
    private final Label value;

    public NumericStatsView(String label, int i) {
        setSizeUndefined();
        DecimalFormat format = new DecimalFormat("###,###");
        // Tags ans values
        tag = new Label(label);
        tag.setSizeUndefined();
        value = new Label(format.format(i));
        addComponents(tag, value);
        // Component alignment
        setComponentAlignment(tag, Alignment.MIDDLE_CENTER);
        setComponentAlignment(value, Alignment.MIDDLE_CENTER);
        // css styles
        tag.setStyleName("tag");
        value.setStyleName("value");
    }
    
}
