package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lowagie.text.pdf.PdfPCell;

@Entity
@Table
public class Item {
@Id
@Column
private int itemId;
@Column
private String itemName;
@Column
private double itemCost;
@Column
private double discount;
@Column
private int custId;
@Override
public String toString() {
	return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemCost="
			+ itemCost + ", discount=" + discount + ", custId=" + custId + "]";
}
public Item(int itemId, String itemName, double itemCost, double discount,
		int custId) {
	super();
	this.itemId = itemId;
	this.itemName = itemName;
	this.itemCost = itemCost;
	this.discount = discount;
	this.custId = custId;
}
public Item(int itemId) {
	super();
	this.itemId = itemId;
}
public Item() {
	super();
}
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public double getItemCost() {
	return itemCost;
}
public void setItemCost(double itemCost) {
	this.itemCost = itemCost;
}
public double getDiscount() {
	return discount;
}
public void setDiscount(double discount) {
	this.discount = discount;
}
public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}

}
