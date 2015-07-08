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
import java.util.Date;
import lifetime.business.persistence.Entrepeneurship;
import old.ui.list.LifetimeList;

/**
 *
 * @author lifetime
 */
public class EntrepeneurshipFormTranslate extends AchievementFormTranslate {

    public EntrepeneurshipFormTranslate(Entrepeneurship project, String language, LifetimeList<Entrepeneurship> list) {
        super(new EntrepeneurshipFormEdit(project, list), 
                new EntrepeneurshipFormEdit(getTranslation(project, language), list));
    }
    
    private static Entrepeneurship getTranslation(Entrepeneurship original, String language) {
        Entrepeneurship project = new Entrepeneurship();
        project.setUserId(original.getUserId());
        project.setLanguage(language);
        if(original.getOriginalId() != null) {
            project.setOriginalId(original.getOriginalId());
        }
        else {
            project.setOriginalId(original);
        }
        project.setStart(original.getStart());
        project.setEnd(original.getEnd());
        project.setStatus(original.getStatus());
        return project;
    }
    
    @Override
    protected void commitData() {
        Entrepeneurship entrepeneurship = (Entrepeneurship) getTranslation().getItem();
        entrepeneurship.setCreatedAt(new Date());
        ServiceLocator.findLifetimeService().add(entrepeneurship);
    }
}
