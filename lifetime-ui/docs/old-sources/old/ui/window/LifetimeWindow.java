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
package old.ui.window;

import com.vaadin.ui.HasComponents;
import com.vaadin.ui.Window;
import old.ui.list.LifetimeList;
import old.util.Translator;

/**
 *
 * @author lifetime
 */
public class LifetimeWindow extends Window {
    private final Integer userId;
    private final String language;
    
    public LifetimeWindow(Integer userId, String language, String caption/*, Component content*/) {
        super(Translator.getTranslation(caption, language));
        this.userId = userId;
        this.language = language;
        setWidth("50%");
        setHeight("50%");
        setModal(true);
        setResizable(true);
        //setModal(true);
        addCloseListener(new Window.CloseListener() {

            @Override
            public void windowClose(Window.CloseEvent e) {
                close();
            }
        });
        setStyleName("window");
    }

    public Integer getUserId() {
        return userId;
    }

    public String getLanguage() {
        return language;
    }
    
    public LifetimeList getList() {
        HasComponents parent = this.getParent();
        while(parent != null) {
            if(parent instanceof LifetimeList) {
                return (LifetimeList) parent;
            }
            parent = parent.getParent();
        }
        return null;
    }
    
}
