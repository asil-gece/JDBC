package com.godoro.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Connection to the database
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/godorodb";
		String user = "root";
		String password = "Ada.Gizem09!";
		Connection connection = DriverManager.getConnection(url, user, password);

		//Updating process
		String sql = "update Product set productName=?, salesPrice=? where productID=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, "Smart Phone");
		statement.setDouble(2, 1750.0);	
		statement.setLong(3, 5);
		int affected = statement.executeUpdate();
		System.out.println("Affected " + affected);

		//Closing Database
		connection.close();
	}
}
