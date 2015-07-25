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
package lifetime.util;

import com.vaadin.data.util.IndexedContainer;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author lifetime
 */
public class AllLanguagesDataContainer extends IndexedContainer {

    private final String language;

    public AllLanguagesDataContainer(String language) {
        super(getLanguages(Locale.getAvailableLocales()));
        this.language = language;
    }

    private static List<String> getLanguages(Locale[] locales) {
        List<String> ll = new LinkedList();

        for (Locale l : locales) {
            ll.add(getInternalName(l));
        }

        return ll;
    }

    private static String getInternalName(Locale l) {
        return l.getDisplayLanguage(l);
    }

    /**
     * Return the current language for the current object.
     *
     * @return The two-letters language name
     */
    public String getLanguage() {
        return language;
    }

}
