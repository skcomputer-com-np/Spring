package com.sk.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sk.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	//@Transactional // commented because we add new layer called service
	@Override
	public List<Customer> getCustomers() {

		// get current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create query... order by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		// execute and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the result 
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theID) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer = currentSession.get(Customer.class, theID);
		return customer;
	}

	@Override
	public void deleteCustomer(int theID) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Customer where id =:customerID");
		theQuery.setParameter("customerID", theID);
		theQuery.executeUpdate();	
	}

}







