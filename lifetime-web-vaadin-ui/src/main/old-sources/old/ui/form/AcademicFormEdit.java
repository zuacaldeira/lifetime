/*
 * Copyright 2015 lifetime.
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
package old.ui.form;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import old.util.ServiceLocator;
import lifetime.business.persistence.Academic;
import lifetime.business.persistence.Course;
import lifetime.business.persistence.Degree;
import lifetime.business.persistence.Organization;
import old.ui.list.LifetimeList;

/**
 *
 * @author lifetime
 */
public class AcademicFormEdit extends LifetimeForm<Academic> {

    public AcademicFormEdit(Academic achievement, LifetimeList<Academic> list) {
        super(achievement.getUserId(), achievement.getLanguage(), achievement, list);
        addDegree(achievement.getDegree());
        getDegree().setRequired(false);
        addCourse(achievement.getCourse());
        Notification.show(String.valueOf(achievement.getOrganization()), Type.ERROR_MESSAGE);
        addOrganization(achievement.getOrganization());
        Notification.show(String.valueOf(achievement.getLanguage()), Type.ERROR_MESSAGE);
        Notification.show(String.valueOf(achievement.getStart()), Type.ERROR_MESSAGE);
        addStart(achievement.getStart());
        addEnd(achievement.getEnd());
    }

    @Override
    public void fillItem() {
        Degree d = getDegree().getValue();
        if (d != null && !d.equals(getItem().getDegree())) {
            getItem().setDegree(d);
        }

        Course c = getCourse().getValue();
        if (c
                != null && !c.equals(getItem().getCourse())) {
            getItem().setCourse(c);
        }

        Organization o = getOrganization().getValue();
        if (o
                != null && !o.equals(getItem().getOrganization())) {
            getItem().setOrganization(o);
        }

        getItem().setStart(getStart().getValue());
        getItem().setEnd(getEnd().getValue());
    }

    @Override
    public Academic getItem() {
        return super.getItem();
    }

    @Override
    protected void commitItem() {
        ServiceLocator.findLifetimeService().update(getItem());
    }

}
