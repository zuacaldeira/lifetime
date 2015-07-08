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
package old.ui.list;

import old.ui.item.AcademicItemView;
import old.ui.item.ItemView;
import old.util.ServiceLocator;
import old.ui.item.CertificationItemView;
import old.ui.item.LinguisticItemView;
import old.ui.item.ProfessionalItemView;
import old.ui.item.EntrepeneurshipItemView;
import old.ui.item.SocialItemView;
import old.ui.item.OtherItemView;
import java.util.List;
import lifetime.business.persistence.Academic;
import lifetime.business.persistence.Achievement;
import lifetime.business.persistence.Certification;
import lifetime.business.persistence.Linguistic;
import lifetime.business.persistence.Professional;
import lifetime.business.persistence.Entrepeneurship;
import lifetime.business.persistence.Social;
import lifetime.business.persistence.Other;
import old.ui.form.LifetimeForm;

/**
 *
 * @author lifetime
 */
public class AllAchievementList extends LifetimeList<Achievement> {

    public AllAchievementList(Integer userId, String language) {
        super(userId, language);
        super.hideAddButton();
    }

    @Override
    protected ItemView getItemView(Achievement achievement) {
        if(achievement instanceof Academic) {
            return new AcademicItemView((Academic) achievement);
        }
        if(achievement instanceof Professional) {
            return new ProfessionalItemView((Professional) achievement);
        }
        if(achievement instanceof Certification) {
            return new CertificationItemView((Certification) achievement);
        }
        if(achievement instanceof Linguistic) {
            return new LinguisticItemView((Linguistic) achievement);
        }
        if(achievement instanceof Social) {
            return new SocialItemView((Social) achievement);
        }
        if(achievement instanceof Other) {
            return new OtherItemView((Other) achievement);
        }
        if(achievement instanceof Entrepeneurship) {
            return new EntrepeneurshipItemView((Entrepeneurship) achievement);
        }
        else {
            throw new IllegalArgumentException("Unkown item view type for class " + achievement.getClass().getSimpleName());
        }
    }

    /**
     *
     * @return
     */
    @Override
    protected List<Achievement> getDataFromServer() {
        return ServiceLocator.findLifetimeService().getAchievements(getUserId(), getLanguage());
    }

    @Override
    protected LifetimeForm<Achievement> getFormNew() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
