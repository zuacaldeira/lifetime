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
package lifetime.component.welcome.register;

import lifetime.component.custom.LifetimeButtonLink;
import com.vaadin.server.FontAwesome;

/**
 *
 * @author lifetime
 */
public class CancelButton extends LifetimeButtonLink {

    public CancelButton(String language) {
        super(null, language, "Cancel", FontAwesome.TIMES);
        setCaption(getDescription());
    }

}
