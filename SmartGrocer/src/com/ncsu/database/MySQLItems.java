package com.ncsu.database;

import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.ncsu.model.*;

public class MySQLItems {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/csc510";
	//  Database credentials
	static final String USER = "sqluser";
	static final String PASS = "sqluserpw";
	
	public List<Item> getPurchasedItemsLastWeek()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Item> sll = new ArrayList<Item>();

		Calendar calendar = Calendar.getInstance(); // this would default to now
		calendar.getTimeInMillis();
		long dateTimeNow = calendar.getTimeInMillis();
		calendar.add(Calendar.DAY_OF_MONTH, -7);
		
		long dateTimeWeekAgo = calendar.getTimeInMillis();
		
		try{
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      
		      stmt =conn.prepareStatement("SELECT * FROM purchased_items pi WHERE pi.date_purchased BETWEEN ? and ?");
		      stmt.setTimestamp(1,new Timestamp(dateTimeWeekAgo));
		      stmt.setTimestamp(2,new Timestamp(dateTimeNow));
		      
		      ResultSet rs = stmt.executeQuery();
	
		      while(rs.next()){
		    	 Item temp = new Item();
		         
		         temp.setDate(rs.getDate("date_purchased"));
		         temp.setName(rs.getString("item"));
		         		         
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
}
