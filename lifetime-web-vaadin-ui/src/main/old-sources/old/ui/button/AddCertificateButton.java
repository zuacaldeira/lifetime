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

import old.util.Translator;
import old.ui.receiver.UploadReceiver;
import old.ui.receiver.CertificateUploadReceiver;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Window;
import lifetime.business.persistence.Achievement;

/**
 *
 * @author lifetime
 */
public class AddCertificateButton extends LifetimeButtonLink {

    public AddCertificateButton(final Integer userId, final String language, final Achievement a) {
        super(Translator.getTranslation("Add Certificate", language), FontAwesome.CERTIFICATE);
        setDescription(Translator.getTranslation("Add Certificate", language));
        addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                UploadReceiver receiver = new CertificateUploadReceiver(userId, language, a);
                Upload upload = new Upload(Translator.getTranslation("Add Certificate", language), receiver);
                upload.addSucceededListener(receiver);

                String wcaption = Translator.getTranslation("Upload", language);
                final Window window = new Window(wcaption, upload);
                window.center();
                //window.setModal(true);
                window.setStyleName("window");
                receiver.setWindow(window);
                window.addCloseListener(new Window.CloseListener() {

                    @Override
                    public void windowClose(Window.CloseEvent e) {
                        window.close();
                    }
                });
                getUI().addWindow(window);
            }
        });
    }

}
