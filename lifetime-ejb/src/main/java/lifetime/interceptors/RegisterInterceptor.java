/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import lifetime.service.RegisterException;

/**
 *
 * @author zua
 */
@Interceptor
public class RegisterInterceptor {
    
    
    @AroundInvoke
    public Object interceptRegisterRequest(InvocationContext ctx) throws RegisterException {
        try {
        return ctx.proceed();
        } catch(Exception ex) {
            throw new  RegisterException(ex);
        }
    }
}
