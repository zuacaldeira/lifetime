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

import java.util.Date;
import java.util.List;
import lifetime.business.persistence.CoverLetter;
import old.ui.form.CoverLetterForm;
import old.ui.form.LifetimeForm;
import old.ui.item.CoverLetterInfoView;
import old.ui.item.ItemView;
import old.util.ServiceLocator;

/**
 *
 * @author lifetime
 */
public class CoverLetterList extends LifetimeList<CoverLetter> {

    public CoverLetterList(Integer userId, String language) {
        super(userId, language);
    }

    @Override
    protected ItemView getItemView(CoverLetter item) {
        ItemView result = new ItemView(new CoverLetterInfoView(getUserId(), getLanguage(), item), item.getCreatedAt(), new Date(), getLanguage()) {};
        return result;
    }

    @Override
    protected List<CoverLetter> getDataFromServer() {
        return ServiceLocator.findLifetimeService().getCoverLetters(getLanguage());
    }

    @Override
    public LifetimeForm<CoverLetter> getFormNew() {
        final CoverLetter cLetter = new CoverLetter();
        cLetter.setLanguage(getLanguage());
        return new CoverLetterForm(getUserId(), getLanguage(), cLetter, this);
    }

}
