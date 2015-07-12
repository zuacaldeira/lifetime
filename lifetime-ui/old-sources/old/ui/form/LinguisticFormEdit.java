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

import old.util.ServiceLocator;
import lifetime.business.persistence.Linguistic;
import lifetime.business.persistence.Organization;
import old.ui.list.LifetimeList;

/**
 *
 * @author lifetime
 */
public class LinguisticFormEdit extends LifetimeForm<Linguistic> { 

    public LinguisticFormEdit(Linguistic linguistic, LifetimeList<Linguistic> list) {
        super(linguistic.getUserId(), linguistic.getLanguage(), linguistic, list);
        addLinguisticSkillName(linguistic.getName());
        addReadLevel(linguistic.getLevel());
        addOrganization(linguistic.getOrganization());
        getOrganization().setRequired(false);
        addStart(linguistic.getStart());
        addEnd(linguistic.getEnd());
    }

    @Override
    public void fillItem() {
        String l = getSkills().getValue();
        if (l != null && !l.equals(getItem().getName())) {
            getItem().setName(l);
        }
        String t = getRead().getValue();
        if (t != null && !t.equals(getItem().getLevel())) {
            getItem().setLevel(t);
        }
        /*Integer g = Integer.valueOf(extractValue(getGrade()));
        if (!g.equals(getAchievement().getGrade())) {
            getAchievement().setGrade(g);
        }*/
        Organization o = getOrganization().getValue();
        if (o != null && !o.equals(getItem().getOrganization())) {
            getItem().setOrganization(o);
        }
        getItem().setStart(getStart().getValue());
        getItem().setEnd(getEnd().getValue());
    }

    @Override
    public Linguistic getItem() {
        return super.getItem();
    }

    @Override
    protected void commitItem() {
        ServiceLocator.findLifetimeService().update(getItem());
    }    
}
