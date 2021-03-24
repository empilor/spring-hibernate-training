package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		Coach theCoach = context.getBean("swimCoach", Coach.class);

		System.out.println("\n" + theCoach.getDailyWorkout());

		System.out.println(theCoach.getDailyFortune());

		System.out.println(theCoach.toString() + "\n");

		context.close();
	}

}
