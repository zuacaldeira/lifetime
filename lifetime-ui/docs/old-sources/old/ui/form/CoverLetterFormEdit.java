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
import lifetime.business.persistence.CoverLetter;
import old.ui.list.LifetimeList;

/**
 *
 * @author lifetime
 */
public class CoverLetterFormEdit extends LifetimeForm<CoverLetter> {

    public CoverLetterFormEdit(CoverLetter letter, LifetimeList<CoverLetter> list) {
        super(letter.getUserId(), letter.getLanguage(), letter, list);
        super.addLanguage(letter.getLanguage());
        super.addIntroduction(letter.getIntroduction());
        super.addWhyMe(letter.getWhyMe());
        super.addWhyYou(letter.getWhyYou());
        super.addConclusion(letter.getConclusion());
    }

    @Override
    public void fillItem() {
        CoverLetter t = getItem();
        t.setIntroduction(getIntroduction().getValue());
        t.setWhyMe(getWhyMe().getValue());
        t.setWhyYou(getWhyYou().getValue());
        t.setConclusion(getConclusion().getValue());
        t.setLanguage(getLanguageComboBox().getValue());
    }

    @Override
    protected void commitItem() {
        ServiceLocator.findLifetimeService().update(getItem());
    }


}
