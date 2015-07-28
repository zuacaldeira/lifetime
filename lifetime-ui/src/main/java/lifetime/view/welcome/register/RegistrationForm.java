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
package lifetime.view.welcome.register;

import com.vaadin.data.validator.EmailValidator;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.VerticalLayout;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Logger;
import lifetime.service.LifetimeAccountBusiness;
import lifetime.ui.Navigation;
import lifetime.view.validator.NameValidator;
import lifetime.view.validator.PasswordValidator;
import lifetime.util.ServiceLocator;
import lifetime.util.Util;
import lifetime.view.StyleClassName;
import lifetime.view.custom.LifetimeTextField;
import lifetime.view.custom.LocalesComboBox;

/**
 *
 * @author lifetime
 */
public class RegistrationForm extends HorizontalLayout {

    private final LifetimeTextField firstname;
    private final LifetimeTextField lastname;
    private final LifetimeTextField email;
    private final PasswordField password;
    private final PasswordField passwordRepeat;
    private final LocalesComboBox defaultLanguage;
    private final DateField birthDate;
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
        firstname.setId(StyleClassName.REGISTRATION_FORM_FIRSTNAME);

        /* Creates lastnames text field and registers a validator */
        lastname = new LifetimeTextField("Lastname");
        lastname.addValidator(new NameValidator());
        lastname.setValidationVisible(true);
        lastname.setRequired(true);
        lastname.setId(StyleClassName.REGISTRATION_FORM_LASTNAME);

        /* Creates email text field and registers a validator */
        email = new LifetimeTextField("Email / Username");
        email.addValidator(new EmailValidator("Invalid email address"));
        email.setValidationVisible(true);
        email.setId(StyleClassName.REGISTRATION_FORM_EMAIL);

        /* Creates password text field and registers a validator */
        password = new PasswordField("Password");
        password.addValidator(new PasswordValidator());
        password.setId(StyleClassName.REGISTRATION_FORM_PASSWORD);

        passwordRepeat = new PasswordField("Repeat password");
        passwordRepeat.setId(StyleClassName.REGISTRATION_FORM_PASSWORD_REPEAT);

        birthDate = new DateField("Birthdate");
        birthDate.setLocale(new Locale(language));
        birthDate.setId(StyleClassName.REGISTRATION_FORM_BIRTHDATE);

//
        birthPlace = new LifetimeTextField("Birth place");
        birthPlace.setId(StyleClassName.REGISTRATION_FORM_BIRTHPLACE);

        VerticalLayout personalData = new VerticalLayout(defaultLanguage, firstname, lastname, email, password, passwordRepeat);
        VerticalLayout birthData = new VerticalLayout(birthDate, birthPlace);
        birthData.setDefaultComponentAlignment(Alignment.MIDDLE_RIGHT);
        addComponents(personalData, birthData);
        setStyleName(StyleClassName.REGISTRATION_FORM);
        setId(StyleClassName.REGISTRATION_FORM);
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

    public DateField getBirthDate() {
        return birthDate;
    }

    public void clear() {
        firstname.setValue("");
        lastname.setValue("");
        email.setValue("");
        password.setValue("");
        passwordRepeat.setValue("");
        defaultLanguage.setValue("English - en");
        birthDate.clear();
    }

    /**
     * Submits the registration form, issuing a register request to the backend.
     */
    public void submit() {
        // Lookup a reference for the account business interface
        LifetimeAccountBusiness service = ServiceLocator.findLifetimeAccountService();
        // Call backend to register with the collected and verified data
        try {
            boolean successfullRegistration = service.register(firstname.getValue(), lastname.getValue(), email.getValue(), Util.getEncodedPassword(password.getValue()), defaultLanguage.getValue().toString(), birthDate.getValue(), birthPlace.getValue());
            // Upon successfull registration, return to the welcome page
            if (successfullRegistration) {
                Notification.show("Registration concluded.", Notification.Type.TRAY_NOTIFICATION);
                getUI().getNavigator().navigateTo(Navigation.WELCOME_VIEW);
            } else {
                Notification.show("Registration failed. Try again later.", Notification.Type.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(RegistrationForm.class.getName()).warning("Registration Failed. Try again later.");
            Notification.show("Registration failed. Try again later.", Notification.Type.WARNING_MESSAGE);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.firstname.getValue());
        hash = 17 * hash + Objects.hashCode(this.lastname.getValue());
        hash = 17 * hash + Objects.hashCode(this.email.getValue());
        hash = 17 * hash + Objects.hashCode(this.password.getValue());
        hash = 17 * hash + Objects.hashCode(this.passwordRepeat.getValue());
        hash = 17 * hash + Objects.hashCode(this.defaultLanguage.getValue());
        hash = 17 * hash + Objects.hashCode(this.birthDate.getValue());
        hash = 17 * hash + Objects.hashCode(this.birthPlace.getValue());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final RegistrationForm other = (RegistrationForm) obj;
        return validUserData(other) && validAccountData(other) && validBirthData(other);
    }

    private boolean validUserData(RegistrationForm other) {
        return Objects.equals(this.firstname.getValue(), other.firstname.getValue())
                && Objects.equals(this.lastname.getValue(), other.lastname.getValue())
                && Objects.equals(this.defaultLanguage.getValue(), other.defaultLanguage.getValue());
    }

    private boolean validAccountData(RegistrationForm other) {
        return Objects.equals(this.email.getValue(), other.email.getValue())
                && Objects.equals(this.password.getValue(), other.password.getValue())
                && Objects.equals(this.passwordRepeat.getValue(), other.passwordRepeat.getValue());
    }

    private boolean validBirthData(RegistrationForm other) {
        return Objects.equals(this.birthDate.getValue(), other.birthDate.getValue())
                && Objects.equals(this.birthPlace.getValue(), other.birthPlace.getValue());
    }

}
