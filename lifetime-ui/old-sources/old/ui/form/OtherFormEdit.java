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

import lifetime.business.persistence.Organization;
import old.util.ServiceLocator;
import lifetime.business.persistence.Other;
import old.ui.list.LifetimeList;

/**
 *
 * @author lifetime
 */
public class OtherFormEdit extends LifetimeForm<Other> {

    public OtherFormEdit(Other other, LifetimeList<Other> list) {
        super(other.getUserId(), other.getLanguage(), other, list);
        addTitle(other.getTitle());
        addOrganization(other.getOrganization());
        addDescription(other.getDescription());
        addStart(other.getStart());
        addEnd(other.getEnd());
    }

    @Override
    public void fillItem() {
        String l = getTitle().getValue();
        if (!l.equals(getItem().getTitle())) {
            getItem().setTitle(l);
        }
        /*Integer g = Integer.valueOf(extractValue(getGrade()));
         if (!g.equals(getAchievement().getGrade())) {
         getAchievement().setGrade(g);
         }*/
        Organization o = getOrganization().getValue();
        if (o != null && !o.equals(getItem().getOrganization())) {
            getItem().setOrganization(o);
        }
        String ds = getDesc().getValue();
        if (!ds.equals(getItem().getDescription())) {
            getItem().setDescription(ds);
        }
        getItem().setStart(getStart().getValue());
        getItem().setEnd(getEnd().getValue());
    }

    @Override
    public Other getItem() {
        return super.getItem();
    }

    @Override
    protected void commitItem() {
        ServiceLocator.findLifetimeService().update(getItem());
    }
}
