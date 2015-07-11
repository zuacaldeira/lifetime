/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import lifetime.service.LifetimeAccountService;
import old.LifetimeBusiness;

/**
 *
 * @author azc
 */
public class ServiceLocator {

    public static final String LIFETIME_BUSINESS_PRODUCTION = "java:global/lifetime-web-vaadin_-_lifetime-web-vaadin-production/LifetimeService!lifetime.business.logic.LifetimeBusiness";
    public static final String LIFETIME_BUSINESS = "java:global/lifetime-web-vaadin-ui/LifetimeService!lifetime.business.logic.LifetimeBusiness";
    public static final String LIFETIME_ACCOUNT_SERVICE = "java:global/lifetime-web-vaadin-ui/LifetimeAccountService!lifetime.business.logic.LifetimeAccountService";
    private static LifetimeBusiness service;
    private static LifetimeBusiness serviceProduction;
    private static LifetimeAccountService accountService;

    private static boolean findProductionLifetimeService() {
        if (serviceProduction != null) {
            return true;
        } else {
            try {
                Context context = new InitialContext();
                serviceProduction = (LifetimeBusiness) context.lookup(LIFETIME_BUSINESS_PRODUCTION);
                return serviceProduction != null;
            } catch (NamingException ex) {
                //Logger.getLogger(ServiceLocator.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
    }

    private static boolean findDevelopmentLifetimeService() {
        if (service == null) {
            try {
                Context context = new InitialContext();
                service = (LifetimeBusiness) context.lookup(LIFETIME_BUSINESS);
                return service != null;
            } catch (NamingException ex) {
                //Logger.getLogger(ServiceLocator.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            return true;
        }
    }

    public static LifetimeBusiness findLifetimeService() {
        if (findProductionLifetimeService()) {
            return serviceProduction;
        }
        else if (findDevelopmentLifetimeService()) {
            return service;
        }
        throw new UnavailableServiceException(LIFETIME_BUSINESS);
    }

    public static LifetimeAccountService findLifetimeAccountService() {
        if (accountService == null) {
            try {
                Context context = new InitialContext();
                accountService = (LifetimeAccountService) context.lookup(LIFETIME_ACCOUNT_SERVICE);
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
