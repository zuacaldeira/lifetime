/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.textField;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;

/**
 *
 * @author azc
 */
public class HorizontalLine extends Label {

    public HorizontalLine() {
        super("<hr />", ContentMode.HTML);
        setStyleName("hline");
    }
}
