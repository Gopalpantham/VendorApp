package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ILocationDao;
import com.app.model.Location;



@Repository
public class LocationDaoImpl implements ILocationDao {
	@Autowired
	private HibernateTemplate ht;

	public int saveLocation(Location loc) {
		return (Integer)ht.save(loc);
	}

	public void updateLocation(Location loc) {
		ht.update(loc);
	}

	public void deleteLocation(int locId){
		ht.delete(new Location(locId));
	}

	public Location getLocationById(int locId) {
		return ht.get(Location.class, locId);
	}

	public List<Location> getAllLocations() {
		return ht.loadAll(Location.class);
	}

	public List<Object[]> getLocationTypeByCount() {
		String hql="select locType,count(locType) from com.app.model.Location group by locType";
		List<Object[]> list=ht.find(hql);
		return list;
	}

}