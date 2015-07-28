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
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.SucceededListener;
import com.vaadin.ui.VerticalLayout;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import lifetime.persistence.Photo;
import lifetime.service.LifetimeAccountBusiness;
import lifetime.util.ServiceLocator;
import lifetime.view.LifetimeContent;
import lifetime.view.StyleClassName;

/**
 *
 * @author zua
 */
class UserContent extends LifetimeContent {

    private VerticalLayout photo;
    private VerticalLayout accountDetails;

    public UserContent(String language) {
        super(language);
        setId(StyleClassName.USER_CONTENT);
        setStyleName(StyleClassName.USER_CONTENT);
        showUserData();
        setExpandRatio(photo, .3f);
        setExpandRatio(accountDetails, .7f);
        setComponentAlignment(photo, Alignment.MIDDLE_CENTER);
        setComponentAlignment(accountDetails, Alignment.MIDDLE_CENTER);
    }

    private void showUserData() {
        showPhoto();
        showAccountDetails();
    }

    private void showPhoto() {
        Photo userPhoto = ServiceLocator.findLifetimeAccountService().getPhoto(getUsername());
        if (userPhoto != null) {
            photo = new VerticalLayout(new Image("", getPhotoResource()));
        } else {
            PhotoUploader upload = this.new PhotoUploader();
            upload.setImmediate(true);
            photo = new VerticalLayout(upload);
        }
        photo.setSizeFull();
        addComponent(photo);
    }

    private void showAccountDetails() {
        accountDetails = new VerticalLayout();
        accountDetails.setStyleName("account-details");
        accountDetails.setSizeFull();

        LifetimeAccountBusiness service = ServiceLocator.findLifetimeAccountService();
        Label name = new Label(service.getFullName(getUsername()));
        name.setStyleName("h1");

        Label education = new Label("Education");
        education.setStyleName("h3");

        Label profession = new Label("Profession");
        profession.setStyleName("h3");

        Label logos = new Label("Logos");
        logos.setStyleName("h3");

        accountDetails.addComponents(name, education, profession, logos);
        addComponent(accountDetails);
    }

    private Resource getPhotoResource() {
        return new StreamResource(new StreamResource.StreamSource() {
            @Override
            public InputStream getStream() {
                return new ByteArrayInputStream(getPhotoBytes());
            }

            private byte[] getPhotoBytes() {
                Photo p = ServiceLocator.findLifetimeAccountService().getPhoto(getUsername());
                return (p == null) ? new byte[]{} : p.getImage();
            }
        }, "photo-" + getUsername() + "-" + Math.random());
    }

    private String getUsername() {
        Principal p = VaadinService.getCurrentRequest().getUserPrincipal();
        return (p == null) ? "zuacaldeira@gmail.com" : p.getName();
    }

    private class PhotoUploader extends Upload implements Upload.Receiver, SucceededListener {

        private ByteArrayOutputStream baos;

        public PhotoUploader() {
            baos = new ByteArrayOutputStream();
        }

        @Override
        public OutputStream receiveUpload(String filename, String mimeType) {
            return baos;
        }

        @Override
        public void uploadSucceeded(SucceededEvent event) {

            Embedded image = new Embedded();
            Resource resource = new StreamResource(new StreamResource.StreamSource() {
                @Override
                public InputStream getStream() {
                    return new ByteArrayInputStream(baos.toByteArray());
                }
            }, "tmp");

            image.setSource(resource);
            photo.addComponent(image);
            Notification.show("Added photo to ui", Notification.Type.HUMANIZED_MESSAGE);
            Photo p = new Photo();
            p.setImage(baos.toByteArray());
            ServiceLocator.findLifetimeAccountService().addPhoto(getUsername(), p);
            Notification.show("Sent photo to backend", Notification.Type.HUMANIZED_MESSAGE);
        }

    }

}
