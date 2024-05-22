package com.godoro.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgrregateTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Connection to the database
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/godorodb";
		String user = "root";
		String password = "*********";
		Connection connection = DriverManager.getConnection(url, user, password);

		/*
		 * String sql = "select Employee.*, departmentName from Employee " +
		 * "inner join Department on Employee.departmentId = Department.departmentId " +
		 * "where employeeId=?";
		 */
		
		//Counting the all employees
		//String sql = "select count(*) as countOfEmployee from Employee";

		String sql = "select departmentId, count(*) as countOfEmployee from Employee group by departmentId";
		
		//Summing the total monthly salary of all employees
		String sql1 = "select sum(monthlySalary) as sumOfMonthlySalary from Employee";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		PreparedStatement statement1 = connection.prepareStatement(sql1);

		// getting the features of the table
		ResultSet resultSet = statement.executeQuery();
		ResultSet resultSet1 = statement1.executeQuery();
		while (resultSet.next()/* && resultSet1.next()*/) {
			//int count = resultSet.getInt("countOfEmployee");
			//System.out.println("Employee Number: " + count);
			
			int departmentId = resultSet.getInt("departmentId");
			int count  = resultSet.getInt("countOfEmployee");
			
			System.out.println("Deparmant Num: " + departmentId + " Number of Employee " + count);
			
			/*Double sum = resultSet1.getDouble("sumOfMonthlySalary");
			System.out.println("Total sum of the monthly salaries: " + sum);*/

		}
		// Closing Database
		connection.close();
	}
}