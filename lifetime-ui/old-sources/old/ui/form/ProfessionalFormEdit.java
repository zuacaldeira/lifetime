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
import lifetime.business.persistence.Position;
import old.util.ServiceLocator;
import old.ui.list.ProfessionalList;
import lifetime.business.persistence.Professional;

/**
 *
 * @author lifetime
 */
public class ProfessionalFormEdit extends LifetimeForm<Professional> { 

    public ProfessionalFormEdit(Professional professional, ProfessionalList list) {
        super(professional.getUserId(), professional.getLanguage(), professional, list);
        addPosition(professional.getPosition());
        addOrganization(professional.getOrganization());
        addDescription(professional.getDescription());
        addStart(professional.getStart());
        addEnd(professional.getEnd());
    }

    @Override
    public void fillItem() {
        Position pos = getPosition().getValue();
        if (!pos.equals(getItem().getPosition())) {
            getItem().setPosition(pos);
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
    public Professional getItem() {
        return super.getItem();
    }

    @Override
    protected void commitItem() {
        ServiceLocator.findLifetimeService().update(getItem());
    }
}
