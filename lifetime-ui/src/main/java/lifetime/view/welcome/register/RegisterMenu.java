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

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import java.util.Objects;
import lifetime.ui.Navigation;
import lifetime.view.custom.LifetimeHomeButton;
import lifetime.view.LifetimeMenu;
import lifetime.util.StyleClassName;

/**
 *
 * @author zua
 */
public class RegisterMenu extends LifetimeMenu {

    private final LifetimeHomeButton homeButton;
    private final CancelButton cancelButton;
    private final OKButton okButton;

    public RegisterMenu(String language) {
        super(language);
        setSizeFull();
        homeButton = new LifetimeHomeButton(language);
        homeButton.addClickListener(this);
        cancelButton = new CancelButton(language);
        cancelButton.addClickListener(this);
        okButton = new OKButton(null, language);
        okButton.addClickListener(this);
        addControl(homeButton);
        addControl(cancelButton);
        addControl(okButton);
        setId(StyleClassName.REGISTER_MENU);
        setStyleName(StyleClassName.REGISTER_MENU);
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
        int hash = super.hashCode();
        hash = 37 * hash + Objects.hashCode(this.homeButton);
        hash = 37 * hash + Objects.hashCode(this.cancelButton);
        hash = 37 * hash + Objects.hashCode(this.okButton);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        final RegisterMenu other = (RegisterMenu) obj;
        if (!Objects.equals(this.homeButton, other.homeButton)) {
            return false;
        }
        if (!Objects.equals(this.cancelButton, other.cancelButton)) {
            return false;
        }
        return Objects.equals(this.okButton, other.okButton);
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        Button b = event.getButton();
        if (b == homeButton) {
            getUI().getNavigator().navigateTo(Navigation.WELCOME_VIEW);
        } else if (b == cancelButton) {
            getRegistrationForm().clear();
        } else if (b == okButton) {
            getRegistrationForm().submit();
        }
    }

    private RegistrationForm getRegistrationForm() {
        Component parent = getParent();
        while (!(parent instanceof RegisterView)) {
            parent = parent.getParent();
        }

        RegisterView registerView = (RegisterView) parent;
        return registerView.getContent().getRegisterForm();
    }

}
