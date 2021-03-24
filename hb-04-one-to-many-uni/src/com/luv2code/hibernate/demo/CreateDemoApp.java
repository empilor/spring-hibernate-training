package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemoApp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			System.out.println("Creating new instructor object...");
//			Instructor tempInstructor = new Instructor("Chad", "Darby", "chad@com.luv2code.com");
//			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
//					"Luv 2 code!!!");
//			tempInstructor.setInstructorDetail(tempInstructorDetail);

			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@com.luv2code.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar!!!");
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			System.out.println("Saving new instructor: " + tempInstructor);
			session.save(tempInstructor);

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
