package com.jbk.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Customer login(Customer customer) {

		Session session = sf.openSession();
		try {
			Customer cust = session.get(Customer.class, customer.getUsername());
			if (cust.getPassword().equals(customer.getPassword())) {
				return cust;
			}
		} catch (Exception e) {

		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean saveCustomer(Customer customer) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		boolean issAdded = false;
		try {
			// check customer is already exist or not

			Customer cust = session.get(Customer.class, customer.getUsername());
			if (cust == null) {
				session.save(customer);
				transaction.commit();
				issAdded = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return issAdded;
	}

	@Override
	public List<Customer> getAllCustomer() {
		Session session = sf.openSession();
		List<Customer> list = null;
		try {
			Criteria criteria = session.createCriteria(Customer.class);
			list = criteria.list(); //select * from customer       // FROM Customer
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public boolean deleteCustomer(String username) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isDeleted = false;
		try {
			Customer customer = session.get(Customer.class, username); // select * from customer where usrname=?
			session.delete(customer);
			transaction.commit();
			isDeleted = true;     // if not getting any exception
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isDeleted;
	}

	@Override
	public Customer getProfile(String username) {
		Session session = sf.openSession();
		Customer customer = null;
		try {
			customer = session.get(Customer.class, username);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return customer;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isUpdated = false;
		try {
			session.update(customer);
			transaction.commit();
			isUpdated = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isUpdated;
	}

}
