/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lifetime
 */
@Stateless
@LocalBean
public class AchievementStatusTimer {
    @EJB
    private LifetimeBusiness service;
    
    @PersistenceContext(unitName = "lifetimePU", name = "jdbc/lifetime")
    private EntityManager em;
    
// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Schedule(hour = "*")
    private void setNullStatusToCreated() {
        // Find all achievements with
    }
}
