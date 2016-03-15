package com.ncsu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ncsu.database.*;
import com.ncsu.model.*;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/GetGroceries")
public class GetGroceriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetGroceriesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub .. 
		// Make a call to DB to obtain groceries. Need to decide if we are going to use any patterns
		MySQLGroceryStore gStore = new MySQLGroceryStore();
		
		List<GroceryStoreInventory> gsil = gStore.getGroceryStoreInventory();
		
		String groceriesList = " New Grocery List: ";
		
		for(GroceryStoreInventory gsiItem : gsil){
			System.out.println(gsiItem.getItem());
			groceriesList += gsiItem.getItem();
			groceriesList += " ";
		}
		
		request.setAttribute("groceryList", groceriesList);
		request.getRequestDispatcher("jsp/displayGroceryList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
