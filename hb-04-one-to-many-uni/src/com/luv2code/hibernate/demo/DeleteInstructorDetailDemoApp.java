package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemoApp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			int theId = 3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
			System.out.println("Retrieved insDet: " + instructorDetail);

			System.out.println("Associated instructor: " + instructorDetail.getInstructor());

			// remove associated link
			instructorDetail.getInstructor().setInstructorDetail(null);
			System.out.println("Deleting insDetail: " + instructorDetail);
			session.delete(instructorDetail);

			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception ex) {
			System.out.println("\nInside the CATCH block");
			ex.printStackTrace();
		} finally {
			System.out.println("\nInside the FINALLY block");
			session.close();
			factory.close();
		}

	}

}
