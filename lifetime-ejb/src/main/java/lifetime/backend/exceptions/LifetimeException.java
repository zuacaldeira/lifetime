/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.exceptions;

/**
 *
 * @author <a href="mailto:zuacaldeira@gmail.com">Alexandre Caldeira</a>
 */
public class LifetimeException extends RuntimeException {

    /**
     *
     * @param ex
     */
    public LifetimeException(Exception ex) {
        super(ex);
    }

}
