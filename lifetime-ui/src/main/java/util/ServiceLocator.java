/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import lifetime.service.LifetimeAccountBusiness;

/**
 *
 * @author azc
 */
public class ServiceLocator {

    private static LifetimeAccountBusiness accountService;
    public static final String LIFETIME_ACCOUNT_BUSINESS = "java:global/lifetime-ui/LifetimeAccountService!lifetime.service.LifetimeAccountBusiness";

    public static LifetimeAccountBusiness findLifetimeAccountService() throws NamingException {
        if (accountService == null) {
            Context context = new InitialContext();
            accountService = (LifetimeAccountBusiness) context.lookup(LIFETIME_ACCOUNT_BUSINESS);
        }
        return accountService;
    }

}
