package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemoApp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("Creating new student objects...");
			Student student1 = new Student("John", "Doe", "johndoe@com.luv2code.com");
			Student student2 = new Student("Mary", "Public", "mary@com.luv2code.com");
			Student student3 = new Student("Bonita", "Applebum", "applebum@com.luv2code.com");

			System.out.println("Opening new transaction...");
			session.beginTransaction();

			System.out.println("Saving new students...");
			session.save(student1);
			session.save(student2);
			session.save(student3);

			System.out.println("Commit saving new student...");
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
