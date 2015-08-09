/*
 * Copyright 2015 zua.
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
package lifetime.view.user;

import com.vaadin.data.Item;
import com.vaadin.data.Item.PropertySetChangeListener;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import java.util.Date;
import lifetime.backend.persistence.User;
import lifetime.util.StyleClassName;

/**
 *
 * @author zua
 */
public class PersonalInfoLayout extends AbsoluteLayout implements PropertySetChangeListener {

    private final String FIRST_NAMES = "firstnames";
    private final String SURNAMES = "surnames";
    private final String BIRTH_DATE = "birthDate";
    private final String BIRTH_PLACE = "birthPlace";
    private final String MOTHER_LANGUAGE = "motherLanguage";
    private final User user;
    private PropertysetItem item;
    private EditableLabelLayout firstNamesLabel;
    private EditableLabelLayout lastNamesLabel;
    private EditableLabelLayout birthDateLabel;
    private EditableLabelLayout birthPlaceLabel;
    private EditableLabelLayout motherLanguageLabel;
    private Embedded background;

    public PersonalInfoLayout(User user) {
        this.user = user;
        setSizeFull();
        setStyleName(StyleClassName.PERSONAL_INFO_LAYOUT.getStyleName());
        setId(StyleClassName.PERSONAL_INFO_LAYOUT.getStyleName());
        initData();
    }

    private void initData() {
        // init property set item
        initPropertysetItem();
        initLabels();
        showLabels();
    }

    private void initPropertysetItem() {
        item = new PropertysetItem();
        item.addPropertySetChangeListener(this);
        item.addItemProperty(FIRST_NAMES, new ObjectProperty(user.getFirstname(), String.class));
        item.addItemProperty(SURNAMES, new ObjectProperty(user.getLastname(), String.class));
        item.addItemProperty(BIRTH_DATE, new ObjectProperty(user.getBirthDate(), Date.class));
        item.addItemProperty(BIRTH_PLACE, new ObjectProperty(user.getBirthPlace(), String.class));
        item.addItemProperty(MOTHER_LANGUAGE, new ObjectProperty(user.getLanguage(), String.class));
    }

    private void initLabels() {
        firstNamesLabel = new EditableLabelLayout(new Label(item.getItemProperty(FIRST_NAMES)));
        lastNamesLabel = new EditableLabelLayout(new Label(item.getItemProperty(SURNAMES)));
        birthDateLabel = new EditableLabelLayout(new Label(item.getItemProperty(BIRTH_DATE)));
        birthPlaceLabel = new EditableLabelLayout(new Label(item.getItemProperty(BIRTH_PLACE)));
        motherLanguageLabel = new EditableLabelLayout(new Label(item.getItemProperty(MOTHER_LANGUAGE)));
    }

    private void showLabels() {
        /*addComponents(firstNamesLabel, lastNamesLabel, birthDateLabel, birthPlaceLabel, motherLanguageLabel);
        ComponentPosition topLeft = new ComponentPosition();
        topLeft.setCSSString("top:0px; left:0px");
        setPosition(firstNamesLabel, topLeft);

        ComponentPosition topRight = new ComponentPosition();
        topRight.setCSSString("top:0px; right:0px");
        setPosition(lastNamesLabel, topRight);

        ComponentPosition bottomLeft = new ComponentPosition();
        bottomLeft.setCSSString("bottom:0px; left:0px");
        setPosition(birthDateLabel, bottomLeft);

        ComponentPosition bottomRight = new ComponentPosition();
        bottomRight.setCSSString("bottom:0px; right:0px");
        setPosition(birthPlaceLabel, bottomRight);*/
    }

    @Override
    public void itemPropertySetChange(Item.PropertySetChangeEvent event) {
        lifetime.util.ServiceLocator.findLifetimeAccountService().update(user);
    }

}
