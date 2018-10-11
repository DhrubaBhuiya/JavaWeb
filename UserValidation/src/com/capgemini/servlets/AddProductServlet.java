package com.capgemini.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.dal.ProductDAO;

@WebServlet("/AddProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doCommon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prodID = request.getParameter("prodID");
		String prodName = request.getParameter("prodName");
		double prodPrice = Double.parseDouble(request.getParameter("prodPrice"));
		
		ProductDAO product = new ProductDAO();
		try {
			product.addItem(prodID, prodName, prodPrice);
			response.sendRedirect("jsp/AdminHome.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doCommon(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doCommon(request,response);
	}
}
