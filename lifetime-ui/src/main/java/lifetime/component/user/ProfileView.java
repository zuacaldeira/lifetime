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
package lifetime.component.user;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Upload;
import java.util.Objects;
import lifetime.backend.persistence.jooq.tables.Address;
import lifetime.backend.persistence.jooq.tables.LifetimeUser;
import lifetime.backend.service.RegistrationService;
import lifetime.util.ServiceLocator;

/**
 *
 * @author <a href="mailto:zuacaldeira@gmail.com>Alexandre Caldeira</a>
 */
public class ProfileView extends UserContent {

    /**
     * Backend data and user specific data.
     */
    private transient RegistrationService service;
    /**
     * Current user.
     */
    private final String username;
    /**
     * Base placeholder component.
     */
    private HorizontalLayout base;
    /**
     * Photo management.
     */
    private PhotoReceiver receiver;
    private Upload upload;
    private Image image;
    /**
     * Personal data
     */
    private BirthDataLayout birthDataLayout;
    /**
     * Address data.
     */
    private AddressLayout addressLayout;
    /**
     * Contact data.
     */
    private ContactLayout contactLayout;

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
        this.init();
        super.setSizeFull();
        super.addComponent(base);
    }

    public PhotoReceiver getReceiver() {
        return receiver;
    }

    public Upload getUpload() {
        return upload;
    }

    public Image getImage() {
        return image;
    }

    private void init() {
        clean();
        initService();
        initUploadAndReceiver();
        initPhoto();
        initBirthDataLayout();
        initAddressLayout();
        initContactLayout();
    }

    private void clean() {
        if (base == null) {
            base = new HorizontalLayout();
            base.setSizeFull();
            base.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        } else {
            base.removeAllComponents();
        }
    }

    private void initService() {
        service = ServiceLocator.findLifetimeAccountService();
    }

    private void initUploadAndReceiver() {
        receiver = new PhotoReceiver(username, this);
        // Upload layout
        upload = new Upload("Add your favourite photo", receiver);
        upload.addSucceededListener(receiver);
        upload.setImmediate(true);
        //base.addComponent(upload);
    }

    /**
     * @TODO Add Photo in database:
     */
    protected void initPhoto() {
        // Get photo from db
        
        // If not found, add upload view
        initUploadAndReceiver();
    }

    protected void initBirthDataLayout() {
        birthDataLayout = createBirthLayout();
    }

    protected void initAddressLayout() {
        addressLayout = createAddressLayout();
    }

    /**
     * Adds the user main contacts to it's profile view.
     */
    protected void initContactLayout() {
        contactLayout = createContactLayout();
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

    public BirthDataLayout getBirthDataLayout() {
        return birthDataLayout;
    }

    public AddressLayout getAddressLayout() {
        return addressLayout;
    }

    public ContactLayout getContactLayout() {
        return contactLayout;
    }

    private AddressLayout createAddressLayout() {
        return new AddressLayout(new Address());
    }

    private BirthDataLayout createBirthLayout() {
        return new BirthDataLayout(new LifetimeUser());
    }

    private ContactLayout createContactLayout() {
        return new ContactLayout();
    }

}
