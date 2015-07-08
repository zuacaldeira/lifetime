/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import old.ui.label.KeyLabel;
import old.ui.label.LifetimeLabel;
import com.vaadin.ui.HorizontalLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author azc
 */
public class LifetimeDates extends HorizontalLayout {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM yyyy");

    private KeyLabel fromKey;
    private LifetimeLabel from;
    private KeyLabel endKey;
    private LifetimeLabel until;

    public LifetimeDates(Date start, Date end, String language) {
        setSpacing(true);
        if(start != null) {
            fromKey = new KeyLabel("from", language);
            from = new LifetimeLabel(dateFormat.format(start), language);
            addComponents(fromKey, from);
        }
        if(end != null) {
            endKey = new KeyLabel("until", language);
            until = new LifetimeLabel(dateFormat.format(end), language);
            addComponents(endKey, until);
        }
    }
    
}
