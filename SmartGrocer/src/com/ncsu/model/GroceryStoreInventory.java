package com.ncsu.model;

public class GroceryStoreInventory {
	private String item;
	private int itemCount;
	private float itemPrice;
	private String store;
	private int aisle;
	private int shelvingUnit;
	private int shelf;
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public int getAisle() {
		return aisle;
	}
	public void setAisle(int aisle) {
		this.aisle = aisle;
	}
	public int getShelvingUnit() {
		return shelvingUnit;
	}
	public void setShelvingUnit(int shelvingUnit) {
		this.shelvingUnit = shelvingUnit;
	}
	public int getShelf() {
		return shelf;
	}
	public void setShelf(int shelf) {
		this.shelf = shelf;
	}
	
	
}
