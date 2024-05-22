package com.godoro.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Note: This usage is not recommended, this usage was used just to grasp the basics of JDBC
public class ReadTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/godorodb";
		String user = "root";
		String password = "********";
		Connection connection = DriverManager.getConnection(url,user,password);
		
		String sql = "select * from Product";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			long productId = resultSet.getLong("productId");
			String productName = resultSet.getString("productName");
			double salesPrice = resultSet.getDouble("salesPrice");
			System.out.println(productId+ " " + productName + " " + salesPrice );
		}
		
		connection.close();

	}

}
