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
package old.ui.wizard;

import com.vaadin.server.StreamResource;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lifetime.business.persistence.User;
import old.util.ServiceLocator;

/**
 *
 * @author lifetime
 */
public class PdfLayout extends VerticalLayout {

    private final Integer userId;
    private final String language;

    public PdfLayout(Integer userId, String language) {
        this.userId = userId;
        this.language = language;
        setSizeFull();
    }

    public Integer getUserId() {
        return userId;
    }

    public String getLanguage() {
        return language;
    }

    public void addPdf(byte[] bytes) {
        removeAllComponents();
        addComponent(getView(bytes));
    }

    private Component getView(final byte[] bytes) {
        BrowserFrame pdf = new BrowserFrame("", new StreamResource(new StreamResource.StreamSource() {

            @Override
            public InputStream getStream() {
                return new ByteArrayInputStream(bytes);
            }
        }, "cv" + "_" + getUsername() + ".pdf"));

        pdf.setSizeFull();

        VerticalLayout layout = new VerticalLayout(pdf);
        layout.setSizeFull();

        Panel p = new Panel(layout);
        return pdf;
    }

    private String getUsername() {
        User u = ServiceLocator.findLifetimeService().getUser(userId);
        return u.getUsername();
    }

}
