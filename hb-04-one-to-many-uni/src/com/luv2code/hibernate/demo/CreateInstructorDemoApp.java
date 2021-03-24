package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemoApp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			System.out.println("Creating new instructor...");
			Instructor tempInstructor = new Instructor("Susan", "Public", "susan.public@com.luv2code.com");
			System.out.println("Creating new instructor details...");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Video Games");
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			System.out.println("Creating new course...");

			System.out.println("Saving new instructor: " + tempInstructor);
			session.save(tempInstructor);

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}

	}

}
