package com.jbk.dao;

import java.util.List;

import com.jbk.entity.Customer;

public interface CustomerDao {
	public Customer login(Customer customer);
	public boolean saveCustomer(Customer customer);
	public List<Customer> getAllCustomer();
	public boolean deleteCustomer(String username);
	public Customer getProfile(String username);
	public boolean updateCustomer(Customer customer);


}
