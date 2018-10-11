package com.capgemini.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	private static Connection connection;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");  
		connection=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/mydatabase","root","D13@B1296");
		return connection;  
	}
}
