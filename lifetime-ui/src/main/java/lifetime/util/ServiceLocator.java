/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import lifetime.backend.exceptions.ServiceLookupException;
import lifetime.backend.service.LifetimeAccountService;

/**
 *
 * @author <a href="mailto:zuacaldeira@gmail.com">Alexandre Caldeira</a>
 */
public final class ServiceLocator {

    /**
     *
     */
    public static final String JNDI_LIFETIME_ACCOUNT_BUSINESS = "java:global/lifetime-ui/LifetimeAccountService";

    private ServiceLocator() {
    }

    /**
     *
     * @return
     */
    public static LifetimeAccountService findLifetimeAccountService() {
        return (LifetimeAccountService) lookupService(JNDI_LIFETIME_ACCOUNT_BUSINESS);
    }
    
    private static Object lookupService(String name) {
        try {
            Context context = new InitialContext();
            return (LifetimeAccountService) context.lookup(name);
        } catch(NamingException ex) {
            throw new ServiceLookupException(ex);
        }
    }

}
