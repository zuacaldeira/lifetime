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

import com.vaadin.data.util.IndexedContainer;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lifetime
 */
public class LinguisticSkillsDataContainer extends IndexedContainer {

    public LinguisticSkillsDataContainer(String language) {
        super(getSkillLevels(language));
    }
    
    public static List<String> getSkillLevels(String language) {
        return Arrays.asList(new String[]{"Mother Language", "A1.1","A1.2","A2.1","A2.2","B1.1","B1.2","B2.1","B2.2","C1.1","C1.2","C2.1","C2.2"});
    }
    
}
