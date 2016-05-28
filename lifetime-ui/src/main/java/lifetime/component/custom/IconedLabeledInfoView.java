/*
 * Copyright 2016 zuacaldeira.
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
package lifetime.component.custom;

import com.vaadin.server.Resource;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;

/**
 * A labeled info view composed by a key, a value and an icon.
 * @author zuacaldeira
 */
public class IconedLabeledInfoView extends LabeledInfoView {
    
    public IconedLabeledInfoView(Component info, Resource icon) {
        super(info);
        super.setIcon(icon);
    }
    
}
