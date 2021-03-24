package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //this is where we add all related advices for logging
    
    //lets start with @Before advice
    
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}
    
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    private void getter() {}
    
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    private void setter() {}
    
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}
    
    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
	System.out.println("\n=====>>> Executing @Before advice on method");
    }
    
    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
	System.out.println("\n=====>>> Performing API analytics");
    }
}
