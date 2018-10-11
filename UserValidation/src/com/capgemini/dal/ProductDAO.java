package com.capgemini.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.capgemini.pojo.ProductData;
import com.capgemini.util.ConnectionProvider;

public class ProductDAO {
	
	private Connection connection;
	
	public ProductDAO() {
		try {
			connection = ConnectionProvider.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addItem(String prodID, String prodName, Double prodPrice) throws SQLException{
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("Insert into productList values('"+prodID+"','"+prodName+"',"+prodPrice+")");
	}

	public ArrayList<ProductData> getProductList() throws SQLException {
		ArrayList<ProductData> productList = new ArrayList<ProductData>();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from productList");
		while(rs.next()){
			productList.add(new ProductData(rs.getString(1), rs.getString(2), rs.getDouble(3)));
		}
		return productList;
	}
	
	public void removeItem(String prodID) throws SQLException{
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("Delete from productList where prodID='"+prodID+"'");
	}

	public void update(String prodID, String prodName, double prodPrice) throws SQLException {
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("update productList "
				+"set prodName='"+prodName
				+"', prodPrice="+prodPrice
				+" where prodID='"+prodID+"'");		
	}
}
