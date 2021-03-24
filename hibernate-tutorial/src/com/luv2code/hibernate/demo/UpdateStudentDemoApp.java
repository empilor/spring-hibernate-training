package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemoApp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;

			session.beginTransaction();

			System.out.println("Getting student with id:" + studentId);

			Student myStudent = session.get(Student.class, studentId);

			System.out.println("Updating student...");
			myStudent.setFirstName("Scooby");

			session.getTransaction().commit();

			System.out.println("Done!");

			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Update email for all students");

			session.createQuery("update Student s set email='foo@gmail.com'").executeUpdate();

			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}
