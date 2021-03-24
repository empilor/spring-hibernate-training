package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    //add a new advice for @AfterReturning
    @AfterReturning(
            pointcut = "execution (* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        //print out whick metod we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        //modify result - names to upper case
        result.stream().forEach(account -> {
            String upperName = account.getName().toUpperCase();
            account.setName(upperName);
        });

        //print out the result of the method call
        System.out.println("\n=====>>> result is: " + result);
    }

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
