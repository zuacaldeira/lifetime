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

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Label;
import java.util.Date;
import lifetime.logic.timeline.Axis;
import lifetime.logic.timeline.MeasureUnit;
import lifetime.logic.timeline.Point;
import lifetime.logic.timeline.TimeAxis;
import lifetime.logic.timeline.TimePlan;
import lifetime.logic.timeline.TimeUnit;

/**
 *
 * @author zua
 */
public class TimelineLayout extends AbsoluteLayout {

    private int zoom;
    private final Date start;
    private final Date end;
    private TimePlan<Axis> timedPlan;
    private Point origin;
    private final ComponentPosition originPosition;

    public TimelineLayout(Date start, Date end) {
        setSizeFull();
        // Init fields
        this.start = start;
        this.end = end;
        TimeAxis timeAxis = new TimeAxis(new TimeUnit("year", "y", 1, 0), 100);
        Axis yAxis = new Axis(new MeasureUnit("%", "%", 1, 0), 100);
        this.timedPlan = new TimePlan<>(timeAxis, yAxis);
        origin = new Point(0.0, 0.0);
        originPosition = new ComponentPosition();
        originPosition.setBottom((float) origin.getY(), Unit.PERCENTAGE);
        originPosition.setLeft((float) origin.getX(), Unit.PERCENTAGE);

        // draw ui components
        drawPlan();
    }

    /**
     *
     */
    private void drawPlan() {
        addOrigin();
        addComponent(TimelineLayoutProvider.getPlanLayout(timedPlan));
    }

    private void addOrigin() {
        Label originMark = new Label(FontAwesome.DOT_CIRCLE_O.getHtml(), ContentMode.HTML);
        addComponent(originMark);
        setPosition(originMark, originPosition);
    }

}
