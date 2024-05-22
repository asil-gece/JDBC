package com.godoro.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Connection to the database
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/godorodb";
		String user = "root";
		String password = "Ada.Gizem09!";
		Connection connection = DriverManager.getConnection(url, user, password);

		// Selecting all process
		String sql = "select * from Product";

		PreparedStatement statement = connection.prepareStatement(sql);

		//getting the features of the table
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			long productId = resultSet.getLong("productId");
			String productName = resultSet.getString("productName");
			double salesPrice = resultSet.getDouble("salesPrice");
			System.out.println(productId + " " + productName + " " + salesPrice);
		}
		// Closing Database
		connection.close();
	}

}
