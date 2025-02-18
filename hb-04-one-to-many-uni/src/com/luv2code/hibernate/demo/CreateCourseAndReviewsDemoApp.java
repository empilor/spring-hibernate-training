package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemoApp {

    public static void main(String[] args) {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
		.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
		.addAnnotatedClass(Review.class).buildSessionFactory();

	Session session = factory.getCurrentSession();

	try {
	    session.beginTransaction();

	    // create a course
	    Course tempCourse = new Course("Pacman - How To Score One Million Points");

	    // add some reviews
	    tempCourse.addReview(new Review("Great course, loved it!"));
	    tempCourse.addReview(new Review("Cool course, job well done"));
	    tempCourse.addReview(new Review("What a dumb course, u're an idiot!"));

	    // save the course...
	    System.out.println("Saving the course: " + tempCourse);
	    System.out.println("Included reviews: " + tempCourse.getReviews());
	    session.save(tempCourse);

	    session.getTransaction().commit();

	    System.out.println("Done!");
	} finally {
	    session.close();
	    factory.close();
	}

    }

}
