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

import old.util.AchievementComparator;
import old.ui.combo.LifetimeCVTypeChooser;
import old.ui.textField.LifetimeDateField;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import java.util.Date;

/**
 *
 * @author lifetime
 */
public class CVConfigForm extends FormLayout {
    private final Integer userId;
    private final String language;
    private final LifetimeCVTypeChooser cvType;
    private AchievementComparator comparator;
    private final LifetimeDateField startDate;
    private final LifetimeDateField endDate;

    public CVConfigForm(Integer userId, String language) {
        this.userId = userId;
        this.language = language;
        cvType = new LifetimeCVTypeChooser(userId, language);
        //cvType.addValueChangeListener(this);        
        startDate = new LifetimeDateField("Start date", language);
        endDate = new LifetimeDateField("End date", language);
        endDate.setValue(new Date());
        addComponents(cvType, new HorizontalLayout(startDate, endDate));
    }

    public DateField getStartDate() {
        return startDate;
    }
    
    public DateField getEndDate() {
        return endDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getLanguage() {
        return language;
    }

    public LifetimeCVTypeChooser getCvType() {
        return cvType;
    }

    public AchievementComparator getComparator() {
        return comparator;
    }

    public void setComparator(AchievementComparator comparator) {
        this.comparator = comparator;
    }

    
    
}
