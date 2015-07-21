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

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button.ClickListener;
import ui.LifetimeUI;
import old.ui.list.CoverLetterList;

/**
 *
 * @author lifetime
 */
public class ViewCoverLettersButton extends LifetimeButtonLink implements ClickListener{
    private final Integer userId;
    private final String language;

    public ViewCoverLettersButton(Integer userId, String language) {
        super("View Cover Letters", FontAwesome.EYE);
        this.userId = userId;
        this.language = language;
        addClickListener(this);
    }

    @Override
    public void buttonClick(ClickEvent event) {
        CoverLetterList list = new CoverLetterList(userId, language);
        //((LifetimeUI) getUI()).getDesk().addTab(list, "Cover Letters");
    }
}
