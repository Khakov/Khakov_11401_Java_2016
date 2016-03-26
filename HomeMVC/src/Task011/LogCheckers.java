package Task011;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Rus on 22.03.2016.
 */
public class LogCheckers implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        if (methodInvocation.getMethod().getName().equals("setJump")) {
            int i = (Integer)methodInvocation.getArguments()[0];
            int j = (Integer)methodInvocation.getArguments()[1];
            if(i==j){
                System.out.println("i and j don't be equals!!!");
                return null;
            }
        }
        return methodInvocation.proceed();
    }
}
