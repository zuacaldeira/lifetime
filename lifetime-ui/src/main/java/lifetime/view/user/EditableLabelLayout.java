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
package lifetime.view.user;

import com.vaadin.data.Property;
import com.vaadin.event.LayoutEvents;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import lifetime.util.StyleClassName;

/**
 *
 * @author zua
 */
public class EditableLabelLayout extends VerticalLayout implements LayoutClickListener, Property.ValueChangeListener {

    private final Label label;
    private final TextField text;

    public EditableLabelLayout(Label aLabel) {
        this.label = aLabel;
        label.setDescription("Click to edit");
        this.text = new TextField(label.getPropertyDataSource());
        text.setVisible(false);
        text.setSizeUndefined();
        setSpacing(true);
        setSizeUndefined();
        setStyleName(StyleClassName.EDITABLE_LABEL.getStyleName());
        setId(StyleClassName.EDITABLE_LABEL.getStyleName());
        addLayoutClickListener(this);
        text.setStyleName(ValoTheme.TEXTFIELD_LARGE);
        text.addValueChangeListener(this);
        addComponents(label, text);
    }

    @Override
    public void layoutClick(LayoutEvents.LayoutClickEvent event) {
        Notification.show("Component: " + event.getClickedComponent(), Notification.Type.WARNING_MESSAGE);
        if (event.getClickedComponent() instanceof Label) {
            text.setVisible(true);
            text.focus();
        }
    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        Notification.show("Changed Property: " + event.getProperty(), Notification.Type.WARNING_MESSAGE);
        text.setVisible(false);
    }

}
