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
package old.pdf;

import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import old.util.Translator;

/**
 *
 * @author lifetime
 */
public class LifetimePhrase extends Phrase {
    public LifetimePhrase(String key, String language, Font font) {
        super(Translator.getTranslation(key, language), font);
    }    
}
