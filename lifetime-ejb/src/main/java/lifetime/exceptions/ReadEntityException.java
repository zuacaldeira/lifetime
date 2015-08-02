/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.exceptions;

/**
 *
 * @author zua
 */
public class ReadEntityException extends RuntimeException {

    public ReadEntityException(Exception ex) {
        super(ex);
    }
    
}
