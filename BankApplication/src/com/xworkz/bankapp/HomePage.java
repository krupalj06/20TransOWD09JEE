package com.xworkz.bankapp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePage extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("In POST method of servlet");
		
		String userSelect = req.getParameter("selection");
		
		if(userSelect.equals("balance")) {
		  RequestDispatcher dispatcher = req.getRequestDispatcher("MenuPage.html");
			dispatcher.forward(req, resp);
		} else if(userSelect.equals("statement")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("getstatement");
			dispatcher.forward(req, resp);
			//include
		} else {
			
		}
		
		
	}

}
