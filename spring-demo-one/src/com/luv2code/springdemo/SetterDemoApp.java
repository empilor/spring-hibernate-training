package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);

		System.out.println(theCoach.getDailyFortune());

		System.out.println(theCoach.getDailyWorkout());

		System.out.println("Email address is: " + theCoach.getEmailAddress());

		System.out.println("Team is: " + theCoach.getTeam());

		context.close();
	}

}
