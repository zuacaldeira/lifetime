/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

/**
 *
 * @author zua
 */
public class DeleteEntityException extends RuntimeException {

    public DeleteEntityException(Exception ex) {
        super(ex);
    }
    
}
