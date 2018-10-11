package com.capgemini.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.dal.ProductDAO;
import com.capgemini.pojo.ProductData;

@WebServlet("/ProductUpdation")
public class ProductUpdationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doCommon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO product = new ProductDAO();
		String prodID = null;
		String prodName = null;
		double prodPrice = 0;
		ArrayList<ProductData> productList=null;
		try {
			productList = product.getProductList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(ProductData productData: productList){
			prodID = request.getParameter("prodID"+productData.getProdID());
			prodName = request.getParameter("prodName"+productData.getProdID());
			prodPrice = Double.parseDouble(request.getParameter("prodPrice"+productData.getProdID()));
			try {
				product.update(prodID, prodName, prodPrice);
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
