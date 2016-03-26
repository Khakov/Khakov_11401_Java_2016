package Task013;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rus on 21.03.2016.
 */
@Aspect
public class LogEmail {
    @Before("execution(* *..*.setEmail(String))")
    public void loggingEmail(JoinPoint jp) {
        String lang = jp.getArgs()[0].toString();
        System.out.println(lang);
        Pattern pattern = Pattern.compile("((([a-zA-Z0-9]+)(\\.?)([a-zA-Z0-9]+))+)@(([A-Za-z]{2,}\\.)+)([a-z]{2,})");
        Matcher matcher = pattern.matcher(lang);
        if (matcher.find()) {
            System.out.println("Correct e-mail");
        } else {
            System.out.println("Incorrect e-mail");
        }
    }
}
