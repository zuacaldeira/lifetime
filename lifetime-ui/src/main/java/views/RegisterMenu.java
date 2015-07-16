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
package views;

import java.util.Objects;


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
        cancelButton = new CancelButton(null, language);
        okButton = new OKButton(null, language);
        addControl(homeButton);
        addControl(cancelButton);
        addControl(okButton);        
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
    
    
    


}
