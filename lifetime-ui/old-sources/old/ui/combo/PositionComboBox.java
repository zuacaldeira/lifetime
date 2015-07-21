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
package old.ui.combo;

import com.vaadin.ui.Notification;
import java.util.Date;
import lifetime.business.persistence.Position;
import old.ui.data.PositionDataContainer;
import old.util.ServiceLocator;

/**
 *
 * @author lifetime
 */
public class PositionComboBox extends LifetimeComboBox {

    public PositionComboBox(final String language) {
        super("Position", language, new PositionDataContainer(language));
        setNewItemsAllowed(true);
        setImmediate(true);
        setRequired(true);
        setNewItemHandler(new NewItemHandler() {
            @Override
            public void addNewItem(String newItemCaption) {
                Position position = new Position(null, newItemCaption, new Date(), language);
                ServiceLocator.findLifetimeService().addPosition(position);
                Notification.show("Position added", "New position name is " + newItemCaption, Notification.Type.TRAY_NOTIFICATION);
                addItem(position);
                setValue(position);
            }
        });
    }

    @Override
    public Position getValue() {
        return (Position) super.getValue(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
