package com.godoro.calls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;

public class CallableTest {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//Connection to the database
				Class.forName("com.mysql.cj.jdbc.Driver");

				String url = "jdbc:mysql://localhost:3306/godorodb";
				String user = "root";
				String password = "*******";
				Connection connection = DriverManager.getConnection(url, user, password);
				
				//Calling the statement
				int employeeId = 3;
				double incresePercentage = 25;
				CallableStatement statement =(CallableStatement) connection.prepareCall("call EmployeeSalaryIncrease(?,?)");
				statement.setInt(1, employeeId);
				statement.setDouble(2, incresePercentage);
				statement.execute();
				//Closing Database
				connection.close();
			}
	}


