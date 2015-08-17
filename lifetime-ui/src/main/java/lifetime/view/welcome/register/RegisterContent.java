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
package lifetime.view.welcome.register;

import com.vaadin.ui.Alignment;
import java.util.Objects;
import lifetime.view.LifetimeContent;
import lifetime.util.StyleClassName;

/**
 * The Register Content Wrapper. This class implements the <b>Wrapper Design
 * Pattern</b>, where the wrapped object is a pre-defined FormLayout
 * {@link RegistrationForm}.
 * <p>
 * <i>Notes on Pattern-driven development - parameterized Wrapper Pattern
 * implementation: Given WrapperPattern<T>, we could state <b>new
 * RegisterContent() <=> WrapperPattern<RegisterForm>()</b></i>
 *
 * @author zua
 */
public class RegisterContent extends LifetimeContent {

    private final RegistrationForm registerForm;

    /**
     * Instantiates the content data. The specific content is a
     * {@link RegistrationForm} that must be location sensitive.
     *
     * @param language The language used in interactions with the current user
     */
    public RegisterContent(String language) {
        super(language);
        registerForm = new RegistrationForm(getLanguage());
        setSizeFull();
        addComponent(registerForm);
        setComponentAlignment(registerForm, Alignment.MIDDLE_CENTER);
        setStyleName(StyleClassName.REGISTER_CONTENT.getStyleName());
        setId(StyleClassName.REGISTER_CONTENT.getId());
    }

    /**
     * Return the wrapped registration form.
     *
     * @return An instance of {@link RegistrationForm}
     */
    public RegistrationForm getRegistrationForm() {
        return registerForm;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 53 * hash + Objects.hashCode(this.registerForm);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        final RegisterContent other = (RegisterContent) obj;
        return Objects.equals(this.registerForm, other.registerForm);
    }

}
