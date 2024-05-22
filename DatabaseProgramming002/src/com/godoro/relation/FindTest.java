package com.godoro.relation;

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
		String password = "*********";
		Connection connection = DriverManager.getConnection(url, user, password);

		int employeeId = 5;
		// Selecting specific process
		
		/*String sql = "select Employee.*, departmentName from Employee "
				+ "inner join Department on Employee.departmentId = Department.departmentId "
				+ "where employeeId=?";*/
		
		String sql = "select * from EmployeeView where employeeId=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, employeeId);

		//getting the features of the table
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			String employeeName = resultSet.getString("employeeName");
			double monthlySalary = resultSet.getDouble("monthlySalary");
			String departmentName = resultSet.getString("departmentName");
			System.out.println("Employee Id: " + employeeId);
			System.out.println("Monthly Salary: " + " " + monthlySalary);
			System.out.println("Employee Name: " + " " + employeeName);
			System.out.println("Department Name: " + departmentName);

		} else {
			System.out.println("Employee has not been found");
		}
		// Closing Database
		connection.close();
	}
}
