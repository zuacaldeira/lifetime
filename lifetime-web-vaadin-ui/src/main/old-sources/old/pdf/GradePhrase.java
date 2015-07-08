/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.pdf;

import com.itextpdf.text.Phrase;

/**
 *
 * @author azc
 */
public class GradePhrase extends Phrase {

    public GradePhrase(String string) {
        super(getGradeString(string), LifetimeFonts.FONT_GRADE);
    }
    
    private static String getGradeString(String aString) {
        if(aString.equalsIgnoreCase("Mother Language")) {
            return "ML";
        }
        else {
            return aString;
        }
    }
}
