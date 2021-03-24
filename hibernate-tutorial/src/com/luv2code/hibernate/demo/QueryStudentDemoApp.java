package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemoApp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			System.out.println("Saving new student...");
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			displayStudents(theStudents);

			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			System.out.println("\nThe students who have lastName='Doe':");
			displayStudents(theStudents);

			theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'")
					.getResultList();
			System.out.println("\nThe students who have lastName='Doe' or firstName='Daffy':");
			displayStudents(theStudents);

			theStudents = session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();
			System.out.println("\nThe students who have email like %gmail.com:");
			displayStudents(theStudents);

			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}
}
