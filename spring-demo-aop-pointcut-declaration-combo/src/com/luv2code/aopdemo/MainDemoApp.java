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

	// call the business method and do work
	Account theAccount = new Account();
	theAccountDAO.addAccount(theAccount, true);
	theAccountDAO.doWork();
	
	//set params and then get them
	theAccountDAO.setName("foobar");
	theAccountDAO.setServiceCode("silver");
	
	String name = theAccountDAO.getName();
	String code = theAccountDAO.getServiceCode();
	
	//and now let's call addAccount in another class - MembershipDAO
	System.out.println("\n\nlet's call membership");
	System.out.println(membershipDAO.addSillyMember());
	
	//go to sleep
	membershipDAO.goToSleep();

	// close the context
	context.close();
    }

}
