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
package lifetime.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

/**
 *
 * @author lifetime
 */
public final class Util {

    private static final String GOOGLE_MAPS_API_KEY = "AIzaSyAEKt6gXiX6yTRbJymZVb4_qdKSd4Jr23g";

    public static int getDaysInInterval(Date start, Date end) {
        // TODO
        return 10;
    }
    private Util() {
    }

    public static String getGoogleMapsApiKey() {
        return GOOGLE_MAPS_API_KEY;
    }
    
    
    /**
     * Encrypt password by using SHA-256 algorithm, encryptedPassword length is
     * 32 bits
     *
     * @param clearTextPassword A clear unsafe password string
     * @return An encode string representing the input value.
     */
    public static String getEncodedPassword(String clearTextPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(clearTextPassword.getBytes());
            return Base64.getEncoder().encodeToString(md.digest());
        } catch (NoSuchAlgorithmException ex) {
            throw new PasswordEncodingException(ex);
        }
    }

}
