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
package lifetime.component.welcome.register;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import java.util.Objects;
import lifetime.component.custom.LifetimeHomeButton;
import lifetime.component.LifetimeMenu;
import lifetime.util.StyleClassName;

/**
 *
 * @author zua
 */
public class RegisterMenu extends LifetimeMenu {

    private LifetimeHomeButton homeButton;
    private CancelButton cancelButton;
    private OKButton okButton;

    public RegisterMenu(String language) {
        super(language);
        setSizeFull();
        setId(StyleClassName.REGISTER_MENU.getId());
        setStyleName(StyleClassName.REGISTER_MENU.getStyleName());
    }

    public LifetimeHomeButton getHomeButton() {
        return homeButton;
    }

    public CancelButton getCancelButton() {
        return cancelButton;
    }

    public OKButton getOkButton() {
        return okButton;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.getLanguage());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RegisterMenu)) {
            return false;
        }

        final RegisterMenu other = (RegisterMenu) obj;
        return Objects.equals(this.getLanguage(), other.getLanguage());
    }

    public RegistrationForm getRegistrationForm() {
        Component parent = getParent();
        if (parent != null) {
            while (!(parent instanceof RegisterView)) {
                parent = parent.getParent();
            }
            RegisterView registerView = (RegisterView) parent;
            return registerView.getContent().getRegistrationForm();
        } else {
            return null;
        }
    }

    @Override
    protected void addControls() {
        homeButton = new LifetimeHomeButton(getLanguage());
        cancelButton = new CancelButton(getLanguage());
        cancelButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getRegistrationForm().clear();
            }
        });
        okButton = new OKButton(null, getLanguage());
        okButton.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                getRegistrationForm().submit();
            }
        });
        addControl(homeButton);
        addControl(cancelButton);
        addControl(okButton);
    }

}
