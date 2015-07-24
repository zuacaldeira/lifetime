/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.util;

import java.io.Serializable;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import lifetime.service.LifetimeAccountService;

/**
 *
 * @author zua
 */
@Stateless
@Remote
public class LifetimeLocator implements Serializable {
    
    private static final String JNDI_LIFETIME_ACCOUNT_SERVICE = "java:global/lifetime-ui/LifetimeAccountService!lifetime.service.LifetimeAccountBusiness";
    //private static final String JNDI_LIFETIME_ACCOUNT_SERVICE = "java:global/lifetime-ui/LifetimeAccountService";
    
    @Resource
    private SessionContext sessionContext;
    
    public SessionContext getSessionContext() {
        return sessionContext;
    }

    public LifetimeAccountService getLifetimeAccountServiceBean() {
        return (LifetimeAccountService) sessionContext.lookup(JNDI_LIFETIME_ACCOUNT_SERVICE);
    }
    
    
    
}
