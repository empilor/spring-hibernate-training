package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsBeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

		boolean result = (theCoach == alphaCoach);

		System.out.println("\nPointing on the same object: " + result);

		System.out.println("theCoach object: " + theCoach);

		System.out.println("alphaCoach object: " + alphaCoach);

		context.close();
	}

}
