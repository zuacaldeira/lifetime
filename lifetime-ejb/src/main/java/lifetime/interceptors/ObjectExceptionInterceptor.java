/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.interceptors;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author zua
 */
@Interceptor
public class ObjectExceptionInterceptor {

    @AroundInvoke
    public Object interceptServiceRequest(InvocationContext ctx) {
        try {
            return ctx.proceed();
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.INFO, "Exception during service call...{0}", ex.getLocalizedMessage());
            return null;
        }
    }
}
