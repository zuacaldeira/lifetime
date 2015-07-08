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
import java.util.Date;
import java.util.Random;

/**
 *
 * @author lifetime
 */
public class Util {

  private static Random random = new Random((new Date()).getTime());
  
  /**
   * Encrypt password by using SHA-256 algorithm, encryptedPassword length is 32 bits
   * @param clearTextPassword
   * @return
   */
  public static String getEncodedPassword(String clearTextPassword)   {  
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update(clearTextPassword.getBytes());
      return new sun.misc.BASE64Encoder().encode(md.digest());
    } catch (NoSuchAlgorithmException e) {
      //_log.error("Failed to encrypt password.", e);
    }
    return "";
  }
  
  
  public static void main(String[] args) {
      System.out.println(getEncodedPassword("unicidade"));
  }
    
}