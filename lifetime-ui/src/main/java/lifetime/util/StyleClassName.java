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
public enum StyleClassName {

    /**
     * Top level components styles and identifiers.
     */
    LIFETIME_UI("lifetime-ui"),
    LIFETIME_VIEW("lifetime-view"),
    LIFETIME_MENU("lifetime-menu"),
    LIFETIME_CONTENT("lifetime-content"),
    /**
     * Inner components identifiers.
     */
    WELCOME_UI("welcome-ui"),
    WELCOME_VIEW("welcome-view"),
    WELCOME_MENU("welcome-menu"),
    WELCOME_CONTENT("welcome-content"),
    /* Main Views. */
    USER_UI("user-ui"),
    USER_VIEW("user-view"),
    USER_MENU("user-menu"),
    USER_CONTENT("user-content"),
    /* Menus. */
    REGISTER_VIEW("register-view"),
    REGISTER_MENU("register-menu"),
    REGISTER_CONTENT("register-content"),
    /* Content. */
    /* Buttons. */
    HOME_BUTTON("home-button"),
    REGISTER_BUTTON("register-button"),
    LOGIN_BUTTON("login-button"),
    CONTACT_BUTTON("contact-button"),
    VITAE_BUTTON("vitae-button"),
    OK_BUTTON("ok-button"),
    /*Forms.*/
    REGISTRATION_FORM("registration-form"),
    /*Form Fields */
    REGISTRATION_FORM_FIRSTNAME("rf-firstname"),
    REGISTRATION_FORM_LASTNAME("rf-lastname"),
    REGISTRATION_FORM_EMAIL("rf-email"),
    REGISTRATION_FORM_ENCRYPTED("rf-encrypted"),
    REGISTRATION_FORM_ENCRYPTED_REPEAT("rf-encrypted-repeat"),
    REGISTRATION_FORM_BIRTHDATE("rf-birthdate"),
    REGISTRATION_FORM_BIRTHPLACE("rf-birthplace"),
    BACK_TO_PROFILE_BUTTON("back-to-profile-button"),
    C_BUTTON("c-button"),
    R_BUTTON("r-button"),
    U_BUTTON("u-button"),
    D_BUTTON("d-button");

    private final String styleName;

    private StyleClassName(String style) {
        styleName = style;
    }

    public String getStyleName() {
        return styleName;
    }

    public String getId() {
        return styleName;
    }

}
