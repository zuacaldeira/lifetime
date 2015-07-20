/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.util;

import javax.ejb.EJB;
import lifetime.service.LifetimeAccountBusiness;

/**
 *
 * @author azc
 */
public class ServiceLocator {

    public static final String LIFETIME_ACCOUNT_BUSINESS_JNDI = "java:global/lifetime-ui/LifetimeAccountService!lifetime.service.LifetimeAccountBusiness";

    @EJB(beanName = "LifetimeAccountService")
    private static LifetimeAccountBusiness accountService;

    public static LifetimeAccountBusiness findLifetimeAccountService() {
        return accountService;
    }

}
