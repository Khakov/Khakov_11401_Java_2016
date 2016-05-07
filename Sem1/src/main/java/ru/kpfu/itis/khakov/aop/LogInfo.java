package ru.kpfu.itis.khakov.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Rus on 06.05.2016.
 */
@Aspect
public class LogInfo {
    private static Logger log = Logger.getLogger(LogInfo.class);

    @Before("execution(* ru.kpfu.itis.khakov.service.*.*(..))")
    public void logToInfoService(JoinPoint joinPoint) {
        log.info(new Date()
                + " Start invocation of service method"
                + joinPoint.getTarget().getClass().getSimpleName()
                + "."
                + joinPoint.getSignature().getName()
                + " with params:\n"
                + Arrays.toString(joinPoint.getArgs()));
    }
    @Around("execution(* ru.kpfu.itis.khakov.service.*.*(..))")
    public Object logToInfoTimeService(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object method = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long result = end - start;
        log.info("End invocation of service method: " + result + "ms");
        return method;
    }
}
