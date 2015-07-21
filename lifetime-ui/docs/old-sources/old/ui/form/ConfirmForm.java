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
package old.ui.form;

import old.ui.button.LifetimeButtonLink;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.HorizontalLayout;
import old.ui.list.LifetimeList;

/**
 *
 * @author lifetime
 */
public class ConfirmForm<T> extends HorizontalLayout {
    private final T data;
    private final LifetimeList<T> list;
    private final LifetimeButtonLink delete;
    private final LifetimeButtonLink cancel;

    public ConfirmForm(T data, LifetimeList<T> list) {
        this.data = data;
        this.list = list;
        cancel = new LifetimeButtonLink("Cancel", FontAwesome.TIMES);
        delete = new LifetimeButtonLink("Delete", FontAwesome.TRASH_O);
        addComponents(cancel, delete);
    }

    public LifetimeButtonLink getDelete() {
        return delete;
    }

    public LifetimeButtonLink getCancel() {
        return cancel;
    }

    public T getData() {
        return data;
    }

    public LifetimeList<T> getList() {
        return list;
    }
    
    
    
    

    
}
