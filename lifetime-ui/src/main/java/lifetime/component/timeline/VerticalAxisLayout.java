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
package lifetime.component.timeline;

import com.vaadin.ui.Label;
import lifetime.logic.timeline.Axis;

/**
 *
 * @author zua
 */
public class VerticalAxisLayout extends AxisLayout {

    public VerticalAxisLayout(Axis axis) {
        super(axis);
        setHeight("100%");
        setWidth(4f, Unit.PIXELS);

    }

    @Override
    protected void addMark(float f) {
        Label mark = new Label(".");
        addComponent(mark, "bottom:" + f);
    }

}
