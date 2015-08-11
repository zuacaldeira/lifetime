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

import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;
import com.vaadin.server.StreamResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Objects;
import lifetime.backend.persistence.Address;
import lifetime.backend.persistence.Contact;
import lifetime.backend.persistence.Photo;
import lifetime.backend.persistence.User;
import lifetime.backend.service.LifetimeAccountService;
import lifetime.util.ServiceLocator;

/**
 *
 * @author <a href="mailto:zuacaldeira@gmail.com>Alexandre Caldeira</a>
 */
public class ProfileView extends UserContent {

    /**
     * Backend data and user specific data.
     */
    private LifetimeAccountService service;
    private final String username;
    private User user;
    private Address address;
    private Contact contact;

    /**
     * Layout components.
     */
    private PhotoReceiver receiver;
    private Upload upload;
    private Image image;
    private VerticalLayout birthData;
    private VerticalLayout addressLayout;
    private VerticalLayout contactLayout;
    private final HorizontalLayout base;

    /**
     * Constructs a new photo layout, with only the {@code username}
     * initialized.
     *
     * @param username The current user username.
     * @param language The user current interaction language
     */
    public ProfileView(String username, String language) {
        super(language);
        this.username = username;
        base = new HorizontalLayout();
        base.setSizeFull();
        //base.setHeight("75%");
        //setCaption("Who am I?");
        base.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setSizeFull();

        addComponent(base);
        //setStyleName(username);
    }

    @Override
    public void attach() {
        super.attach(); //To change body of generated methods, choose Tools | Templates.
        clean();
        initService();
        addPhoto();
        addBirthData();
        addAddress();
        addContact();

    }

    final void addPhoto() {
        if (service != null) {
            Photo userPhoto = service.getPhoto(username);
            if (userPhoto != null) {
                ProfileView.this.addPhoto(userPhoto);
            }
            //addUpload();
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.username);
        return super.hashCode() + hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof ProfileView)) {
            return false;
        }
        final ProfileView other = (ProfileView) obj;
        return Objects.equals(this.username, other.username);
    }

    private void clean() {
        base.removeAllComponents();
    }

    private void addPhoto(Photo userPhoto) {
        image = new Image("", getPhotoResource(userPhoto));
        image.setHeight("60%");
        base.addComponent(image);
        base.setComponentAlignment(image, Alignment.MIDDLE_CENTER);
    }

    private void addUpload() {
        receiver = new PhotoReceiver(username, this);
        // Upload layout
        upload = new Upload("Add your favourite photo", receiver);
        upload.addSucceededListener(receiver);
        upload.setImmediate(true);
        //upload.setWidth(image.getWidth(), image.getWidthUnits());
        base.addComponent(upload);
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

    private void addBirthData() {
        user = service.getUser(username);
        // Name
        Label name = new Label(user.getFirstname() + " " + user.getLastname());
        // Date
        Label date = new Label(DateFormat.getInstance().format(user.getBirthDate()));
        Label dateIcon = new Label(FontAwesome.CLOCK_O.getHtml(), ContentMode.HTML);
        HorizontalLayout dateLayout = new HorizontalLayout(dateIcon, date);
        dateLayout.setSpacing(true);
        // Place
        Label place = new Label(user.getBirthPlace());
        Label placeIcon = new Label(FontAwesome.MAP_MARKER.getHtml(), ContentMode.HTML);
        HorizontalLayout placeLayout = new HorizontalLayout(placeIcon, place);
        placeLayout.setSpacing(true);
        // Container layout
        birthData = new VerticalLayout(name,
                dateLayout,
                placeLayout);
        // add the data container to the panel
        base.addComponent(birthData);
        base.setComponentAlignment(birthData, Alignment.MIDDLE_RIGHT);
    }

    private void addAddress() {
        // User's address
        address = service.getAddress(username);

        // Street, door and floor coordinates
        HorizontalLayout street = new HorizontalLayout(
                new Label(address.getStreet()),
                new Label(address.getDoor()),
                new Label(address.getFloor()));
        street.setSpacing(true);
        Label streetIcon = new Label(FontAwesome.ENVELOPE.getHtml(), ContentMode.HTML);

        HorizontalLayout streetLayout = new HorizontalLayout(streetIcon, street);
        streetLayout.setSpacing(true);

        // Postal code and city/locality
        HorizontalLayout locality = new HorizontalLayout(
                new Label(address.getPostalCode()),
                new Label(address.getLocality()));
        locality.setSpacing(true);

        // Region and country
        HorizontalLayout country = new HorizontalLayout(
                new Label(address.getRegion()),
                new Label(address.getCountry()));
        country.setSpacing(true);

        // Final address layout
        addressLayout = new VerticalLayout(streetLayout, locality, country);
        // add in to base content
        base.addComponent(addressLayout);
        base.setComponentAlignment(addressLayout, Alignment.MIDDLE_RIGHT);
    }

    /**
     * Adds the user main contacts to it's profile view.
     */
    private void addContact() {
        contact = service.getContact(username);
        // personal telephone
        Label phone = new Label(contact.getTelephone1());
        Label phoneIcon = new Label(FontAwesome.PHONE.getHtml(), ContentMode.HTML);
        HorizontalLayout phoneLayout = new HorizontalLayout(phoneIcon, phone);
        phoneLayout.setSpacing(true);
        // mobile
        Label mobile = new Label(contact.getMobile1());
        Label mobileIcon = new Label(FontAwesome.MOBILE.getHtml(), ContentMode.HTML);
        HorizontalLayout mobileLayout = new HorizontalLayout(mobileIcon, mobile);
        mobileLayout.setSpacing(true);
        // contacts container
        contactLayout = new VerticalLayout(phoneLayout, mobileLayout);
        // add to base panel
        base.addComponent(contactLayout);
        base.setComponentAlignment(contactLayout, Alignment.MIDDLE_RIGHT);
    }

}
