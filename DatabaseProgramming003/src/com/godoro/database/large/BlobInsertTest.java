package com.godoro.database.large;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BlobInsertTest {

	
		public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
			
			String path = "C:\\Users\\James\\Desktop\\logo.jpg";
			FileInputStream fis = new FileInputStream(path);
			
			//Connection to the database
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/godorodb";
			String user = "root";
			String password = "*********";
			Connection connection = DriverManager.getConnection(url, user, password);

			//Insertion process
			String sql = "insert into Large(blobField) values (?)";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setBinaryStream(1, fis);
			int affected = statement.executeUpdate();
			System.out.println("Affected " + affected);

			//Closing Database
			connection.close();
		}
}
