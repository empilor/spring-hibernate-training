package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class DeleteCourseAndReviewsDemoApp {

    public static void main(String[] args) {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
		.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
		.addAnnotatedClass(Review.class).buildSessionFactory();

	Session session = factory.getCurrentSession();

	try {
	    session.beginTransaction();

	    int theId = 10;
	    Course tempCourse = session.get(Course.class, theId);

	    System.out.println("Deleting the course...");
	    System.out.println(tempCourse);

	    System.out.println(tempCourse.getReviews());

	    session.delete(tempCourse);

	    session.getTransaction().commit();

	    System.out.println("Done!");
	} finally {
	    session.close();
	    factory.close();
	}

    }

}
