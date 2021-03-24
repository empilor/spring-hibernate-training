package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CrmLoggingAspect {
    private static final Logger LOGGER = Logger.getLogger(CrmLoggingAspect.class.getName());

    @Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
    private void forControllerPackage() { }

    @Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
    private void forServicePackage() { }

    @Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
    private void forDaoPackage() { }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() { }

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String theMethod = joinPoint.getSignature().toShortString();
        LOGGER.info("=====>> in @Before advice, method: " + theMethod);

        //display the arguments

        //get the arguments
        Object[] args = joinPoint.getArgs();

        //loop thru and display args
        for(Object tempArg: args) {
            LOGGER.info("=====>> argument: " + tempArg);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult"
    )
    public void afterReturning(JoinPoint joinPoint, Object theResult) {
        String theMethod = joinPoint.getSignature().toShortString();
        LOGGER.info("=====>> in @AfterReturning: from method: " + theMethod);

        //display data returned
        LOGGER.info("=====>> result: " + theResult);
    }
}