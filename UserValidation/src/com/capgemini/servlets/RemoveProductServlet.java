package com.capgemini.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.dal.ProductDAO;

@WebServlet("/RemoveProduct")
public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doCommon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] products = request.getParameterValues("check");
		ProductDAO product = new ProductDAO();
		for(String s:products){
			try {
				product.removeItem(s);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("jsp/AdminHome.jsp");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doCommon(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doCommon(request, response);
	}

}
