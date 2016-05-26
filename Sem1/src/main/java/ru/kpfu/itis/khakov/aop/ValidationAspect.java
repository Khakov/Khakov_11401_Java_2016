package ru.kpfu.itis.khakov.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by Rus on 06.05.2016.
 */
@Aspect
public class ValidationAspect {
    @Around("execution(* ru.kpfu.itis.khakov.service.*.*(..))")
    public Object valid(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i<args.length; i++) {
            if(args[i] instanceof String)
            args[i] = validation((String) args[i]);
        }
        return joinPoint.proceed(args);
    }
    public String validation(String string) {
        if (string != null) {
            string = string.replaceAll("&", "&#38");
            string = string.replaceAll(">", "&gt");
            string = string.replaceAll("<", "&lt");
        }
        System.out.println(string);
        return string;
    }
}
