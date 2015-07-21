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

import old.ui.tabsheet.UserTabSheet;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Window;
import ui.LifetimeUI;
import old.util.Translator;

/**
 *
 * @author lifetime
 */
public class ShowAchievementsButton extends LifetimeButtonLink implements Button.ClickListener {
    private final Integer userId;
    private final String language;

    public ShowAchievementsButton(Integer userId, String language) {
        super(translate("Achievement Manager", language), FontAwesome.TROPHY);
        this.userId = userId;
        this.language = language;
        addClickListener(this);
    }
    
    private static String translate(String word, String language) {
        return Translator.getTranslation(word, language);
    } 

    @Override
    public void buttonClick(ClickEvent event) {
        //showOnWindow();
        showOnDesktop();
    }

    private void showOnWindow() {
        final Window window = new Window();
        window.setWidth("95%");
        window.setHeight("95%");
        window.center();
        window.setResizable(true);
        window.setModal(true);
        window.addCloseListener(new Window.CloseListener() {

            @Override
            public void windowClose(Window.CloseEvent e) {
                window.close();
            }
        });
        window.setContent(new UserTabSheet(userId, language));
        getUI().addWindow(window);
        window.setStyleName("window");
    }

    private void showOnDesktop() {
        //((LifetimeUI)getUI()).getDesk().addTab(new UserTabSheet(userId, language), "Vitae");
    }

    
    
    
}
