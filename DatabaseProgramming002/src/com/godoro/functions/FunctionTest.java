package com.godoro.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FunctionTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Connection to the database
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/godorodb";
		String user = "root";
		String password = "*****";
		Connection connection = DriverManager.getConnection(url, user, password);

		//Concatenation
		String sql = "select *, concat('EMP-', departmentId,'-', substring(employeeName,1,3)) as employeeCode from Employee";
		
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		// getting the features of the table
		ResultSet resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			
			String employeeName = resultSet.getString("employeeName");
			String employeeCode  = resultSet.getString("employeeCode");
			
			System.out.println("Employee Name: " + employeeName + "Employee Code: " + employeeCode);
			
			
		}
		// Closing Database
		connection.close();
	}
}
