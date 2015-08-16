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
package lifetime.util;

/**
 *
 * @author zua
 */
public enum Navigation {

    WELCOME_VIEW("welcome"), REGISTER_VIEW("register"), CONTACT_VIEW("contact"), 
    USER_VIEW("user"), VITAE_VIEW("vitae"), TIMELINE_VIEW("timeline"), YELLOW_PAGES_VIEW("yellowpages");

    private String name;
    
    private Navigation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }    
}
