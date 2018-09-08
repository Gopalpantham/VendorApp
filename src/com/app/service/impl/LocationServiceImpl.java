package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ILocationDao;
import com.app.model.Location;
import com.app.service.ILocationService;


@Service
public class LocationServiceImpl implements ILocationService {
	@Autowired
	private ILocationDao dao;

	public int saveLocation(Location loc) {
		return dao.saveLocation(loc);
	}

	public void updateLocation(Location loc) {
		dao.updateLocation(loc);
	}

	public void deleteLocation(int locId) {
		dao.deleteLocation(locId);
	}

	public Location getLocationById(int locId) {
		return dao.getLocationById(locId);
	}

	public List<Location> getAllLocations() {
		return dao.getAllLocations();
	}

	public List<Object[]> getLocationTypeByCount() {
		return dao.getLocationTypeByCount();
	}

}