/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.pdf;

import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;

/**
 *
 * @author azc
 */
public class ValuePhrase extends Phrase {

    public ValuePhrase(String string) {
        this(string, LifetimeFonts.FONT_DEFAULT);
    }
    public ValuePhrase(String string, Font font) {
        super(string + " ", font);
    }
}
