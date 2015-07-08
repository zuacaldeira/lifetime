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
import lifetime.business.persistence.Linguistic;
import old.ui.list.LifetimeList;

/**
 *
 * @author lifetime
 */
public class LinguisticFormTranslate extends AchievementFormTranslate<Linguistic> {

    public LinguisticFormTranslate(Linguistic linguistic, String language, LifetimeList<Linguistic> list) {
        super(new LinguisticFormEdit(linguistic, list), new LinguisticFormEdit(getTranslation(linguistic, language), list));
    }

    private static Linguistic getTranslation(Linguistic original, String language) {
        Linguistic linguistic = new Linguistic();
        linguistic.setUserId(original.getUserId());
        linguistic.setLanguage(language);
        if(original.getOriginalId() != null) {
            linguistic.setOriginalId(original.getOriginalId());
        }
        else {
            linguistic.setOriginalId(original);
        }
        linguistic.setStart(original.getStart());
        linguistic.setEnd(original.getEnd());
        linguistic.setStatus(original.getStatus());
        return linguistic;
    }

    @Override
    protected void commitData() {
        Linguistic linguistic = (Linguistic) getTranslation().getData();
        linguistic.setCreatedAt(new Date());
        ServiceLocator.findLifetimeService().add(linguistic);
    }
}
