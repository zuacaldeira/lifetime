/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.interceptors;

import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author <a href="mailto:zuacaldeira@gmail.com">Alexandre Caldeira</a>
 */
@Interceptor
public class BooleanExceptionInterceptor {

    /**
     *
     * @param ctx
     * @return
     */
    @AroundInvoke
    public Object interceptServiceRequest(InvocationContext ctx) {
        try {
            return (Boolean) ctx.proceed();
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).info("Exception during service call...");
            return false;
        }
    }
}
