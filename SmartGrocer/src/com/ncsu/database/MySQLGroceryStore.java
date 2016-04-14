package com.ncsu.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ncsu.model.*;


public class MySQLGroceryStore {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/csc510";
	//  Database credentials
	static final String USER = "sqluser";
	static final String PASS = "sqluserpw";
	
	public List<GroceryStoreInventory> getGroceryStoreInventory()
	{
		Connection conn = null;
		Statement stmt = null;
		List<GroceryStoreInventory> gsil = new ArrayList<GroceryStoreInventory>();
		
		try{
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * FROM grocery_store_inventory";
		      ResultSet rs = stmt.executeQuery(sql);
	
		      
		      while(rs.next()){
		         GroceryStoreInventory temp = new GroceryStoreInventory();
		         
		         temp.setItem(rs.getString("item"));
		         temp.setItemCount(rs.getInt("item_count"));
		         temp.setItemPrice(rs.getFloat("item_price"));
		         temp.setStore(rs.getString("store"));
		         temp.setAisle(rs.getInt("aisle"));
		         temp.setShelvingUnit(rs.getInt("shelving_unit"));
		         temp.setShelf(rs.getInt("shelf"));
		         
		         gsil.add(temp);
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
		   System.out.println("Goodbye!");
		   return gsil;
	}
	public boolean addItem(GroceryStoreInventory item)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			  Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

			  //TODO
			  //stmt =conn.prepareStatement("INSERT INTO shopping_cart values (default, ?, ?,?)");
			  //stmt.set->
			  //stmt.close();
			  
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
	
	public boolean decreaseItemCount(String item, int count)
	{
		Connection conn = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		
		try{
			  Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      stmt1 =conn.prepareStatement("SELECT item_count FROM grocery_store_inventory WHERE item=?");
		      stmt1.setString(1,item);
		      ResultSet rs = stmt1.executeQuery();
		      if(rs.next()){
		    	  int new_count = rs.getInt("item_count") - count;
		    	  stmt1.close();
		    	  
			      if (new_count<=0)
			    	  deleteItem(item);
			      
			      else{
			    	  stmt2 =conn.prepareStatement("UPDATE grocery_store_inventory SET item_count=? WHERE item=?");
			    	  stmt2.setInt(1,new_count);
			    	  stmt2.setString(2,item);
			    	  stmt2.executeUpdate();
			    	  // conn.commit();
			    	  stmt2.close();
			      }
		      }
		      else
		    	  stmt1.close();
		      
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
		         if(stmt1!=null)
		            stmt1.close();
		         if(stmt2!=null)
			        stmt2.close();
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
	
	public boolean deleteItem(String item)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			  Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

			  stmt =conn.prepareStatement("DELETE FROM grocery_store_inventory WHERE item=?");
			  stmt.setString(1,item);
			  stmt.executeUpdate();
		     // conn.commit();
			  
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
