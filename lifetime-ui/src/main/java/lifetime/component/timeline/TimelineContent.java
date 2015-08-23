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

import com.vaadin.ui.Notification;
import java.util.Calendar;
import java.util.Date;
import lifetime.backend.persistence.Timed;
import lifetime.util.ServiceLocator;
import lifetime.component.LifetimeContent;

/**
 *
 * @author zua
 */
class TimelineContent extends LifetimeContent {

    private final String username;
    private final TimelineLayout timeline;

    public TimelineContent(String username, String language) {
        super(language);
        this.username = username;
        timeline = new TimelineLayout(getBirthDate(username), new Date());
        addComponent(timeline);
        setSizeFull();
        initDummyData();
    }

    private Date getBirthDate(String username) {
        return ServiceLocator.findLifetimeAccountService().getUser(username).getBirthDate();
    }

    private void initDummyData() {
        Calendar cal = Calendar.getInstance();
        cal.set(1978, 0, 20);
        Date birth = cal.getTime();

        cal.set(1989, 11, 21);
        Date pause = cal.getTime();

        cal.set(1992, 0, 20);
        Date resume = cal.getTime();

        cal.set(2005, 3, 10);
        Date death = cal.getTime();

        Timed timed = new Timed();
        timed.setStartTime(birth);
        timed.addPauseTime(pause);
        timed.addResumeTime(resume);
        timed.setFinishTime(death);
        
        
        Notification.show("Timed Object :: " + timed.getStartTime() + " :: " + timed.getFinishedTime());
        //timeline.addTimed(timed);
    }

}
