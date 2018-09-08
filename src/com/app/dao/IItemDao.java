package com.app.dao;

import java.util.List;

import com.app.model.Item;

public interface IItemDao {
	public int saveItem(Item it);
	public void deleteItem(int itId);
	public void updateItem(Item it);
	public Item getItemById(int itId);
	public List<Item> getAllItems();

}
