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
package old.ui.data;

import old.util.ServiceLocator;
import com.vaadin.data.util.IndexedContainer;
import java.util.List;

/**
 *
 * @author lifetime
 */
public class LastnameDataContainer extends IndexedContainer {

    public LastnameDataContainer(String language) {
        super(getLastnames());
    }
    
    private static List<String> getLastnames() {
        return ServiceLocator.findLifetimeService().getLastnames();
    }
    
}
