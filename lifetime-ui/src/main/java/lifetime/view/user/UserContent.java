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
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.SucceededListener;
import com.vaadin.ui.VerticalLayout;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import lifetime.persistence.Contact;
import lifetime.persistence.Photo;
import lifetime.service.LifetimeAccountBusiness;
import lifetime.util.ServiceLocator;
import lifetime.view.LifetimeContent;
import lifetime.view.StyleClassName;

/**
 *
 * @author zua
 */
class UserContent extends LifetimeContent implements Upload.Receiver, SucceededListener {

    private VerticalLayout photoLayout;
    private VerticalLayout accountDetails;
    private String username;
    private ByteArrayOutputStream baos;

    public UserContent(String language) {
        super(language);
        baos = new ByteArrayOutputStream();
        setId(StyleClassName.USER_CONTENT);
        setStyleName(StyleClassName.USER_CONTENT);
        initUsername();
        showUserData();
        setExpandRatio(photoLayout, .3f);
        setExpandRatio(accountDetails, .7f);
        setComponentAlignment(photoLayout, Alignment.MIDDLE_CENTER);
        setComponentAlignment(accountDetails, Alignment.MIDDLE_CENTER);
    }

    private void showUserData() {
        showPhoto();
        showAccountDetails();
    }

    private void showPhoto() {
        Photo userPhoto = ServiceLocator.findLifetimeAccountService().getPhoto(username);
        if (userPhoto != null) {
            Image image = new Image("", getPhotoResource(userPhoto));
            //VerticalLayout photoBase = new VerticalLayout(image);
            //photoBase.setStyleName("photo-layout");
            image.setWidth("75%");
            //image.setHeight("50%");
            photoLayout = new VerticalLayout(image);
            photoLayout.setComponentAlignment(image, Alignment.MIDDLE_RIGHT);
        } else {
            Upload upload = new Upload("Add your favourite photo", this);
            upload.addSucceededListener(this);
            upload.setImmediate(true);
            photoLayout = new VerticalLayout(upload);
        }
        //photoLayout.setWidth("50%");
        //photoLayout.setHeight("50%");
        photoLayout.setSizeFull();
        addComponent(photoLayout);
    }

    private void showAccountDetails() {
        accountDetails = new VerticalLayout();
        accountDetails.setStyleName("account-details");
        accountDetails.setSizeUndefined();

        LifetimeAccountBusiness service = ServiceLocator.findLifetimeAccountService();
        Label name = new Label(service.getFullName(username));
        Label email = new Label(username);
        Contact contact = service.getContact(username);
        Label address = new Label(contact.getStreet() + " * " + contact.getDoor() + " * " + contact.getPostalCode() + " * " + contact.getLocality() + " * " + contact.getCountry());

        accountDetails.addComponents(email);
        accountDetails.setComponentAlignment(email, Alignment.MIDDLE_CENTER);
        addComponent(accountDetails);
    }

    private Resource getPhotoResource(final Photo p) {
        return new StreamResource(new StreamResource.StreamSource() {
            @Override
            public InputStream getStream() {
                return new ByteArrayInputStream(p.getImage());
            }
        }, "photo-" + username + "-" + Math.random());
    }

    private void initUsername() {
        Principal p = VaadinService.getCurrentRequest().getUserPrincipal();
        if (p != null) {
            username = p.getName();
        } else {
            username = "zuacaldeira@gmail.com";
        }
    }

    @Override
    public OutputStream receiveUpload(String filename, String mimeType) {
        Notification.show("Received Upload: " + filename);
        return baos;
    }

    @Override
    public void uploadSucceeded(Upload.SucceededEvent event) {
        try {
            baos.close();
            Notification.show("Upload Succeeded: " + baos.toByteArray());
            photoLayout.removeAllComponents();
            photoLayout.addComponent(new Image("", new StreamResource(new StreamResource.StreamSource() {

                @Override
                public InputStream getStream() {
                    return new ByteArrayInputStream(baos.toByteArray());
                }
            }, username + Math.random())));
            photoLayout.setSizeFull();

            ServiceLocator.findLifetimeAccountService().addPhoto(username, baos.toByteArray());
            Notification.show("Image saved in db");
        } catch (IOException ex) {
            Logger.getLogger(UserContent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
