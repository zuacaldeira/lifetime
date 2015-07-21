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
public class UrlPhrase extends Phrase {

    public UrlPhrase(String string) {
        super(string, LifetimeFonts.FONT_URL);
    }
}
