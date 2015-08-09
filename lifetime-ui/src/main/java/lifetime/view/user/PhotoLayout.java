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
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Image;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Objects;
import lifetime.backend.persistence.Photo;
import lifetime.backend.service.LifetimeAccountService;
import lifetime.util.ServiceLocator;

/**
 *
 * @author <a href="mailto:zuacaldeira@gmail.com>Alexandre Caldeira</a>
 */
public class PhotoLayout extends VerticalLayout {

    private final String username;
    private PhotoReceiver receiver;
    private Image image;
    private Upload upload;
    private LifetimeAccountService service;

    public PhotoLayout(String username, String language) {
        this.username = username;
        setSizeFull();
    }

    @Override
    protected void focus() {
        super.focus(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void detach() {
        super.detach(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attach() {
        super.attach(); //To change body of generated methods, choose Tools | Templates.
        clean();
        initService();
        showPhoto();
    }

    final void showPhoto() {
        if (service != null) {
            Photo userPhoto = service.getPhoto(username);
            if (userPhoto != null) {
                addPhoto(userPhoto);
            }
            //addUpload();
        }
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

    private void clean() {
        removeAllComponents();
    }

    private void addPhoto(Photo userPhoto) {
        image = new Image("", getPhotoResource(userPhoto));
        image.setHeight("50%");
        addComponent(image);
        setComponentAlignment(image, Alignment.MIDDLE_LEFT);
    }

    private void addUpload() {
        receiver = new PhotoReceiver(username, this);
        // Upload layout
        upload = new Upload("Add your favourite photo", receiver);
        upload.addSucceededListener(receiver);
        upload.setImmediate(true);
        //upload.setWidth(image.getWidth(), image.getWidthUnits());
        addComponent(upload);
    }

    private Resource getPhotoResource(final Photo p) {
        return new StreamResource(new StreamResource.StreamSource() {
            @Override
            public InputStream getStream() {
                return new ByteArrayInputStream(p.getImage());
            }
        }, "photo-" + username + "-" + Math.random());
    }

    private void initService() {
        service = ServiceLocator.findLifetimeAccountService();
    }

}
