/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import lifetime.exceptions.LifetimeSecurityException;
import org.slf4j.Logger;

/**
 * @author zua
 */
@Interceptor
public class ExceptionHandlerInterceptor {
    /**
     * sl4j Logger
     */
    private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ExceptionHandlerInterceptor.class);

    @AroundInvoke
    public Object handleException(InvocationContext ctx) throws Exception {
        try {
            return ctx.proceed();
        } catch (Exception ex) {
            LOGGER.error("Exception: " + ex.getMessage());
            throw new LifetimeSecurityException("Problems during bean method invocation", ex);
        }
    }
}
