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
package lifetime.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewProvider;
import lifetime.view.user.UserView;

/**
 *
 * @author zua
 */
public class UserViewProvider implements ViewProvider {

    private final String language;
    private final String username;

    public UserViewProvider(String username, String language) {
        this.language = language;
        this.username = username;
    }

    @Override
    public String getViewName(String viewAndParameters) {
        return viewAndParameters;
    }

    @Override
    public View getView(String viewName) {
        return new UserView(username, language);
    }
}
