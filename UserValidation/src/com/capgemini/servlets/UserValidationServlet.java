package com.capgemini.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.dal.InvalidUserException;
import com.capgemini.dal.UserDAO;

@WebServlet("/Validation")
public class UserValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doCommon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String userName = request.getParameter("userName");
    	String password = request.getParameter("password");
    	String userType=null;
    	UserDAO user = new UserDAO();
    	try {
			userType = user.getUserType(userName, password);
		} catch (InvalidUserException e) {
			userType="Invalid";
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	RequestDispatcher requestDispatcher = null;
    	HttpSession session = request.getSession();
    	session.setAttribute("userName", userName);
    	if(userType.equals("Admin"))
    		requestDispatcher = request.getRequestDispatcher("/jsp/AdminHome.jsp");
    	else if(userType.equals("User"))
    		requestDispatcher = request.getRequestDispatcher("/jsp/UserHome.jsp");
    	else
    		requestDispatcher = request.getRequestDispatcher("/jsp/Invalid.jsp");
    	
    	requestDispatcher.forward(request, response);
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doCommon(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doCommon(request, response);
	}

}
