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
package lifetime.view.user;

import com.vaadin.server.FontAwesome;
import lifetime.util.Translator;
import lifetime.util.StyleClassName;
import lifetime.view.custom.LifetimeButtonLink;

/**
 *
 * @author zua
 */
public class VitaeButton extends LifetimeButtonLink {

    public VitaeButton(String language) {
        super(Translator.getTranslation("Vitae", language), language, FontAwesome.TREE);
        setDescription(Translator.getTranslation("Vitae", language));
        setId(StyleClassName.VITAE_BUTTON);
    }

}
