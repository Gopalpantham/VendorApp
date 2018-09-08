package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;
@Repository
public class ItemImplDao implements IItemDao {
@Autowired
	private HibernateTemplate ht;
	public int saveItem(Item it) {
		return (Integer) ht.save(it);
	}

	public void deleteItem(int itId) {
      ht.delete(new Item(itId));
	}

	public void updateItem(Item it) {
ht.update(it);
	}

	public Item getItemById(int itId) {
		return ht.get(Item.class, itId);
	}

	public List<Item> getAllItems() {
		return ht.loadAll(Item.class);
	}

	private List<Item> ht(Class<Item> class1) {
		// TODO Auto-generated method stub
		return null;
	}

}
