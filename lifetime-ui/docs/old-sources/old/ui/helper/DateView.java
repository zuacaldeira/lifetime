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
package old.ui.helper;

import old.ui.label.LifetimeLabel;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lifetime
 */
public class DateView extends VerticalLayout {

    private Date start;
    private Date end;
    private LifetimeLabel startView;
    private final SimpleDateFormat DF = new SimpleDateFormat("MMM yyyy");
    private LifetimeLabel endView;
    private ConnectorView connectorView;

    public DateView(Date start, Date end, String language) {
        this.start = start;
        this.end = end;
        if(start != null) {
            startView = new LifetimeLabel(DF.format(start), language);
        } else {
            startView = new LifetimeLabel("s", language);
        }
        connectorView = new ConnectorView(language);
        
        if (end != null) {
            endView = new LifetimeLabel(DF.format(end), language);
        } else {
            endView = new LifetimeLabel("u", language);
        }
        addComponents(endView, connectorView, startView);
        setComponentAlignment(endView, Alignment.MIDDLE_CENTER);
        setComponentAlignment(connectorView, Alignment.MIDDLE_CENTER);
        setComponentAlignment(startView, Alignment.MIDDLE_CENTER);
        setStyleName("dates");
    }

}
