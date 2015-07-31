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

import com.vaadin.server.VaadinService;
import com.vaadin.ui.Alignment;
import java.security.Principal;
import lifetime.view.LifetimeContent;
import lifetime.util.StyleClassName;

/**
 *
 * @author zua
 */
class UserContent extends LifetimeContent {

    private final PhotoLayout photoLayout;
    private final AccountDetailsLayout accountDetails;
    private String username;

    public UserContent(String language) {
        super(language);
        setId(StyleClassName.USER_CONTENT);
        setStyleName(StyleClassName.USER_CONTENT);
        initUsername();
        photoLayout = new PhotoLayout(username);
        accountDetails = new AccountDetailsLayout(username);
        addComponents(photoLayout, accountDetails);
        setExpandRatio(photoLayout, .4f);
        setExpandRatio(accountDetails, .6f);
        setComponentAlignment(photoLayout, Alignment.MIDDLE_RIGHT);
        setComponentAlignment(accountDetails, Alignment.MIDDLE_LEFT);
    }

    private void initUsername() {
        Principal p = VaadinService.getCurrentRequest().getUserPrincipal();
        if (p != null) {
            username = p.getName();
        } else {
            username = "zuacaldeira@gmail.com";
        }
    }

}
