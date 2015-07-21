/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.slf4j.Logger;

/**
 *
 * @author zua
 */
@Interceptor
public class LoggerInterceptor {

    /**
     * sl4j Logger
     */
    private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(LoggerInterceptor.class);

    @AroundInvoke
    public Object log(InvocationContext ctx) throws Exception {
        Object target = ctx.getTarget();
        Object method = ctx.getMethod();
        Object[] parameters = ctx.getParameters();
        LOGGER.info("Executing client request: " + target + "." + method + "(" + parameters + ")");
        return ctx.proceed();
    }

}
