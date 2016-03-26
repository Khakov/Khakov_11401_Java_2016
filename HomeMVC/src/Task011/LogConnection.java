package Task011;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.net.InetAddress;

/**
 * Created by Rus on 22.03.2016.
 */
public class LogConnection implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        if (methodInvocation.getMethod().getName().equals("connecion")) {
            InetAddress ia = (InetAddress) methodInvocation.getArguments()[0];
            if(ia==null){
                System.out.println("Client try connect to localhost");
                return null;
            }
        }
        return methodInvocation.proceed();
    }
}
