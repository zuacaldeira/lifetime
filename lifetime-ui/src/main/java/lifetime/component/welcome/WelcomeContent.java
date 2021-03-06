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
package lifetime.component.welcome;

import com.vaadin.ui.Alignment;
import java.util.Objects;
import lifetime.component.LifetimeContent;
import lifetime.util.StyleClassName;

/**
 *
 * @author zua
 */
public class WelcomeContent extends LifetimeContent {

    private final HomeView contentView;

    public WelcomeContent(String language) {
        super(language);
        setSizeFull();
        contentView = new HomeView(getLanguage());
        addComponent(contentView);
        setComponentAlignment(contentView, Alignment.MIDDLE_CENTER);
        setId(StyleClassName.WELCOME_CONTENT.getId());
        setStyleName(StyleClassName.LIFETIME_CONTENT.getStyleName());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.contentView);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WelcomeContent other = (WelcomeContent) obj;
        return Objects.equals(this.contentView, other.contentView);
    }

    public HomeView getContentView() {
        return contentView;
    }

}
