package com.ncsu.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ncsu.model.*;

public class MySQLShoppingList {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/csc510";
	//  Database credentials
	static final String USER = "sqluser";
	static final String PASS = "sqluserpw";
	
	public List<ShoppingList> getShoppingList()
	{
		Connection conn = null;
		Statement stmt = null;
		List<ShoppingList> sll = new ArrayList<ShoppingList>();
		
		try{
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * FROM shopping_list";
		      ResultSet rs = stmt.executeQuery(sql);
	
		      
		      while(rs.next()){
		    	  ShoppingList temp = new ShoppingList();
		         
		         temp.setItem(rs.getString("item"));
		         temp.setItemCount(rs.getInt("item_count"));
		         temp.setItemPrice(rs.getFloat("item_price"));
		         		         
		         sll.add(temp);
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
		  
		   return sll;
	}
	
	public List<ShoppingList> getPreviousShoppingList()
	{
		Connection conn = null;
		Statement stmt = null;
		List<ShoppingList> psll = new ArrayList<ShoppingList>();
		
		try{
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * FROM previous_shopping_list";
		      ResultSet rs = stmt.executeQuery(sql);
	
		      
		      while(rs.next()){
		    	  ShoppingList temp = new ShoppingList();
		         
		         temp.setItem(rs.getString("item"));
		         temp.setItemCount(rs.getInt("item_count"));
		         temp.setItemPrice(rs.getFloat("item_price"));
		         		         
		         psll.add(temp);
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
		  
		   return psll;
	}
	
	public boolean saveShoppingList(List<ShoppingList> sll){
		
		Connection conn = null;
		Statement stmt = null;
		
		try{
			  Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql;
		      sql = "DELETE FROM shopping_list";
		      
		      stmt.executeUpdate(sql);
	
		      for(ShoppingList temp : sll){
		    	  sql = "INSERT INTO shopping_list values (default, '" + temp.getItem() + "', "
		    			  									+ temp.getItemCount() + ", "
		    			  									+ temp.getItemPrice() + ")";
		    	  stmt.executeUpdate(sql);
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
		  
		
		
		return false;
	}
	
	public boolean savePreviousShoppingList(List<ShoppingList> psll){
		
		Connection conn = null;
		Statement stmt = null;
		
		try{
			  Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql;
		      sql = "DELETE FROM previous_shopping_list";
		      
		      stmt.executeUpdate(sql);
	
		      for(ShoppingList temp : psll){
		    	  sql = "INSERT INTO previous_shopping_list values (default, '" + temp.getItem() + "', "
		    			  									+ temp.getItemCount() + ", "
		    			  									+ temp.getItemPrice() + ")";
		    	  stmt.executeUpdate(sql);
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
		  
		
		
		return false;
	}
}