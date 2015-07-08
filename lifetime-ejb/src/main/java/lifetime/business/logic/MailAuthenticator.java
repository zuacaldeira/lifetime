/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.business.logic;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author lifetime
 */
class MailAuthenticator extends Authenticator {

        private final String username = "vitaelifetime";
        private final String password = "alfarroba";

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    
}
