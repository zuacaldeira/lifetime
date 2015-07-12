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
import lifetime.business.persistence.Academic;
import old.ui.list.LifetimeList;

/**
 *
 * @author lifetime
 */
public class AcademicFormTranslate extends AchievementFormTranslate<Academic> {

    public AcademicFormTranslate(Academic academic, String language, LifetimeList<Academic> list) {
        super(new AcademicFormEdit(academic, list), new AcademicFormEdit(getTranslation(academic, language), list));
        getTranslation().getSave().addClickListener(this);
    }

    private static Academic getTranslation(Academic original, String language) {
        Academic academic = new Academic();
        academic.setLanguage(language);
        academic.setUserId(original.getUserId());
        if(original.getOriginalId() != null) {
            academic.setOriginalId(original.getOriginalId());
        }
        else {
            academic.setOriginalId(original);
        }
        academic.setStart(original.getStart());
        academic.setEnd(original.getEnd());
        academic.setStatus(original.getStatus());
        academic.setGrade(original.getGrade());
        return academic;
    }

    @Override
    protected void commitData() {
        Academic academic = (Academic) getTranslation().getData();
        academic.setCreatedAt(new Date());
        ServiceLocator.findLifetimeService().add(academic);
    }

}