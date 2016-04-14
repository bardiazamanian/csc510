package com.ncsu.model;

import java.sql.Timestamp;
import java.util.Date;

public class Item {
	
	private int id; 
	private String name;  
	private Timestamp datePurchased;

	public Timestamp getDate() {
		return datePurchased;
	}
	public void setDate(Timestamp timestamp) {
		this.datePurchased = timestamp;
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
