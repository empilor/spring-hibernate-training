package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteMaryStudentDemoApp {

    public static void main(String[] args) {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
		.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
		.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

	Session session = factory.getCurrentSession();

	try {
	    session.beginTransaction();

	    // create a course
	    int studentId = 2;
	    Student maryStudent = session.get(Student.class, studentId);
	    
	    // save the course...
	    System.out.println("\nLoaded student: " + maryStudent);
	    System.out.println("Student's courses: " + maryStudent.getCourses());
	    
	    // delete student
	    System.out.println("Deleting the student: " + maryStudent);
	    session.delete(maryStudent);
	    
	    session.getTransaction().commit();

	    System.out.println("Done!");
	} finally {
	    session.close();
	    factory.close();
	}

    }

}
