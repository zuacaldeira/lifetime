/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import lifetime.backend.service.RegistrationService;

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
     * Returns an instance to the back-end lifetime account service.
     *
     * @return An instance of {@link RegistrationService}
     */
    public static RegistrationService findLifetimeAccountService() {
        return (RegistrationService) lookupService(JNDI_LIFETIME_ACCOUNT_BUSINESS);
    }

    private static Object lookupService(String name) {
        try {
            Context context = new InitialContext();
            return (RegistrationService) context.lookup(name);
        } catch (Exception ex) {
            Logger.getLogger(ServiceLocator.class.getName()).log(Level.SEVERE, "Lookup failed for {0}", name);
        }
        return null;
    }

}
