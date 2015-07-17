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
package views;

import com.vaadin.data.Property;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import lifetime.service.LifetimeAccountBusiness;
import ui.Navigation;
import util.ServiceLocator;
import util.Translator;

/**
 *
 * @author lifetime
 */
public class RegistrationForm extends FormLayout {

    private final LifetimeTextField firstname;
    private final LifetimeTextField lastname;
    private final LifetimeTextField email;
    private final PasswordField password;
    private final PasswordField passwordRepeat;
    private final LocalesComboBox defaultLanguage;
    private final LifetimeDateField birthDate;
    private final LifetimeTextField birthPlace;

    public RegistrationForm(String language) {
        super();
        setSizeUndefined();
        setMargin(true);
        setSpacing(true);
        Label text = new Label("Register");
        setSpacing(true);
        text.setStyleName("login");

        defaultLanguage = new LocalesComboBox(language);
        /* Creates the firstname text field and registers a validator */
        firstname = new LifetimeTextField("Firstname"); // Creates text field
        firstname.addValidator(new NameValidator()); // Register Validator
        firstname.setValidationVisible(true); // Automatic validation

        /* Creates lastnames text field and registers a validator */
        lastname = new LifetimeTextField("Lastname");
        lastname.addValidator(new NameValidator());
        lastname.setValidationVisible(true);
        lastname.setRequired(true);

        /* Creates email text field and registers a validator */
        email = new LifetimeTextField("Email / Username");
        email.addValidator(new EmailValidator("Invalid email address"));
        email.setValidationVisible(true);
        /* Creates password text field and registers a validator */
        password = new PasswordField("Password");
        password.addValidator(new PasswordValidator());
        passwordRepeat = new PasswordField("Repeat password");
        birthDate = new LifetimeDateField("Birthdate", language);
        birthDate.setLocale(new Locale(language));
        //
        birthPlace = new LifetimeTextField("Birth place");
        addComponents(text, defaultLanguage, firstname, lastname, email, password, passwordRepeat, birthDate, birthPlace);
        setStyleName("forms");
    }

    public void split(Property.ValueChangeEvent event) {
        String[] split = ((String) event.getProperty().getValue()).split(" - ");
        String language = split[1].trim();
        defaultLanguage.setValue(language);
        for (int i = 0; i < getComponentCount(); i++) {
            getComponent(i).setCaption(translate(getComponent(i).getCaption(), language));
        }
    }

    private String translate(String caption, String language) {
        return Translator.getTranslation(caption, language);
    }

    public LifetimeTextField getFirstname() {
        return firstname;
    }

    public LifetimeTextField getLastname() {
        return lastname;
    }

    public LifetimeTextField getEmail() {
        return email;
    }

    public PasswordField getPassword() {
        return password;
    }

    public PasswordField getPasswordRepeat() {
        return passwordRepeat;
    }

    public LocalesComboBox getDefaultLanguage() {
        return defaultLanguage;
    }

    public LifetimeDateField getBirthDate() {
        return birthDate;
    }

    void clear() {
        firstname.setValue("");
        lastname.setValue("");
        email.setValue("");
        password.setValue("");
        passwordRepeat.setValue("");
        defaultLanguage.setValue("English - en");
    }

    /**
     * Submits the registration form, issuing a register request to the backend.
     */
    void submit() {
        try {
            // Lookup a reference for the account business interface
            LifetimeAccountBusiness service = ServiceLocator.findLifetimeAccountService();

            // Call backend to register with the collected and verified data
            boolean successfullRegistration = service.register(firstname.getValue(), lastname.getValue(), email.getValue(), password.getValue(), defaultLanguage.getValue().toString(), birthDate.getValue(), birthPlace.getValue());

            // Upon successfull registration, return to the welcome page
            if (successfullRegistration) {
                getUI().getNavigator().navigateTo(Navigation.WELCOME_VIEW);
            } else {
                /*
                 * TODO. Behaves as clear or as home? Enter a new session type
                 * driven behavior!
                 */
                Notification.show("Problem during registration", "Please, try again later.", Notification.Type.TRAY_NOTIFICATION);
                clear();
            }
        } catch (NamingException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Lifetime Account Service NOt Found", ex);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.firstname);
        hash = 17 * hash + Objects.hashCode(this.lastname);
        hash = 17 * hash + Objects.hashCode(this.email);
        hash = 17 * hash + Objects.hashCode(this.password);
        hash = 17 * hash + Objects.hashCode(this.passwordRepeat);
        hash = 17 * hash + Objects.hashCode(this.defaultLanguage);
        hash = 17 * hash + Objects.hashCode(this.birthDate);
        hash = 17 * hash + Objects.hashCode(this.birthPlace);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        final RegistrationForm other = (RegistrationForm) obj;
        return validUserData(other) && validAccountData(other) && validBirthData(other);
    }

    private boolean validUserData(RegistrationForm other) {
        return Objects.equals(this.firstname, other.firstname)
                && Objects.equals(this.lastname, other.lastname)
                && Objects.equals(this.defaultLanguage, other.defaultLanguage);
    }

    private boolean validAccountData(RegistrationForm other) {
        return Objects.equals(this.email, other.email)
                && Objects.equals(this.password, other.password)
                && Objects.equals(this.passwordRepeat, other.passwordRepeat);
    }

    private boolean validBirthData(RegistrationForm other) {
        return Objects.equals(this.birthDate, other.birthDate)
                && Objects.equals(this.birthPlace, other.birthPlace);
    }

}
