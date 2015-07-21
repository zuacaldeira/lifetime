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
import old.util.ServiceLocator;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lifetime.business.persistence.MissingTranslation;
import old.translation.TranslationCard;
import old.util.Translator;

/**
 *
 * @author lifetime
 */
public class MissingTranslationsView extends HorizontalLayout implements Button.ClickListener {

    private Map<Button, TranslationCard> taskMap;
    private final VerticalLayout tasks;
    private final Integer userId;
    private final String language;

    public MissingTranslationsView(final Integer userId, String language) {
        super();
        taskMap = new HashMap();
        this.userId = userId;
        this.language = language;
        setSizeFull();
        setSpacing(true);
        //setMargin(true);
        List<MissingTranslation> list = ServiceLocator.findLifetimeService().getMissingTranslations(userId, language);
        //
        String m = Translator.getTranslation(
                "You can contribute to our platform translating some words into your mother language", language);
        String message = "<h3>" + m + "</h3>";
        LifetimeLabel label = new LifetimeLabel(message, language, ContentMode.HTML);

        //
        tasks = new VerticalLayout();
        //tasks.setSizeFull();
        tasks.setMargin(true);
        for (final MissingTranslation mt : list) {
            System.out.println(">>>" + mt.getOrigin());
            System.out.println("<<<" + mt.getTarget());
            TranslationCard tCard = new TranslationCard(userId, mt.getWord(), mt.getOrigin(), mt.getTarget());
            tCard.setSizeFull();
            tCard.getTranslate().addClickListener(this);
            tasks.addComponent(tCard);
            taskMap.put(tCard.getTranslate(), tCard);
        }

        Panel p = new Panel(tasks);
        p.setSizeFull();
        addComponents(label, p);
        setExpandRatio(label, .3f);
        setExpandRatio(p, .7f);
        setComponentAlignment(label, Alignment.MIDDLE_CENTER);
        setComponentAlignment(p, Alignment.MIDDLE_CENTER);
        setStyleName("a-list");
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        TranslationCard tCard = taskMap.remove(event);
        //Notification.show("TCARD - " + tCard);

        String word = tCard.getOriginal().getLword().getValue();
        //Notification.show("Original - " + tCard.getOriginal());
        //Notification.show("Original language - " + tCard.getOriginal().getLlanguage());

        String from = tCard.getOriginal().getLlanguage().getValue();
        Notification.show("from - " + from);

        String to = tCard.getTranslation().getLanguage().getValue();
        Notification.show("to - " + to);
        String value = tCard.getTranslation().getWord().getValue();

        Notification.show("value - " + value);

        ServiceLocator.findLifetimeService().addTranslation(userId, word, from, to, value);
        tasks.removeComponent(tCard);
    }

}
