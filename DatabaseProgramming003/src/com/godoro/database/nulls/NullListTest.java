package com.godoro.database.nulls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NullListTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Connection to the database
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/godorodb";
		String user = "root";
		String password = "**********";
		Connection connection = DriverManager.getConnection(url, user, password);

		// Selecting all null process
		String sql = "select * from Data where integerType /*is*/ is not NULL";

		PreparedStatement statement = connection.prepareStatement(sql);

		//getting the features of the table
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			Long dataId = resultSet.getLong("dataId");
			String stringType = resultSet.getString("stringType");
			int integerType = resultSet.getInt("integerType");
			Float floatType = resultSet.getFloat("floatType");
			System.out.println(dataId + " " + stringType + " " + integerType + " " + floatType) ;
		}
		// Closing Database
		connection.close();
	}

}
