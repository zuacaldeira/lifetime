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

import com.vaadin.ui.TabSheet;
import java.util.Objects;

/**
 *
 * @author zua
 */
public class AccountDetailsLayout extends TabSheet {

    private  ProfileSummaryLayout profile;
    private  String username;

    public AccountDetailsLayout(String username, String language) {
        //profile = new ProfileSummaryLayout(username, language);
        this.username = username;
        //Tab t1 = addTab(profile, "Personal");
        //t1.setIcon(FontAwesome.INFO);
        setStyleName("account-details");
        setSizeFull();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.profile);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AccountDetailsLayout)) {
            return false;
        }
        final AccountDetailsLayout other = (AccountDetailsLayout) obj;
        return Objects.equals(this.username, other.username);
    }

}
