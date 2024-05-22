package com.godoro.library.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtilities {
	
	public static String url = "jdbc:mysql://localhost:3306/godorodb";
	public static String user = "root";
	public static  String password = "*******";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

}
