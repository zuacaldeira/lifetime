/*
 * Copyright 2015 lifetime.
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

import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Image;
import java.util.Objects;

/**
 *
 * @author lifetime
 */
public abstract class LifetimeBackground extends AbsoluteLayout {

    private final Image image;
    private final String language;

    public LifetimeBackground(String language, Image image) {
        this.language = language;
        this.image = image;
        setSizeFull();
        image.setSizeFull();
        addComponents(image);
    }

    public String getLanguage() {
        return language;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.image);
        hash = 83 * hash + Objects.hashCode(this.language);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final LifetimeBackground other = (LifetimeBackground) obj;
        return Objects.equals(this.image, other.image)
                && Objects.equals(this.language, other.language);
    }

}
