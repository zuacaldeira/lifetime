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
package lifetime.component.welcome;

import com.vaadin.server.FontAwesome;
import lifetime.component.custom.InfoView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import java.util.Objects;
import lifetime.component.custom.LifetimeButtonLink;
import lifetime.component.custom.LifetimeTextField;

/**
 *
 * @author zua
 */
public class HomeView extends VerticalLayout {

    private final String language;
    private final InfoView nUsers;
    private final InfoView nJobs;
    private final InfoView nCourses;
    private final LifetimeTextField searchText;
    private final LifetimeButtonLink searchButton;

    public HomeView(String language) {
        this.language = language;
        super.setSizeFull();
        nUsers = new InfoView("users", 10000000, FontAwesome.USERS);
        nJobs = new InfoView("jobs", 10000, FontAwesome.BRIEFCASE);
        nCourses = new InfoView("courses", 10000, FontAwesome.BOOK);
        searchText = new LifetimeTextField();
        searchButton = new LifetimeButtonLink(null, language, "Search", FontAwesome.SEARCH);
        super.addComponents(getInfoView(), getSearchView());

    }
    
    private Component getInfoView() {
        HorizontalLayout layout = new HorizontalLayout(nUsers, nJobs, nCourses);
        layout.setSizeFull();
        layout.setComponentAlignment(nUsers, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(nJobs, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(nCourses, Alignment.MIDDLE_CENTER);
        return layout;
    }
    
    private Component getSearchView() {
        searchText.setWidth("50%");
        VerticalLayout layout = new VerticalLayout(searchText, searchButton);
        layout.setWidth("100%");
        layout.setHeightUndefined();
        layout.setMargin(true);
        layout.setComponentAlignment(searchText, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(searchButton, Alignment.MIDDLE_CENTER);
        return layout;
    }

    /**
     * Returns the language associated with this view.
     *
     * @return
     */
    public String getLanguage() {
        return language;
    }

    public InfoView getnUsers() {
        return nUsers;
    }

    public InfoView getnJobs() {
        return nJobs;
    }

    public InfoView getnCourses() {
        return nCourses;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HomeView other = (HomeView) obj;
        if (!Objects.equals(this.language, other.language)) {
            return false;
        }
        return true;
    }

}
