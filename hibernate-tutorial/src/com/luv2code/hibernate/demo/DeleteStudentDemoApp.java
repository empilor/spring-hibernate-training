package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemoApp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;

			session = factory.getCurrentSession();
			session.beginTransaction();

//			System.out.println("Getting student with id:" + studentId);
//			Student myStudent = session.get(Student.class, studentId);
//
//			System.out.println("Deleting student: " + myStudent);
//			session.delete(myStudent);

			System.out.println("Deleting student with id=2");
			session.createQuery("delete from Student s where s.id=2").executeUpdate();

			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}
