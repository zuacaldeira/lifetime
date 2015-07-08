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
package old.ui.receiver;

import old.util.ServiceLocator;
import com.vaadin.server.Page;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import old.ui.user.UserUI;

/**
 *
 * @author lifetime
 */
public class PhotoUploadReceiver extends UploadReceiver implements Upload.SucceededListener {

    public PhotoUploadReceiver(Integer userId, String language) {
        super(userId, language);
    }

    @Override
    public void uploadSucceeded(Upload.SucceededEvent event) {
        ServiceLocator.findLifetimeService().addUserPhoto(super.getUserId(), super.getBaos().toByteArray());
        ((UserUI) super.getWindow().getUI()).getBackground().setSource(new StreamResource(
                new StreamResource.StreamSource() {

                    @Override
                    public InputStream getStream() {
                        return new ByteArrayInputStream(getBaos().toByteArray());
                    }
                }, event.getFilename()+"_"+getUserId()));
                
        super.getWindow().close();
        Notification.show("Upload succeeded", Notification.Type.TRAY_NOTIFICATION);
        Page.getCurrent().reload();
    }
}
