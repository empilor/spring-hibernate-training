package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemoApp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			int deleteInstructorId = 1;
			Instructor theInstructor = session.get(Instructor.class, deleteInstructorId);
			System.out.println("Found instructor: " + theInstructor);

			if (theInstructor != null) {
				System.out.println("Delete the instructor with id=" + deleteInstructorId);
				session.delete(theInstructor);
			} else {
				System.out.println("Nothing to delete");
			}

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
