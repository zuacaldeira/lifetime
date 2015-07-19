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
package lifetime.view;

import com.vaadin.ui.VerticalLayout;
import java.util.Objects;

/**
 *
 * @author zua
 */
public abstract class LifetimeContent extends VerticalLayout {

    private final String language;

    public LifetimeContent(String language) {
        this.language = language;
        setSizeFull();
        setId(StyleClassName.LIFETIME_CONTENT);
        setStyleName(StyleClassName.LIFETIME_CONTENT);
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 79 * hash + Objects.hashCode(this.language);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        final LifetimeContent other = (LifetimeContent) obj;
        return Objects.equals(this.language, other.language);
    }

}
