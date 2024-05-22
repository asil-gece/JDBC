package com.godoro.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Connection to the database
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/godorodb";
		String user = "root";
		String password = "Ada.Gizem09!";
		Connection connection = DriverManager.getConnection(url, user, password);

		// Selecting specific process
		String sql = "select * from Product where productId=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, 3);

		//getting the features of the table
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			long productId = resultSet.getLong("productId");
			String productName = resultSet.getString("productName");
			double salesPrice = resultSet.getDouble("salesPrice");
			System.out.println("Product Id: " + productId);
			System.out.println("Product Name: " + " " + productName);
			System.out.println("Product Price: " + salesPrice);

		} else {
			System.out.println("Product has not been found");
		}
		// Closing Database
		connection.close();
	}
}
