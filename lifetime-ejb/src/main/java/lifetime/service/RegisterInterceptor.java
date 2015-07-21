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
public class RegisterInterceptor {

    /**
     * sl4j Logger
     */
    private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ExceptionHandlerInterceptor.class);

    @AroundInvoke
    public Object interceptRegistration(InvocationContext ctx) throws Exception {
        try {
            return ctx.proceed();
        } catch (Exception ex) {
            LOGGER.error("Problem during method invocation: " + ctx.getMethod());
            LOGGER.error("\tCause" + ex.getLocalizedMessage());
            return false;
        }
    }
}
