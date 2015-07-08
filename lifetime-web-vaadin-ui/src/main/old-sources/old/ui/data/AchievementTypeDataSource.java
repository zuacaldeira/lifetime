/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.data;

import com.vaadin.data.util.IndexedContainer;
import java.util.Arrays;

/**
 *
 * @author azc
 */
public class AchievementTypeDataSource extends IndexedContainer {
    public AchievementTypeDataSource() {
        super(Arrays.asList(AchievementCategory.values()));
    }
    
}
