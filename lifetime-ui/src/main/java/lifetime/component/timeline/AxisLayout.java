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

import com.vaadin.ui.AbsoluteLayout;
import lifetime.logic.timeline.Axis;

/**
 *
 * @author zua
 */
abstract class AxisLayout extends AbsoluteLayout {

    private final Axis axis;

    public AxisLayout(Axis axis) {
        this.axis = axis;
        setStyleName("axis");
        initLayout();

    }

    private void initLayout() {
        float delta = 100f / axis.getNumberOfUnits();

        for (int i = 1; i < 100; i++) {
            addMark(delta * i);
        }
    }

    protected abstract void addMark(float f);

}
