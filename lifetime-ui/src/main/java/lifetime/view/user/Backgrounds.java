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
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Image;

/**
 *
 * @author zua
 */
public enum Backgrounds {

    USER_BACKGROUND(new ThemeResource("../img/background.jpg")),
    WELCOME_BACKGROUND(new ThemeResource("../img/background.jpg"));

    private Resource resource;

    private Backgrounds(Resource resource) {
        this.resource = resource;
    }

    public Resource getResource() {
        return resource;
    }

    public static Image getBackground(Backgrounds background) {
        return new Image("", background.getResource());
    }
}