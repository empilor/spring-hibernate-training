package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemoApp {

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
	    System.out.println("Mary's courses: " + maryStudent.getCourses());
	    
	    // create more courses
	    Course tempCourse1 = new Course("Rubik's Cude - How To Speed Cube");
	    Course tempCourse2 = new Course("Atari 2600 - Game Development");
	    
	    tempCourse1.addStudent(maryStudent);
	    tempCourse2.addStudent(maryStudent);
	    // save the course...
	    System.out.println("Saving the courses...");
	    session.save(tempCourse1);
	    session.save(tempCourse2);
	    
	    session.getTransaction().commit();

	    System.out.println("Done!");
	} finally {
	    session.close();
	    factory.close();
	}

    }

}
