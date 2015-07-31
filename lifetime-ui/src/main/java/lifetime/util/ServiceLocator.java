/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import lifetime.service.LifetimeAccountBusiness;

/**
 *
 * @author azc
 */
public final class ServiceLocator {

    public static final String JNDI_LIFETIME_ACCOUNT_BUSINESS = "java:global/lifetime-ui/LifetimeAccountService!lifetime.service.LifetimeAccountBusiness";

    private ServiceLocator() {
    }

    
    public static LifetimeAccountBusiness findLifetimeAccountService() {
        return (LifetimeAccountBusiness) lookupService(JNDI_LIFETIME_ACCOUNT_BUSINESS);
    }
    
    private static Object lookupService(String name) {
        try {
            Context context = new InitialContext();
            return (LifetimeAccountBusiness) context.lookup(name);
        } catch(NamingException ex) {
            throw new ServiceLookupException(ex);
        }
    }

}
