package com.godoro.relation;

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
		String password = "*********";
		Connection connection = DriverManager.getConnection(url, user, password);

		// Selecting all process with join
		/*String sql = "select Employee.*, departmentName from Employee\r\n"
				+ "inner join Department on Employee.departmentId=Department.departmentId";*/
		
		String sql = "select * from EmployeeView";

		PreparedStatement statement = connection.prepareStatement(sql);

		//getting the features of the table
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			int employeeId = resultSet.getInt("employeeId");
			String employeeName = resultSet.getString("employeeName");
			double monthlySalary = resultSet.getDouble("monthlySalary");
			int departmentId = resultSet.getInt("departmentId");
			String departmentName = resultSet.getString("departmentName");
			System.out.println(employeeId + " " + employeeName + " " + monthlySalary  + " " + departmentId + " " + departmentName);
		}
		// Closing Database
		connection.close();
	}

}
