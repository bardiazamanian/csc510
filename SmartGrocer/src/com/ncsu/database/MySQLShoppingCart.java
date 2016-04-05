package com.ncsu.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ncsu.model.*;

public class MySQLShoppingCart  {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/csc510";
	//  Database credentials
	static final String USER = "sqluser";
	static final String PASS = "sqluserpw";

	public List<ShoppingCart> getShoppingCart()
	{
		Connection conn = null;
		Statement stmt = null;
		List<ShoppingCart> sc = new ArrayList<ShoppingCart>();
		
		try{
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * FROM shopping_cart";
		      ResultSet rs = stmt.executeQuery(sql);
	
		      while(rs.next()){
		    	  ShoppingCart temp = new ShoppingCart();
		         
		         temp.setItem(rs.getString("item"));
		         temp.setItemCount(rs.getInt("item_count"));
		         temp.setItemPrice(rs.getFloat("item_price"));
		         		         
		         sc.add(temp);
		      }
		      
		      rs.close();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try

		   }//end try
		   return sc;  
	}
	
	public float getTotalPrice()
	{
		Connection conn = null;
		Statement stmt = null;
		float totalPrice = 0;

		try{
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * FROM shopping_cart";
		      ResultSet rs = stmt.executeQuery(sql);
	
		      while(rs.next())
		      	totalPrice+=rs.getFloat("item_price");
		      
		      rs.close();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		  
		   return totalPrice;
	}
	
	public boolean addItemsToShoppingCart(List<ShoppingCart> items)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			  Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      
		      for(ShoppingCart item: items)
		      {
			      stmt =conn.prepareStatement("INSERT INTO shopping_cart values (default, ?, ?,?)");
			      
			      
			      stmt.setString(1,item.getItem());
			      stmt.setInt(2,item.getItemCount());
			      stmt.setDouble(3, item.getItemPrice());//Default price
			      stmt.executeUpdate();
		      }
		      
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		  
	
		return true;
	}

	public boolean addItemToShoppingCart(ShoppingCart item)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			  Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

			  stmt =conn.prepareStatement("INSERT INTO shopping_cart values (default, ?, ?,?)");
    
			  stmt.setString(1,item.getItem());
			  stmt.setInt(2,item.getItemCount());
			  stmt.setDouble(3, item.getItemPrice());//Default price

		      
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		  
	
		return true;
	}
	
}
