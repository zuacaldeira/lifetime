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
public class LevelPhrase extends Phrase {

    public LevelPhrase(String level) {
        super(String.format("%5s ", level), LifetimeFonts.FONT_KEY);        
    }
    
}
