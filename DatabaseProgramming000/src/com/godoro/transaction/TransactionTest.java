package com.godoro.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Connection to the database
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/godorodb";
		String user = "root";
		String password = "Ada.Gizem09!";
		Connection connection = DriverManager.getConnection(url, user, password);

		//Setting AutoCommit to false
		connection.setAutoCommit(false);
		
		//Insertion process
		String sql = "insert into Product(productName,salesPrice) values (?,?)";

		PreparedStatement statement1 = connection.prepareStatement(sql);
		statement1.setString(1, "Desktop");
		statement1.setDouble(2, 1750);
		int affected1 = statement1.executeUpdate();
		System.out.println("Affected " + affected1);
		
		PreparedStatement statement2 = connection.prepareStatement(sql);
		statement2.setString(1, "Laptop");
		statement2.setDouble(2, 2750);
		int affected2 = statement2.executeUpdate();
		System.out.println("Affected " + affected2);

		PreparedStatement statement3 = connection.prepareStatement(sql);
		statement3.setString(1, "Tablet");
		statement3.setDouble(2, 800);
		int affected3 = statement3.executeUpdate();
		System.out.println("Affected " + affected3);
		
		//Committing
		connection.commit();
		
		//Closing Database
		connection.close();
	}
}
