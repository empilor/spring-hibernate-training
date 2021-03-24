package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private static Logger logger = Logger.getLogger(MyDemoLoggingAspect.class.getName());

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n====>>> Executing @Around on method: " + method);

        long startTime = System.currentTimeMillis();

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            logger.warning(e.getMessage());
//            result = "Major accident! But no worries, " +
//                    "your private AOP helicopter is on the way!";
            throw e;
        }

        long endTime = System.currentTimeMillis();

        long workTime = endTime - startTime;
        logger.info("\n====>>> Work time: " + workTime / 1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====>>> Executing @After (finally) on method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====>>> Executing @AfterThrowing on method: " + method);

        //log the exception
        logger.info("\n====>>> The exception is : " + theExc);
    }

    //add a new advice for @AfterReturning
    @AfterReturning(
            pointcut = "execution (* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        //print out whick metod we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n=====>>> Executing @AfterReturning on method: " + method);

        //modify result - names to upper case
        result.stream().forEach(account -> {
            String upperName = account.getName().toUpperCase();
            account.setName(upperName);
        });

        //print out the result of the method call
        logger.info("\n=====>>> result is: " + result);
    }

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        logger.info("\n=====>>> Executing @Before advice on method");

        //display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        logger.info("Method: " + methodSignature);

        //display method arguments
        Object[] args = theJoinPoint.getArgs();

        logger.info("\tMethod arguments:");
        for (Object arg : args) {
            logger.info("\t\t" + arg);
            if (arg instanceof Account) {
                Account tempAccount = (Account) arg;
                logger.info("\t\t\tAccount name: " + tempAccount.getName());
                logger.info("\t\t\tAccount level: " + tempAccount.getLevel());
            }
        }
    }
}
