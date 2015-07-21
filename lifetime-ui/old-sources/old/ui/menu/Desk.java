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
package old.ui.menu;

import com.vaadin.server.FontAwesome;
import old.util.Translator;
import old.ui.tabsheet.LifetimeTabSheet;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author lifetime
 */
public class Desk extends LifetimeTabSheet {

    private final VerticalList home;
    private final Integer userId;
    private final String language;

    public Desk(Integer userId, String language) {
        this.userId = userId;
        this.language = language;
        home = new VerticalList(userId, language);
        String translation = Translator.getTranslation("Home", language);
        addTab(home, translation, FontAwesome.HOME);
        setStyleName(ValoTheme.TABSHEET_CENTERED_TABS 
                + " " + ValoTheme.TABSHEET_EQUAL_WIDTH_TABS
                + " " + ValoTheme.TABSHEET_PADDED_TABBAR);
        setSizeFull();
    }

    public void swapLights() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getUserId() {
        return userId;
    }

    public String getLanguage() {
        return language;
    }
    
    

}
