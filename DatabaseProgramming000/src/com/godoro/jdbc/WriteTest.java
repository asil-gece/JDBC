package com.godoro.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


//Note: This usage is not recommended, this usage was used just to grasp the basics of JDBC
public class WriteTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/godorodb";
		String user = "root";
		String password = "*******";
		Connection connection = DriverManager.getConnection(url,user,password);
		
		String sql = "insert into Product(productName,salesPrice) values ('Dishwasher Machine', 900)";
		
		Statement statement = connection.createStatement();
		int affected = statement.executeUpdate(sql);
		System.out.println("Affected " + affected);
	
		connection.close();
}
}