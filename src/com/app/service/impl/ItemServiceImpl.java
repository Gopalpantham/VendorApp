package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IItemDao;
import com.app.model.Item;
import com.app.service.IItemService;
@Service
public class ItemServiceImpl implements IItemService {
@Autowired
private IItemDao dao;
	public int saveItem(Item it) {
		return dao.saveItem(it);
	}

	public void deleteItem(int itId) {
dao.deleteItem(itId);
	}

	public void updateItem(Item it) {
dao.updateItem(it);
	}

	public Item getItemById(int itId) {
		return dao.getItemById(itId);
	}

	public List<Item> getAllItems() {
		return dao.getAllItems();
	}

}
