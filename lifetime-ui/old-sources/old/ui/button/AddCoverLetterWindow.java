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
package old.ui.button;

import lifetime.business.persistence.CoverLetter;
import old.ui.form.CoverLetterForm;
import old.ui.list.CoverLetterList;
import old.ui.window.LifetimeWindow;

/**
 *
 * @author lifetime
 */
class AddCoverLetterWindow extends LifetimeWindow {
    private final CoverLetterForm form;

    public AddCoverLetterWindow(Integer userId, String language, CoverLetterList list) {
        super(userId, language, "New Cover Letter");
        CoverLetter letter = new CoverLetter();
        letter.setLanguage(language);
        form = new CoverLetterForm(userId, language, letter, list);
        setContent(form);
    }
    
}
