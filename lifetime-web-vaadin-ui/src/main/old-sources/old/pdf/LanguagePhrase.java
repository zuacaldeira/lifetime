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
public class LanguagePhrase extends Phrase {

    public LanguagePhrase(String string) {
        super(String.format("%s ", string), LifetimeFonts.FONT_BOLD);
    }

}
