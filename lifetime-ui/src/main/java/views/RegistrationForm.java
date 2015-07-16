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
import com.vaadin.ui.PasswordField;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import lifetime.persistence.exceptions.LifetimeSecurityException;
import lifetime.service.LifetimeAccountBusiness;
import util.ServiceLocator;
import util.Translator;
import util.Util;

/**
 *
 * @author lifetime
 */
public class RegistrationForm extends FormLayout implements Property.ValueChangeListener {

    private final LifetimeTextField firstname;
    private final LifetimeTextField lastname;
    private final LifetimeTextField email;
    //private  LifetimeDateField birthDate;
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
        //firstname.addValueChangeListener(this);

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
        password.addValueChangeListener(this);
        passwordRepeat = new PasswordField("Repeat password");
        passwordRepeat.addValueChangeListener(this);
        birthDate = new LifetimeDateField("Birthdate", language);
        birthDate.addValueChangeListener(this);
        birthDate.setLocale(new Locale(language));
        //
        birthPlace = new LifetimeTextField("Birth place");
        birthPlace.addValueChangeListener(this);

        addComponents(text, defaultLanguage, firstname, lastname, email, password, passwordRepeat, birthDate, birthPlace);
        setStyleName("forms");
    }

    private String valueOf(LifetimeComboBox combo) {
        String language = (combo.getValue().toString().split(" - "))[1].trim();
        return language;
    }

    private String sha256Base64(String value) throws NoSuchAlgorithmException {
        return Util.getEncodedPassword(value);
    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
    }

    public void split(Property.ValueChangeEvent event) {
        String[] split = ((String) event.getProperty().getValue()).split(" - ");
        String language = split[1].trim();
        defaultLanguage.setValue(language);
        // translate the other fields of the   
        // VERY UGLY WORK_AROUND: BAD DESIGN
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

    void submit() {
        try {
            LifetimeAccountBusiness service = ServiceLocator.findLifetimeAccountService();
            service.register(firstname.getValue(), lastname.getValue(), email.getValue(), password.getValue(), defaultLanguage.getValue().toString(), birthDate.getValue(), birthPlace.getValue());
        } catch (NamingException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Lifetime Account Service NOt Found", ex);
        } catch (LifetimeSecurityException ex) {
            Logger.getLogger(RegistrationForm.class.getName()).log(Level.SEVERE, "Security Issue During Registration", ex);
        }
    }

}
