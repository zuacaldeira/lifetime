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

    /*    private static String getTranslation(String word, String from, String to) {
     try {
     LifetimeBusiness service = ServiceLocator.findLifetimeService();
     Translation t = service.getTranslation(word, from, to);
     if (t != null) {
     return t.getTranslation();
     }
     return word;
     } catch(UnavailableServiceException ex) {
     return word;
     }
     }

     public static String getTranslation(String word, String to) {
     if (word == null) {
     return "null";
     }
     if (to != null && !to.equals(SYSTEM_LANGUAGE)) {
     return getTranslation(word, SYSTEM_LANGUAGE, to);
     } else {
     return word;
     }
     }
     */
    public static String getTranslation(String word, String to) {
        return word;
    }
}
