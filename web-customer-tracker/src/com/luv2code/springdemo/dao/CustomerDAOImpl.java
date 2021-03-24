package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
	//get Hibernate current session
	Session currentSession = sessionFactory.getCurrentSession();
	
	//create a query
	Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);
	
	//execute result query and get result list
	List<Customer> customers = query.getResultList();
	
	//return the results
	return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
	// get Hibernate current session
	Session currentSession = sessionFactory.getCurrentSession();
	
	//save/update the customer
	currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
	// get Hibernate current session
	Session currentSession = sessionFactory.getCurrentSession();
	
	//get the customer from DB
	Customer theCustomer = currentSession.get(Customer.class, theId);
	
	
	return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {
	// get Hibernate current session
	Session currentSession = sessionFactory.getCurrentSession();
	
	//delete the customer from DB
	Query theQuery = currentSession.createQuery("delete from Customer where id = :customerId");
	
	theQuery.setParameter("customerId", theId);
	
	theQuery.executeUpdate();
    }
}
