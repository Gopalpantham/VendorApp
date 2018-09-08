package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
@Repository
public class VendorDaoImpl implements IVendorDao {

	@Autowired
	private HibernateTemplate ht;

	public int saveVendor(Vendor ven) {
		return (Integer)ht.save(ven);
	}

	public void updateVendor(Vendor ven) {
		ht.update(ven);
	}

	public void deleteVendor(int venId) {
		ht.delete(new Vendor(venId));
	}

	public Vendor getVendorById(int venId) {
		return ht.get(Vendor.class, venId);
	}

	public List<Vendor> getAllVendors() {
		return ht.loadAll(Vendor.class);
	}

	public List<Object[]> getVendorTypeCount() {
	String hql="select venType, count(venType) from com.app.model.Vendor group by venType";
		List<Object[]>li=ht.find(hql);	
		return li;
	}
}