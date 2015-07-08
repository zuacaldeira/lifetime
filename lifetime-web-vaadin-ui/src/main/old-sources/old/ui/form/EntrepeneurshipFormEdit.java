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
import lifetime.business.persistence.Entrepeneurship;
import lifetime.business.persistence.Organization;
import lifetime.business.persistence.Position;
import lifetime.business.persistence.Project;
import old.ui.list.LifetimeList;

/**
 *
 * @author lifetime
 */
public class EntrepeneurshipFormEdit extends LifetimeForm<Entrepeneurship> { 
    public EntrepeneurshipFormEdit(Entrepeneurship project, LifetimeList<Entrepeneurship> list) {
        super(project.getUserId(), project.getLanguage(), project, list);
        addProject(project.getProject());
        addPosition(project.getPosition());
        addOrganization(project.getOrganization());
        addDescription(project.getDescription());
        addStart(project.getStart());
        addEnd(project.getEnd());
    }

    @Override
    public void fillItem() {
        Project proj = getProject().getValue();
        if (proj != null && !proj.equals(getItem().getProject())) {
            getItem().setProject(proj);
        }
        Position pos = getPosition().getValue();
        if (pos != null && !pos.equals(getItem().getPosition())) {
            getItem().setPosition(pos);
        }
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
    public Entrepeneurship getItem() {
        return super.getItem();
    }

    @Override
    protected void commitItem() {
        ServiceLocator.findLifetimeService().update(getItem());
    }     
}
