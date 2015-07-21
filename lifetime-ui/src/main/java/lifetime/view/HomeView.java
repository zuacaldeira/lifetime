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
package lifetime.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import java.util.Objects;

/**
 *
 * @author zua
 */
public class HomeView extends HorizontalLayout {

    private final String language;

    public HomeView(String language) {
        this.language = language;
        setSizeFull();
        NumericStatsView nUsers = new NumericStatsView("# Users", 10000000);
        NumericStatsView nJobs = new NumericStatsView("# Job Offers", 10000);
        NumericStatsView nCourses = new NumericStatsView("# Course Offers", 10000);
        addComponents(nUsers, nJobs, nCourses);
        setComponentAlignment(nUsers, Alignment.MIDDLE_CENTER);
        setComponentAlignment(nJobs, Alignment.MIDDLE_CENTER);
        setComponentAlignment(nCourses, Alignment.MIDDLE_CENTER);
    }

    /**
     * Returns the language associated with this view.
     *
     * @return
     */
    public String getLanguage() {
        return language;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.language);
        return hash;
    }

    /**
     * Compares this view with another object for equality.
     *
     * @param obj the object we are comparing with
     * @return {@code true} if they are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        final HomeView other = (HomeView) obj;
        return Objects.equals(this.language, other.language);
    }

}