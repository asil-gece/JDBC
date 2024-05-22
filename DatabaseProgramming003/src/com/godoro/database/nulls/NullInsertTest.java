package com.godoro.database.nulls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class NullInsertTest {

	
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			// Connection to the database
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/godorodb";
			String user = "root";
			String password = "*******";
			Connection connection = DriverManager.getConnection(url, user, password);

			// Insertion process
			String sql = "insert into Data(stringType,integerType, floatType) values (?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, null);
			statement.setNull(2, Types.INTEGER);
			statement.setNull(3, Types.FLOAT);
			int affected = statement.executeUpdate();
			System.out.println("Affected " + affected);

			// Closing Database
			connection.close();
		}
	}

