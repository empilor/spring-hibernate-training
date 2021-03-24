package com.luv2code.hibernate.demo.chapter21;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.chapter21.entity.Employee;

public class PracticeDemoApp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		try {
//			createEmployees(factory);

			int readEmployeeId = 2;
			readEmployee(factory, readEmployeeId);

			getEmployeeByCompany(factory);

			int deleteEmployeeId = 3;
//			deleteEmployee(factory, deleteEmployeeId);

		} finally {
			factory.close();
		}

	}

	private static void deleteEmployee(SessionFactory factory, int deleteEmployeeId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		System.out.println("Deleting employee with id=" + deleteEmployeeId);
		session.createQuery("delete from Employee where id=3").executeUpdate();
		System.out.println("An employee with id=3 has been deleted. Check via reading this employee from DB:");
		session.getTransaction().commit();
		readEmployee(factory, deleteEmployeeId);
	}

	private static void getEmployeeByCompany(SessionFactory factory) {
		System.out.println("Retrieve employees by company='FutureResistance'");
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Employee> myEmployees = session.createQuery("from Employee e where e.company='Marswalkers&Co'")
				.getResultList();
		System.out.println("Retrieved employees by company='Marswalkers&Co':\n" + myEmployees);
		session.getTransaction().commit();
	}

	private static void readEmployee(SessionFactory factory, int employeeId) {
		System.out.println("Retrieve employee by id=" + employeeId);
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Employee theEmployee = session.get(Employee.class, employeeId);
		System.out.println("Retrieved employee: " + theEmployee);
		session.getTransaction().commit();
	}

	private static void createEmployees(SessionFactory factory) {
		System.out.println("Create new employees...");
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		// create new employees
		Employee employee1 = new Employee("Jack", "Harper", "Marswalkers&Co");
		Employee employee2 = new Employee("John", "Connor", "FutureResistance");
		Employee employee3 = new Employee("Arnold", "Swarzenegger", "Terminator Ltd.");

		// save new objects to database
		System.out.println("Save new employee objects..");
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		session.getTransaction().commit();
	}

}
