package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.CustomerDao;
import com.jbk.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao dao;

	@Override
	public Customer login(Customer customer) {
	
		return dao.login(customer);
	}

	@Override
	public boolean saveCustomer(Customer customer) {
		
		return dao.saveCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return dao.getAllCustomer();
	}

	@Override
	public boolean deleteCustomer(String username) {
		
		return dao.deleteCustomer(username);
	}

	@Override
	public Customer getProfile(String username) {
		
		return dao.getProfile(username);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		
		return dao.updateCustomer(customer);
	}

}
