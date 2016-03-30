package com.ncsu.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncsu.model.*;
import com.ncsu.database.*;

/**
 * Servlet implementation class SaveShoppingListServlet
 */
@WebServlet("/SaveShoppingListServlet")
public class SaveShoppingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveShoppingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
	        String items = "";
	        if(br != null){
	        	items = br.readLine();
	        }
	        System.out.println(items);
	        List<ShoppingList> sll = destringifyShoppingList(items); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private List<ShoppingList> destringifyShoppingList(String commalist){
		commalist = commalist.substring(0, commalist.length() - 1);
		String[] words = commalist.split(",");
		List<ShoppingList> sll = new ArrayList<ShoppingList>();
		for(int x=0; x < words.length; x = x + 3){
			ShoppingList item = new ShoppingList();
			item.setItem(words[x]);
			item.setItemCount(Integer.parseInt(words[x+1]));
			item.setItemPrice(Float.parseFloat(words[x+2]));
			sll.add(item);
		}
		return sll;
	}

}
