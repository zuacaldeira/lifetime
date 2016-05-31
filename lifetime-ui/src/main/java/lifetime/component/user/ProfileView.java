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
    private transient LifetimeAccountService service;
    private final String username;

    /**
     * Layout components.
     */
    private PhotoReceiver receiver;
    private Upload upload;
    private Image image;
    private final HorizontalLayout base;
    private BirthDataLayout birthDataLayout;
    private AddressLayout addressLayout;
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
        System.out.println("USERNAME PASSED TO ProfILE VIEW -> " + username);
        base = new HorizontalLayout();
        base.setSizeFull();
        base.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setSizeFull();
        addComponent(base);
        init();
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
        base.removeAllComponents();
    }

    private void initService() {
        service = ServiceLocator.findLifetimeAccountService();
    }

    protected void initUploadAndReceiver() {
        receiver = new PhotoReceiver(username, this);
        // Upload layout
        upload = new Upload("Add your favourite photo", receiver);
        upload.addSucceededListener(receiver);
        upload.setImmediate(true);
        //base.addComponent(upload);
    }

    protected void initPhoto() {
    }

    protected void initBirthDataLayout() {
    }

    protected void initAddressLayout() {
    }

    /**
     * Adds the user main contacts to it's profile view.
     */
    protected void initContactLayout() {
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

}
