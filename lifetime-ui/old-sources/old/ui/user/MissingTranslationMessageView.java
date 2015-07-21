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
package old.ui.user;

import old.ui.label.LifetimeLabel;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.VerticalLayout;
import old.util.Translator;

/**
 *
 * @author lifetime
 */
public class MissingTranslationMessageView extends VerticalLayout {
    
    private static  String message;
    
    public MissingTranslationMessageView(String language) {
        setMargin(true);
        setWidth("75%");
        setHeightUndefined();
        //setComponentAlignment(label, Alignment.BOTTOM_CENTER);
        setStyleName("message");
    }
    
}
