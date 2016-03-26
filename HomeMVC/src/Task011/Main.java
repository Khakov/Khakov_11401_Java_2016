package Task011;

import org.springframework.aop.framework.ProxyFactory;

import java.io.IOException;

/**
 * Created by Rus on 22.03.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Checkers checkers = new Checkers(8,1,2);//добавил проверку  на 2 метода игры
        ProxyFactory pf = new ProxyFactory(checkers);
        pf.addAdvice(new LogCheckers());
        pf.addAdvice(new BeforeCheckers());
        checkers = (Checkers) pf.getProxy();
        Client client = new Client();
        ProxyFactory pf2 = new ProxyFactory(checkers);//попытка соединиться с сервером
        pf2.addAdvice(new LogConnection());
        pf2.addAdvice(new BeforeConnect());
        client = (Client) pf2.getProxy();
        client.connection(null);
    }
}
