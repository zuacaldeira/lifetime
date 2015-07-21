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
package old.ui.helper;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import old.util.Translator;

/**
 *
 * @author lifetime
 */
public class DataLayout extends HorizontalLayout {
    private final String language;
    private final SimpleDateFormat df;
    private PairView birth;
    private PairView name;
    private Object user;
    private final PairView email;
    
    public DataLayout(String language, String name, String email, Date birthdate) {
        this.language = language;
        setWidth("100%");
        df = new SimpleDateFormat("dd MMMM yyyy", new Locale(language));
        birth = null;
        String bText = Translator.getTranslation("Since", language);
        String uText = Translator.getTranslation("Unknown", language);
        
        if(birthdate != null) {
            birth = new PairView(bText, df.format(birthdate), language);
        } else {
            birth = new PairView(bText, uText, language);
        }
        String nText = Translator.getTranslation("Name", language);
        String eText = Translator.getTranslation("Email", language);
        this.name = new PairView(nText, name, language);
        this.email = new PairView(eText, email, language);


        addComponents(this.email, this.name, this.birth);
        setComponentAlignment(this.birth, Alignment.MIDDLE_CENTER);
        setComponentAlignment(this.name, Alignment.MIDDLE_CENTER);
        setComponentAlignment(this.email, Alignment.MIDDLE_CENTER);
        setStyleName("personal-data");
    }

    public String getLanguage() {
        return language;
    }
    
    
}
