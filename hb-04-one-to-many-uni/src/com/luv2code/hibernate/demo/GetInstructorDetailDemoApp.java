package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemoApp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			int theId = 2999;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
			System.out.println("Retrieved insDet: " + instructorDetail);
			Instructor instructor = instructorDetail.getInstructor();
			System.out.println("Associated instructor: " + instructor);

			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
