package com.godoro.relation;

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
		String password = "********";
		Connection connection = DriverManager.getConnection(url, user, password);

		//Insertion process
		String sql = "insert into Employee(employeeName,monthlySalary,departmentId) values (?,?,?)";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, "Fikret Kızılok");
		statement.setDouble(2, 1950);
		statement.setInt(3, 4);
		int affected = statement.executeUpdate();
		System.out.println("Affected " + affected);

		//Closing Database
		connection.close();
	}
}
