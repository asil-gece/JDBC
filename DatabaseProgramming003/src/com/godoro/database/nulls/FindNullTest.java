package com.godoro.database.nulls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindNullTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Connection to the database
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/godorodb";
		String user = "root";
		String password = "***********";
		Connection connection = DriverManager.getConnection(url, user, password);
		long dataId = 7;
		
		// Selecting specific process
		String sql = "select * from Data where dataId=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, dataId);

		//getting the features of the table
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			String stringType = resultSet.getString("stringType");
			System.out.println("Null? " + resultSet.wasNull());
			System.out.println("stringType: " + stringType);
			
			int integerType = resultSet.getInt("integerType");
			System.out.println("Null? " + resultSet.wasNull());
			System.out.println("integerType: " + " " + integerType);
			if (!resultSet.wasNull()) {
				System.out.println("integerType: " + " " + integerType);
			}else {
				System.out.println("No number entered");
			}
			
			Float floatType = resultSet.getFloat("floatType");
			System.out.println("Null? " + resultSet.wasNull());
			System.out.println("floatType: " + floatType);
			if (!resultSet.wasNull()) {
				System.out.println("integerType: " + " " + integerType);
			}else {
				System.out.println("No number entered");
			}

		} else {
			System.out.println("HAs not been found");
		}
		// Closing Database
		connection.close();
	}
}
