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

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import java.text.DecimalFormat;

/**
 *
 * @author zua
 */
public abstract class LabeledInfoView extends HorizontalLayout {

    private final Label info;
    private final Label label;
    private final Label iconLabel;
    private static final DecimalFormat format = new DecimalFormat("###,###");

    public LabeledInfoView(String key, Object value, FontAwesome icon) {
        this.info = (value instanceof Number)? new Label(format.format(value)) : new Label(value.toString());
        this.label = new Label(key);
        this.iconLabel = (icon == null) ? new Label() : new Label(icon.getHtml(), ContentMode.HTML);
        // customize components
        info.addStyleName("i-value");
        label.addStyleName("i-tag");
        iconLabel.addStyleName("i-icon");
        // add components to layout
        super.addComponents(this.iconLabel, this.info, this.label);
        super.setStyleName("l-info");
        super.setSizeUndefined();
        super.setSpacing(true);
    }


    public Label getInfo() {
        return info;
    }

    public Label getLabel() {
        return label;
    }

    public Label getIconLabel() {
        return iconLabel;
    }


    
}
