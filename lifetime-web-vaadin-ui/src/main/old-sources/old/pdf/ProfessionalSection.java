/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.pdf;

import com.itextpdf.text.Chapter;
import java.util.List;
import lifetime.business.persistence.Professional;

/**
 *
 * @author azc
 */
public class ProfessionalSection extends Chapter {
    private final List<Professional> achievements;

    public ProfessionalSection(List<Professional> achievements) {
        super("Professional Experience", 0);
        this.achievements = achievements;
    }
    
}
