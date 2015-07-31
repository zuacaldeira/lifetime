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
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import lifetime.persistence.Photo;
import lifetime.util.ServiceLocator;

/**
 *
 * @author zua
 */
public class PhotoLayout extends CustomComponent implements Upload.Receiver, Upload.SucceededListener {

    private final String username;
    private transient ByteArrayOutputStream baos;
    private VerticalLayout root;

    public PhotoLayout(String username) {
        this.username = username;
        baos = new ByteArrayOutputStream();
        root = new VerticalLayout();
        setCompositionRoot(root);
        showPhoto();
    }

    private Resource getPhotoResource(final Photo p) {
        return new StreamResource(new StreamResource.StreamSource() {
            @Override
            public InputStream getStream() {
                return new ByteArrayInputStream(p.getImage());
            }
        }, "photo-" + username + "-" + Math.random());
    }

    @Override
    public OutputStream receiveUpload(String filename, String mimeType) {
        Notification.show("Received Upload: " + filename, Notification.Type.ASSISTIVE_NOTIFICATION);
        return baos;
    }

    @Override
    public void uploadSucceeded(Upload.SucceededEvent event) {
        try {
            baos.close();
            Notification.show("Upload Succeeded: " + baos.toByteArray());
            ServiceLocator.findLifetimeAccountService().addPhoto(username, baos.toByteArray());
            Notification.show("Image saved in db");
            showPhoto();
        } catch (IOException ex) {
            Logger.getLogger(UserContent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showPhoto() {
        root.removeAllComponents();
        // Image layout
        Image image = null;
        Photo userPhoto = ServiceLocator.findLifetimeAccountService().getPhoto(username);

        if (userPhoto != null) {
            image = new Image("", getPhotoResource(userPhoto));
            image.setWidth("50%");
            root.addComponent(image);
        }
        // Upload layout
        Upload upload = new Upload("Add your favourite photo", this);
        upload.addSucceededListener(this);
        upload.setImmediate(true);
        root.addComponent(upload);
        // Add composite component to the composition root
    }

}
