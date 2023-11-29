package com.function;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

public class AddToCartServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String productImage=request.getParameter("product-image");
		String productName=request.getParameter("product-name");
		String productPrice=request.getParameter("product-price");
		
		HttpSession session=request.getSession();
		session.setAttribute("img", productImage);
		session.setAttribute("name", productName);
		session.setAttribute("price", productPrice);
	}
}
