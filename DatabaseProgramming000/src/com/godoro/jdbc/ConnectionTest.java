package com.godoro.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/godorodb";
		String user = "root";
		String password = "******";
		Connection connection = DriverManager.getConnection(url,user,password);
		
		System.out.println("Database " + connection.getMetaData().getDatabaseProductName());
	
		connection.close();
	}
	
	
}
