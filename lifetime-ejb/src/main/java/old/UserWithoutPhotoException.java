/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

/**
 *
 * @author lifetime
 */
public class UserWithoutPhotoException extends Exception {

    public UserWithoutPhotoException(Integer userId) {
        super("User without photo: " + userId);
    }
    
}
