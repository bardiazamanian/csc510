package com.ncsu.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ncsu.model.HomeInventory;
import com.ncsu.model.ShoppingCart;
import com.ncsu.model.ShoppingList;

public class MySQLHomeInventory {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/csc510";
	//  Database credentials
	static final String USER = "sqluser";
	static final String PASS = "sqluserpw";
	
	public List<HomeInventory> getHomeInventory()
	{
		Connection conn = null;
		Statement stmt = null;
		List<HomeInventory> hil = new ArrayList<HomeInventory>();
		
		try{
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * FROM home_inventory";
		      ResultSet rs = stmt.executeQuery(sql);
	
		      
		      while(rs.next()){
		    	  HomeInventory temp = new HomeInventory();
		         
		         temp.setItem(rs.getString("item"));
		         temp.setItemCount(rs.getInt("item_count"));
		         		         		         
		         hil.add(temp);
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
		  
		   return hil;
	}
	public boolean addItem(HomeInventory item)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			  Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

			  stmt =conn.prepareStatement("INSERT INTO home_inventory values (default, ?, ?)");
    
			  stmt.setString(1,item.getItem());
			  stmt.setInt(2,item.getItemCount());
			  stmt.executeUpdate();
  
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

	public boolean increaseItemCount(String item, int count)
	{
		Connection conn = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		
		try{
			  Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      stmt1 =conn.prepareStatement("SELECT item_count FROM home_inventory WHERE item=?");
		      stmt1.setString(1,item);
		      ResultSet rs = stmt1.executeQuery();
		      if(rs.next()){
		    	  int new_count = rs.getInt("item_count") + count;
		    	  
		    	  stmt1.close();
		    	  
		    	  stmt2 =conn.prepareStatement("UPDATE home_inventory SET item_count=? WHERE item=?");
		    	  stmt2.setInt(1,new_count);
		    	  stmt2.setString(2,item);
		    	  stmt2.executeUpdate();
		    	  // conn.commit();
		    	  stmt2.close();
		      }
		      else{
		    	  HomeInventory new_item = new HomeInventory();
		    	  new_item.setItem(item);
		    	  new_item.setItemCount(count);
		    	  addItem(new_item);
		    	  stmt1.close();
		      }
		      
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
	
	public boolean decreaseItemCount(String item, int count)
	{
		Connection conn = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		
		try{
			  Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      stmt1 =conn.prepareStatement("SELECT item_count FROM home_inventory WHERE item=?");
		      stmt1.setString(1,item);
		      ResultSet rs = stmt1.executeQuery();
		      if(rs.next()){
		    	  int new_count = rs.getInt("item_count") - count;
		    	  stmt1.close();
		    	  
			      if (new_count<=0)
			    	  deleteItem(item);
			      
			      else{
			    	  stmt2 =conn.prepareStatement("UPDATE home_inventory SET item_count=? WHERE item=?");
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

			  stmt =conn.prepareStatement("DELETE FROM home_inventory WHERE item=?");
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
