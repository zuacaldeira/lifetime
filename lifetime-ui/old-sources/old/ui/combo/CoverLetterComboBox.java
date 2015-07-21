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
package old.ui.combo;

import lifetime.business.persistence.CoverLetter;
import old.ui.data.CoverLetterDataContainer;

/**
 *
 * @author lifetime
 */
public class CoverLetterComboBox extends LifetimeComboBox {

    public CoverLetterComboBox(final String language) {
        super("Cover Letter", language, new CoverLetterDataContainer(language));
        setNewItemsAllowed(false);
        setImmediate(true);
        setRequired(true);
    }

    @Override
    public CoverLetter getValue() {
        return (CoverLetter) super.getValue(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
