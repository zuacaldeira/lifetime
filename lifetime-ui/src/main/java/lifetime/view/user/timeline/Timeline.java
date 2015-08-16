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
package lifetime.view.user.timeline;

import com.vaadin.data.Property;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Slider;
import java.util.Date;
import lifetime.view.custom.LifetimeButtonLink;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 *
 * @author zua
 */
class Timeline extends HorizontalLayout implements Property.ValueChangeListener {

    /*
     * CONTROLS
     */
    private Slider slider;
    private final Date start;
    private final Date end;
    private final int MAX;
    /*
     * DATA
     */

    public Timeline(Date start, Date end) {
        setSizeFull();
        this.start = start;
        this.end = end;

        MAX = Days.daysBetween(new DateTime(start.getTime()), new DateTime(end.getTime())).getDays();
        initTiles();
    }

    private void initTiles() {
        for (int i = 0; i < MAX; i += 1000) {
            System.out.println("i = " + i);
            addComponent(getUnitTile(i));
        }
    }

    private Component getUnitTile(int i) {
        if (i % 2 == 0) {
            return new LifetimeButtonLink(null, "en", FontAwesome.LINK);
        } else {
            return new LifetimeButtonLink(null, "en", FontAwesome.LIFE_RING);
        }
    }

    private void initSlider() {
        slider = new Slider("Timeline", 0, MAX);
        slider.setSizeFull();
        slider.setHeightUndefined();
        slider.addValueChangeListener(this);
    }

    public Date getSliderDate() {
        if (slider.getValue() == 0.0) {
            return start;
        } else {
            long t = (long) ((slider.getValue() * (end.getTime() - start.getTime())) / MAX);
            return new Date(start.getTime() + t);
        }

    }

    public double getSliderValue(Date date) {
        // TODO
        // x = (t/end) * 100
        return (date.getTime() / end.getTime()) * MAX;
    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        Notification.show("Slider Value:" + slider.getValue());
        Notification.show("Date:" + getSliderDate().toString());

    }

}
