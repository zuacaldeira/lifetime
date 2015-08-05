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
     * UIs.
     */
    WELCOME_UI("welcome-ui"),
    USER_UI("user-ui"),
    WELCOME_VIEW("welcome-view"),
    USER_VIEW("user-view"),
    REGISTER_VIEW("register-view"),
    WELCOME_MENU("welcome-menu"),
    USER_MENU("user-menu"),
    REGISTER_MENU("register-menu"),
    HOME_BUTTON("home-button"),
    REGISTER_BUTTON("register-button"),
    LOGIN_BUTTON("login-button"),
    CONTACT_BUTTON("contact-button"),
    VITAE_BUTTON("vitae-button"),
    OK_BUTTON("ok-button"),
    WELCOME_CONTENT("welcome-content"),
    USER_CONTENT("user-content"),
    REGISTER_CONTENT("register-content"),
    REGISTRATION_FORM("registration-form"),
    REGISTRATION_FORM_FIRSTNAME("rf-firstname"),
    REGISTRATION_FORM_LASTNAME("rf-lastname"),
    REGISTRATION_FORM_EMAIL("rf-email"),
    REGISTRATION_FORM_ENCRYPTED("rf-encrypted"),
    REGISTRATION_FORM_ENCRYPTED_REPEAT("rf-encrypted-repeat"),
    REGISTRATION_FORM_BIRTHDATE("rf-birthdate"),
    REGISTRATION_FORM_BIRTHPLACE("rf-birthplace");

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
