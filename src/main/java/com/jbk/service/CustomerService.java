package com.jbk.service;

import java.util.List;

import com.jbk.entity.Customer;

public interface CustomerService {
	
	public Customer login(Customer customer);
	public boolean saveCustomer(Customer customer);
	public List<Customer> getAllCustomer();
	public boolean deleteCustomer(String username);
	
	public Customer getProfile(String username);
	public boolean updateCustomer(Customer customer);

}
