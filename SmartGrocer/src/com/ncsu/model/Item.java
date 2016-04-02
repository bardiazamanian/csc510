package com.ncsu.model;

import java.util.Date;

public class Item {
	
	private int id; 
	private String name;  
	private Date datePurchased;

	public Date getDate() {
		return datePurchased;
	}
	public void setDate(Date date) {
		this.datePurchased = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}  


	
	
}
