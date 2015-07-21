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

import old.util.ServiceLocator;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import old.util.Translator;

/**
 *
 * @author lifetime
 */
public class CommentButton extends LifetimeButtonLink implements ClickListener {
    private Window window;
    private final Integer userId;
    private final String language;
    private final String caption;

    public CommentButton(Integer userId, String language) {
        super(Translator.getTranslation("Leave a Comment", language), FontAwesome.COMMENT);
        this.caption = Translator.getTranslation("Leave a Comment", language);
        this.userId = userId;
        this.language = language;
        addClickListener(this);
        setDescription(caption);
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final TextArea text = new TextArea(
                Translator.getTranslation("Leave us a comment, suggestion or critics. ", language));
        text.setSizeFull();
        LifetimeButtonLink go = new LifetimeButtonLink(Translator.getTranslation("Send", language), FontAwesome.SEND);
        go.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                String message = text.getValue();
                ServiceLocator.findLifetimeService().addComment(userId, message, language);
                if(ServiceLocator.findLifetimeService().sendMail("vitaelifetime@gmail.com","New User Comment", message)) {
                    Notification.show(Translator.getTranslation("Email sent! Thanks for helping us improve.", language), Notification.Type.TRAY_NOTIFICATION);
                }
                window.close();
            }
        });
        
        window = new Window(Translator.getTranslation("Your opinion counts!", language), new VerticalLayout(text, go));
        window.center();
        window.setModal(true);
        window.setStyleName("window");
        window.addCloseListener(new Window.CloseListener() {

            @Override
            public void windowClose(Window.CloseEvent e) {
                window.close();
            }
        });
        
        getUI().addWindow(window);
    }
    
}
