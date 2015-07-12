/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.pdf;

/**
 *
 * @author azc
 */
public class KeyPhrase extends LifetimePhrase {

    public KeyPhrase(String key, String language) {
        super(String.format("%s", key), language, LifetimeFonts.FONT_KEY);
    }
    
}
