package Task011;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Rus on 22.03.2016.
 */
public class BeforeConnect implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        if (method.getName().equals("connection"))
            System.out.println("Client try connect with server");
        else
            System.out.println("Method " + method.getName() + " is called ");
    }
}
