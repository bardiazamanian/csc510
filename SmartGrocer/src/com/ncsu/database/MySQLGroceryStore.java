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
}
