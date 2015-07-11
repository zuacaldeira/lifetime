/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author azc
 */
@Singleton
@Startup
public class NumberOfUsersTracker  {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Schedule(second = "*")
    private void updateNumberOfUsers() {
        System.out.println("************ Counting number of users ***************");
        System.out.println("************ #users = ");
        System.out.println("************ Counting number of users ***************");        
    }
}
