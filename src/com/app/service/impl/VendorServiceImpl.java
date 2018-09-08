package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
import com.app.service.IVendorService;

@Service
public class VendorServiceImpl implements IVendorService {
@Autowired
private IVendorDao dao;

	public int saveVendor(Vendor ven) {
	return dao.saveVendor(ven);
	}

	public void updateVendor(Vendor ven) {
		dao.updateVendor(ven);
	}

	public void deleteVendor(int venId) {
		dao.deleteVendor(venId);
	}

	public Vendor getVendorById(int venId) {
		return dao.getVendorById(venId);
	}

	public List<Vendor> getAllVendors() {
		return dao.getAllVendors();
	}

	public List<Object[]> getVendorTypeCount() {
		return dao.getVendorTypeCount();
	}


	

}
