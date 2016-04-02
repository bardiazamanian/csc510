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
import com.ncsu.database.MySQLItems;
import com.ncsu.database.MySQLShoppingList;
import com.ncsu.model.Item;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/getPurchasedItems")
public class GetAddItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAddItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MySQLItems itemsPurchased = new MySQLItems();
		List<Item> purchasedItems = itemsPurchased.getPurchasedItemsLastWeek();
		
		String jsonPurchasedItems = new Gson().toJson(purchasedItems);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonPurchasedItems);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String selectedValues=  request.getParameter("checkedVal");
		java.lang.reflect.Type listType = new TypeToken<List<Item>>(){}.getType();
		List<Item> items = new Gson().fromJson(selectedValues,listType);
		
		MySQLShoppingList sl = new MySQLShoppingList();
		sl.addItemsToShoppingList(items);
	}
}
