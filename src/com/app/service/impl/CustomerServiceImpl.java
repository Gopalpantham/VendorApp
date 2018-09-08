package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.service.ICustomerService;
@Service
public class CustomerServiceImpl implements ICustomerService {
@Autowired
	private ICustomerDao dao;
	public int saveCustomer(Customer c) {
		return dao.saveCustomer(c);
	}
	public void updateCustomer(Customer c) {
		dao.updateCustomer(c);
	}
	public List<Customer> getAllCustomers() {
		return dao.getAllCustomers();
	}
	public void deleteCustomer(int custId) {
		dao.deleteCustomer(custId);
	}
	public Customer getCustomerById(int custId) {
		return dao.getCustomerById(custId);
	}
	public List<Object[]> getCustomerTypeByCount() {
		return dao.getCustomerTypeByCount();
	}
	@Override
	public Customer getCustomerByEmail(String email) {
		return dao.getCustomerByEmail(email);
	}

}
