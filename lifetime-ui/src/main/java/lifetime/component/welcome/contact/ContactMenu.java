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
package lifetime.component.welcome.contact;

import java.util.Objects;
import lifetime.component.LifetimeMenu;
import lifetime.component.custom.LifetimeHomeButton;

/**
 *
 * @author zua
 */
public class ContactMenu extends LifetimeMenu {

    private LifetimeHomeButton homeButton;

    public ContactMenu(String language) {
        super(language);
    }

    public LifetimeHomeButton getHomeButton() {
        return homeButton;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.getLanguage());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ContactMenu)) {
            return false;
        }
        final ContactMenu other = (ContactMenu) obj;
        return Objects.equals(this.getLanguage(), other.getLanguage());
    }

    @Override
    protected void addControls() {
        homeButton = new LifetimeHomeButton("en");
        addControl(homeButton);
    }

}
