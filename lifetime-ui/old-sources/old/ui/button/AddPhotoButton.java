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
import com.vaadin.ui.Button;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Window;
import old.ui.receiver.PhotoUploadReceiver;
import old.util.Translator;
import old.ui.receiver.UploadReceiver;

/**
 *
 * @author lifetime
 */
public class AddPhotoButton extends LifetimeButtonLink {

    public AddPhotoButton(final Integer userId, final String language) {
        super(Translator.getTranslation("Add professional photo", language), FontAwesome.CAMERA_RETRO);
        setDescription(Translator.getTranslation("Add professional photo", language));
        addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                UploadReceiver receiver = new PhotoUploadReceiver(userId, language);
                Upload upload = new Upload(Translator.getTranslation("Choose your best photo", language), receiver);
                upload.addSucceededListener(receiver);

                String wcaption = Translator.getTranslation("Upload a photo", language);
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
