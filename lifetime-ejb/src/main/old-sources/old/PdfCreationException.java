/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import javax.ejb.ApplicationException;

/**
 *
 * @author azc
 */
@ApplicationException(rollback = true)
public class PdfCreationException extends Exception {

    public PdfCreationException() {
    }
    
}
