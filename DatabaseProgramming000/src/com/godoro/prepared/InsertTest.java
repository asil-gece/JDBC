package com.godoro.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Connection to the database
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/godorodb";
		String user = "root";
		String password = "Ada.Gizem09!";
		Connection connection = DriverManager.getConnection(url, user, password);

		//Insertion process
		String sql = "insert into Product(productName,salesPrice) values (?,?)";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, "Laptop");
		statement.setDouble(2, 1450.0);
		int affected = statement.executeUpdate();
		System.out.println("Affected " + affected);

		//Closing Database
		connection.close();
	}

}
