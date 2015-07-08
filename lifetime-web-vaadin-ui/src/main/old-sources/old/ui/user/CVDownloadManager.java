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
package old.ui.user;

import com.vaadin.ui.HorizontalLayout;

/**
 *
 * @author lifetime
 */
public class CVDownloadManager extends HorizontalLayout {
    private final CVSettings settings;
    private final CVPreviewer previewer;

    public CVDownloadManager(Integer userId, String language) {
        setSizeFull();
        setSpacing(true);
        setMargin(true);
        settings = new CVSettings(userId, language);
        previewer = new CVPreviewer(userId, language);
        addComponents(settings, previewer);
    }
    
}
