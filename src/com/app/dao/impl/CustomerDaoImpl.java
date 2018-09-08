package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;



@Repository
public class CustomerDaoImpl implements ICustomerDao {
@Autowired 
	private HibernateTemplate ht;
	public void updateCustomer(Customer c) {
		ht.update(c);
	}
	public List<Customer> getAllCustomers() {
		return ht.loadAll(Customer.class);
	}
	public void deleteCustomer(int custId) {
		ht.delete(new Customer(custId));
	}
	public int saveCustomer(Customer c) {
		return (int) ht.save(c);
	}
	public Customer getCustomerById(int custId) {
		return ht.get(Customer.class, custId);
	}
	public List<Object[]> getCustomerTypeByCount() {
		String hql="select custType,count(custType) from com.app.model.Customer group by custType";
		List<Object[]> list=ht.find(hql);
		return list;
	}
	@Override
	public Customer getCustomerByEmail(String email) {
		Customer cust=null;
		String hql="from com.app.model.Customer where custEmail=?";
		List<Customer> custList=ht.find(hql,email);
		if(custList!=null && custList.size()>0){
			cust=custList.get(0);
		}
		return cust;
		
	}
	
	
}
