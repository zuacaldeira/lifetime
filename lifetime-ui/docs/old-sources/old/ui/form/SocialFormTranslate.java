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
import lifetime.business.persistence.Social;
import old.ui.list.LifetimeList;

/**
 *
 * @author lifetime
 */
public class SocialFormTranslate extends AchievementFormTranslate<Social> {

    public SocialFormTranslate(Social social, String language, LifetimeList<Social> list) {
        super(new SocialFormEdit(social, list), new SocialFormEdit(getTranslation(social, language), list));
    }

    private static Social getTranslation(Social original, String language) {
        Social social = new Social();
        social.setUserId(original.getUserId());
        social.setLanguage(language);
        if(original.getOriginalId() != null) {
            social.setOriginalId(original);
        }
        else {
            social.setOriginalId(original);
        }
        social.setStart(original.getStart());
        social.setEnd(original.getEnd());
        social.setStatus(original.getStatus());
        return social;
    }
    
    @Override
    protected void commitData() {
        Social social = (Social) getTranslation().getData();
        social.setCreatedAt(new Date());
        ServiceLocator.findLifetimeService().add(social);
    }
}
