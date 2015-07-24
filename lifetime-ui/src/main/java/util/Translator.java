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
package util;

import java.util.Locale;

/**
 * Client side facade class to access translation services.
 *
 * @author lifetime
 */
public class Translator {

    public static final String SYSTEM_LANGUAGE = Locale.ENGLISH.getLanguage();

    /**
     * Private default constructor disallows direct instantiation of this
     * utility class.
     */
    private Translator() {

    }

    /**
     * Translates a word to another language.
     *
     * @param word The word we want to translate
     * @param to the target language we are translating to
     *
     * @return The translated word, or the same if there is no translation
     */
    public static String getTranslation(String word, String to) {
        if("en".equals(to)) {
            return word;
        }
        else {
            return word;
        }
    }
}
