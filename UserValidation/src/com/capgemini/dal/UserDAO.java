package com.capgemini.dal;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.capgemini.pojo.UserData;
import com.capgemini.util.ConnectionProvider;

public class UserDAO {

	private Connection connection;

	public UserDAO() {
		try {
			connection = ConnectionProvider.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getUserType(String userName, String password)throws InvalidUserException, SQLException {
		ArrayList<UserData> userDataList = new ArrayList<UserData>();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from userList");
		while(rs.next()){
			userDataList.add(new UserData(rs.getString(1), rs.getString(2), rs.getString(3)));
		}
		for (UserData user: userDataList){
			if (user.getUserName().equals(userName)
					&& user.getPassword().equals(password)) {
				return user.getUserType();
			}
		}
		throw new InvalidUserException("Invalid User");
	}
}
