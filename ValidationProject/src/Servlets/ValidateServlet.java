package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import POJO.Users;

@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Users> ulist;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ulist = new ArrayList<Users>();
		Users u = new Users("Ravi","Ravi123","Admin");
		ulist.add(u);
		u = new Users("Naveen","N1245","User");
		ulist.add(u);
		u = new Users("Gita","Gita123","User");
		ulist.add(u);
		u = new Users("Sam","SamSam","User");
		ulist.add(u);
		u = new Users("Hari","Hari123","Admin");
		ulist.add(u);
		String uname = request.getParameter("username");
		String upass = request.getParameter("password");
		Iterator<Users> itr = ulist.iterator();
		while(itr.hasNext()){
			Users us = (Users)itr.next();
			String name=us.getUserName();
			String pass=us.getPassword();
			String type=us.getType();
			
			if(name.equals(uname)){
				if(pass.equals(upass)){
					if(type.equalsIgnoreCase("User")){
						RequestDispatcher rd=request.getRequestDispatcher("UserHome.jsp");  
				        rd.forward(request, response);
				        return;
					}
					else if(type.equalsIgnoreCase("Admin")){
						RequestDispatcher rd1=request.getRequestDispatcher("AdminHome.jsp");  
				        rd1.forward(request, response);
				        return;
					}
				}
				else{
					RequestDispatcher rd2=request.getRequestDispatcher("Invalid.jsp");  
			        rd2.forward(request, response);
			        return;
				}
			}
		}
		RequestDispatcher rd3=request.getRequestDispatcher("Invalid.jsp");  
        rd3.forward(request, response);
        return;
	}

}
