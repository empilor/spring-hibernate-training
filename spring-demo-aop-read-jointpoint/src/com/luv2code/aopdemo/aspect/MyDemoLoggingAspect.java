package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on method");

        //display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        //display method arguments
        Object[] args = theJoinPoint.getArgs();

        System.out.println("\tMethod arguments:");
        for (Object arg : args) {
            System.out.println("\t\t" + arg);
            if (arg instanceof Account) {
                Account tempAccount = (Account) arg;
                System.out.println("\t\t\tAccount name: " + tempAccount.getName());
                System.out.println("\t\t\tAccount level: " + tempAccount.getLevel());
            }
        }
    }
}
