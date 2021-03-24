package com.luv2code.springdemo.step95;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.springdemo.Coach;

public class NinetyFiveAnnotationDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RunConfig.class);

		Coach theCoach = context.getBean("runCoach", Coach.class);

		System.out.println("\n");

		System.out.println(theCoach.getDailyFortune());

		System.out.println(theCoach.getDailyWorkout());

		System.out.println("\n");

	}

}
