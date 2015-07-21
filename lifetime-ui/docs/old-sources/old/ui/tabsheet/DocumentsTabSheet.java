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
package old.ui.tabsheet;

import old.util.ServiceLocator;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import lifetime.business.persistence.Achievement;
import lifetime.business.persistence.Certificate;
import lifetime.business.persistence.User;

/**
 *
 * @author lifetime
 */
public class DocumentsTabSheet extends TabSheet {

    private final Integer userId;
    private final String language;

    public DocumentsTabSheet(Integer userId, String language) {
        this.userId = userId;
        this.language = language;
        addDocuments();
        setSizeFull();
    }

    private void addDocuments() {
        List<? extends Achievement> achievements = ServiceLocator.findLifetimeService().getAchievements(userId, language);
        for (Achievement a : achievements) {
            List<Certificate> certificates = ServiceLocator.findLifetimeService().getCertificates(a.getId());
            for (Certificate c : certificates) {
                addTab(getView(c), String.valueOf(c.getAchievementId()));
            }
        }
    }

    private Component getView(final Certificate c) {
        BrowserFrame pdf = new BrowserFrame("", new StreamResource(new StreamResource.StreamSource() {

            @Override
            public InputStream getStream() {
                return new ByteArrayInputStream(c.getImage());
            }
        }, "cert" + "_" + c.getAchievementId() + ".pdf"));

        pdf.setSizeFull();
        
        VerticalLayout layout = new VerticalLayout(pdf);
        layout.setSizeFull();

        Panel p = new Panel(layout);
        return pdf;
    }

    private String getUsername(Integer userId) {
        User u = ServiceLocator.findLifetimeService().getUser(userId);
        return u.getUsername();
    }

}
