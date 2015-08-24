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
import lifetime.logic.timeline.Plan;
import lifetime.logic.timeline.Point;

/**
 *
 * @author zua
 */
class PlanLayout extends AbsoluteLayout {

    private final Plan plan;
    private AxisLayout ordinate;
    private AxisLayout coordinate;
    private Point origin;

    public PlanLayout(Plan plan) {
        this.plan = plan;
        setSizeFull();
        initView();
    }

    private void initView() {
        this.ordinate = new HorizontalAxisLayout(plan.getOrdinateAxis());
        this.coordinate = new VerticalAxisLayout(plan.getCoordinateAxis());
        addComponent(ordinate, getOrdinateCSSString());
        addComponent(coordinate, getCoordinateCSSString());
    }

    private String getOrdinateCSSString() {
        return "left:"+((float)origin.getX()) +  ";" + "bottom:"+((float)origin.getY());
    }

    private String getCoordinateCSSString() {
        return "left:"+((float)origin.getX()) +  ";" + "bottom:"+((float)origin.getY());
    }

}
