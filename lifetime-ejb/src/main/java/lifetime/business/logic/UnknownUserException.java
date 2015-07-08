/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.business.logic;

/**
 *
 * @author lifetime
 */
public class UnknownUserException extends RuntimeException {

    public UnknownUserException(String message) {
        super(message);
    }
    
}
