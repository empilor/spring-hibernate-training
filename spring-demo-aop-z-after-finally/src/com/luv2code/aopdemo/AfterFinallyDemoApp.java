package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {

    /**
     * @param args
     */
    public static void main(String... args) {

        // read the Spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the account bin from the container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        try {
            boolean tripWire = false;
            List<Account> theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("\nMain Program... caught exception " + e);
        }

        //display the accounts
        System.out.println("\n\nMain Program: AfterThrowingDemoApp");
        System.out.println("----");

        System.out.println("\n");

        // close the context
        context.close();
    }

}
