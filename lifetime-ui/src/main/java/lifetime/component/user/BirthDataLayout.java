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
package lifetime.component.user;

import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import lifetime.backend.persistence.jooq.tables.LifetimeUser;

/**
 *
 * @author zua
 */
public class BirthDataLayout extends AbsoluteLayout {

    private VerticalLayout birthDataLayout;
    private Label name;
    private Label date;
    private Label dateIcon;

    private HorizontalLayout dateLayout;
    private Label place;
    private Label placeIcon;
    private HorizontalLayout placeLayout;
    private String UNKNOWN;
    private final LifetimeUser user;

    public BirthDataLayout(LifetimeUser user) {
        this.user = user;
    }

}
