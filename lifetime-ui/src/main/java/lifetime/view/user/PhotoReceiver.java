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

import com.vaadin.server.Resource;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.Upload;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import lifetime.backend.persistence.Photo;
import lifetime.util.ServiceLocator;

/**
 *
 * @author zua
 */
public class PhotoReceiver implements Upload.Receiver, Upload.SucceededListener {

    private transient ByteArrayOutputStream baos;
    private final String username;
    private final ProfileView layout;

    public PhotoReceiver(String username, ProfileView layout) {
        this.username = username;
        this.layout = layout;
        this.baos = new ByteArrayOutputStream();
    }

    @Override
    public OutputStream receiveUpload(String filename, String mimeType) {
        return baos;
    }

    @Override
    public void uploadSucceeded(Upload.SucceededEvent event) {
        try {
            baos.close();
            Photo photo = new Photo(null, username, baos.toByteArray());
            ServiceLocator.findLifetimeAccountService().addPhoto(photo);
            layout.markAsDirty();
        } catch (IOException ex) {
            Logger.getLogger(UserContent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Resource getPhotoResource(final Photo p) {
        return new StreamResource(new StreamResource.StreamSource() {
            @Override
            public InputStream getStream() {
                return new ByteArrayInputStream(p.getImage());
            }
        }, "photo-" + username + "-" + Math.random());
    }

}
