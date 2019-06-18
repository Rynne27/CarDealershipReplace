package com.revature.cardealership.dao;

import java.util.ArrayList;

import com.revature.cardealership.Customer;

public interface CustomerDao {

	public void createCustomer(Customer t);
	
	public void updateCustomer(Customer t);
	
	public void deleteCustomer(Customer t);
	
	public Customer getCustomerById(Integer id);
	
	public Customer getCustomerByCustomername(String Customername);
	
	public ArrayList<Customer> getAllCustomers();

	void preparedUpdateCustomer(Customer t);
}
