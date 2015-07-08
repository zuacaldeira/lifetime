/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.business.util;

import java.util.Date;

/**
 *
 * @author azc
 */
public interface LifetimeAchievement {
    Date getStart();
    Date getEnd();
    String getTitle();
    String getDescription();
    String getOrganization();
}
