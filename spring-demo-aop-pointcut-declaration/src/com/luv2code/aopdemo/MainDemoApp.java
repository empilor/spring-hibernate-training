package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

    /**
     * @param args
     */
    public static void main(String...args) {

	// read the Spring config java class
	AnnotationConfigApplicationContext context = 
		new AnnotationConfigApplicationContext(DemoConfig.class);

	// get the account bin from the container
	AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
	
	//get the membership bin from the container
	MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

	// call the business method
	Account theAccount = new Account();
	theAccountDAO.addAccount(theAccount, true);
	
	//do work
	theAccountDAO.doWork();
	
	//and now let's call addAccount in another class - MembershipDAO
	System.out.println("\n\nlet's call membership");
	System.out.println(membershipDAO.addSillyMember());
	
	//go to sleep
	membershipDAO.goToSleep();

	// close the context
	context.close();
    }

}
