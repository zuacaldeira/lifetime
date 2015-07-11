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

    // public static final String LIFETIME_BUSINESS_PRODUCTION = "java:global/lifetime-web-vaadin_-_lifetime-web-vaadin-production/LifetimeService!lifetime.business.logic.LifetimeBusiness";
    // public static final String LIFETIME_BUSINESS = "java:global/lifetime-web-vaadin-ui/LifetimeService!lifetime.business.logic.LifetimeBusiness";
    //private static LifetimeBusiness service;
    //private static LifetimeBusiness serviceProduction;
    private static LifetimeAccountBusiness accountService;
    public static final String LIFETIME_ACCOUNT_BUSINESS = "java:global/lifetime-web-vaadin-ui/LifetimeAccountService!lifetime.service.LifetimeAccountBusiness";

    public static LifetimeAccountBusiness findLifetimeAccountService() {
        if (accountService == null) {
            try {
                Context context = new InitialContext();
                accountService = (LifetimeAccountBusiness) context.lookup(LIFETIME_ACCOUNT_BUSINESS);
                return accountService;
            } catch (NamingException ex) {
                //Logger.getLogger(ServiceLocator.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        } else {
            return accountService;
        }
    }

}
