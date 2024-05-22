package com.godoro.relation;

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
		String password = "********";
		Connection connection = DriverManager.getConnection(url, user, password);

		//Updating departmentId process
		String sql = "update Employee set departmentId=? where employeeId=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		PreparedStatement statement1 = connection.prepareStatement(sql);
		statement.setInt(1, 1);
		statement.setInt(2, 4);
		statement1.setInt(1, 2);
		statement1.setInt(2, 2);
		int affected = statement.executeUpdate();
		int affected1 = statement1.executeUpdate();
		System.out.println("Affected " + affected + " " + affected1);

		//Closing Database
		connection.close();
	}
}
