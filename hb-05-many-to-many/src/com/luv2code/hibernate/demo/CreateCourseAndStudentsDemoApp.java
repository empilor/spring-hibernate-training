package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemoApp {

    public static void main(String[] args) {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
		.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
		.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

	Session session = factory.getCurrentSession();

	try {
	    session.beginTransaction();

	    // create a course
	    Course tempCourse = new Course("Pacman - How To Score One Million Points");
	    
	    // save the course...
	    System.out.println("Saving the course: " + tempCourse);
	    session.save(tempCourse);
	    
	    // add students to the course
	    Student tempStudent1 = new Student("John","Doe","john.doe@com.luv2code.com");
	    Student tempStudent2 = new Student("Mary","Public","mary.public@com.luv2code.com");
	    
	    tempCourse.addStudent(tempStudent1);
	    tempCourse.addStudent(tempStudent2);
	    
	    System.out.println("Saving the students...");
	    session.save(tempStudent1);
	    session.save(tempStudent2);
	    System.out.println("Saved students: " + tempCourse.getStudents());
	    
	    session.getTransaction().commit();

	    System.out.println("Done!");
	} finally {
	    session.close();
	    factory.close();
	}

    }

}
