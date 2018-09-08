package com.app.service;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerService {
	public int saveCustomer(Customer c);
	public void updateCustomer(Customer c);
	public List<Customer> getAllCustomers();
	public void deleteCustomer(int custId);
	public Customer getCustomerById(int custId);
	public List<Object[]> getCustomerTypeByCount();
	public Customer getCustomerByEmail(String email);

}
