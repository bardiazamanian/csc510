package com.ncsu.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ncsu.database.MySQLItems;
import com.ncsu.database.MySQLShoppingCart;
import com.ncsu.database.MySQLGroceryStore;
import com.ncsu.database.MySQLHomeInventory;
import com.ncsu.database.MySQLShoppingList;
import com.ncsu.model.Item;
import com.ncsu.model.ShoppingCart;
import com.ncsu.model.HomeInventory;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/PurchaseItems")
public class PurchaseItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//MySQLShoppingCart sc = new MySQLShoppingCart();
	//	List <ShoppingCart> items = sc.getShoppingCart();
		
	
	
	//		String totalPrice = String.valueOf(shopping_cart.getTotalPrice());
//
//		int jsonTotalPrice = new Gson().toJson(totalPrice);
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");
//		response.getWriter().write(totalPrice);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Calendar calendar = Calendar.getInstance(); // this would default to now
		calendar.getTimeInMillis();
		long dateTimeNow = calendar.getTimeInMillis();
		
		MySQLShoppingCart sc = new MySQLShoppingCart();
		MySQLGroceryStore gs = new MySQLGroceryStore();
		MySQLShoppingList sl = new MySQLShoppingList();
		MySQLItems pi = new MySQLItems();
		MySQLHomeInventory hi = new MySQLHomeInventory();
		
		
		List <ShoppingCart> items = sc.getShoppingCart();
		
		for (int i=0;i<items.size();i++)
			sc.deleteItem(items.get(i).getItem());

		for (int i=0;i<items.size();i++)
			gs.decreaseItemCount(items.get(i).getItem(), items.get(i).getItemCount());
	
		for (int i=0;i<items.size();i++)
			sl.decreaseItemCount(items.get(i).getItem(), items.get(i).getItemCount());
		
		for (int i=0;i<items.size();i++){
			Item new_item = new Item();
			new_item.setName(items.get(i).getItem());
			new_item.setDate(new Timestamp(dateTimeNow));
			pi.addItem(new_item);
		}
		
		for (int i=0;i<items.size();i++){
			HomeInventory new_item = new HomeInventory();
			new_item.setItem(items.get(i).getItem());
			new_item.setItemCount(items.get(i).getItemCount());
			hi.increaseItemCount(items.get(i).getItem(),items.get(i).getItemCount());
		}
	}
}
