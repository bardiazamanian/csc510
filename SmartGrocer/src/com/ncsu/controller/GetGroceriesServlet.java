package com.ncsu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ncsu.database.MySQLShoppingList;
import com.ncsu.model.ShoppingList;

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
		MySQLShoppingList mySqlSL = new MySQLShoppingList();
		List<ShoppingList> sll = mySqlSL.getShoppingList();
		
		String jsonShoppingList = new Gson().toJson(sll);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonShoppingList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tblValues=  request.getParameter("tableValues");
		
		java.lang.reflect.Type listType = new TypeToken<List<ShoppingList>>(){}.getType();
		List<ShoppingList> items = new Gson().fromJson(tblValues,listType);
		MySQLShoppingList mySqlSL = new MySQLShoppingList();
		mySqlSL.saveShoppingList(items);
	}
}
