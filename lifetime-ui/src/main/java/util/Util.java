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
package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 *
 * @author lifetime
 */
public class Util {

    /**
     * Private constructor disables client instantiation of this class.
     */
    public Util() {
    }

    /**
     * Encrypt password by using SHA-256 algorithm, encryptedPassword length is
     * 32 bits
     *
     * @param clearTextPassword A clear unsafe password string
     * @return An encode string representing the input value.
     * @throws java.security.NoSuchAlgorithmException If there is a problem
     * choosing the encoding algorithm
     */
    public static String getEncodedPassword(String clearTextPassword) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(clearTextPassword.getBytes());
        return Base64.getEncoder().encodeToString(md.digest());
    }

}
