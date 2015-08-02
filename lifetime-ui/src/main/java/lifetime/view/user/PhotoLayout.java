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
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
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
    }

    @Override
    public OutputStream receiveUpload(String filename, String mimeType) {
        return baos;
    }

    @Override
    public void uploadSucceeded(Upload.SucceededEvent event) {
        try {
            baos.close();
            ServiceLocator.findLifetimeAccountService().addPhoto(username, baos.toByteArray());
            showPhoto();
        } catch (IOException ex) {
            Logger.getLogger(UserContent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showPhoto() {
        clean();
        Photo userPhoto = ServiceLocator.findLifetimeAccountService().getPhoto(username);
        if (userPhoto != null) {
            addPhoto(userPhoto);
        }
        addUpload();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PhotoLayout)) {
            return false;
        }
        final PhotoLayout other = (PhotoLayout) obj;
        return Objects.equals(this.username, other.username);
    }

    @Override
    public void attach() {
        super.attach();
        showPhoto();
    }

    private void clean() {
        root.removeAllComponents();
    }

    private void addPhoto(Photo userPhoto) {
        Image image = new Image("", getPhotoResource(userPhoto));
        image.setWidth("50%");
        root.addComponent(image);
    }

    private void addUpload() {
        // Upload layout
        Upload upload = new Upload("Add your favourite photo", this);
        upload.addSucceededListener(this);
        upload.setImmediate(true);
        root.addComponent(upload);
    }

    private Resource getPhotoResource(final Photo p) {
        return new StreamResource(new StreamResource.StreamSource() {
            @Override
            public InputStream getStream() {
                return new ByteArrayInputStream(p.getImage());
            }
        }, "photo-" + username + "-" + Math.random());
    }

}
