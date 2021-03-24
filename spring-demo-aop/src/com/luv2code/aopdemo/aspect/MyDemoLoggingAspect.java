package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //this is where we add all related advices for logging
    
    //lets start with @Before advice
    
    @Before("execution(* com.com.luv2code.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
	System.out.println("\n=====>>> Executing @Before advice on method");
    }
}
