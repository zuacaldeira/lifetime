/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.pdf;

import com.itextpdf.text.Paragraph;
import lifetime.business.persistence.Academic;

/**
 *
 * @author azc
 */
public class AcademicParagraph extends Paragraph {
    private final Academic achievemeent;

    public AcademicParagraph(Academic achievement) {
        this.achievemeent = achievement;        
    }
    
}
