package Task013;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Rus on 21.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Task013/spring-config-email.xml");
        Email email = ac.getBean(Email.class);
        email.setEmail("aa.f@mail.ru");
    }
}
