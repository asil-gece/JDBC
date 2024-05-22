package com.godoro.database.large;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClobInsertTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {

		String path = "C:\\Users\\James\\Desktop\\BlobFindTest.java.txt";
		FileReader fr = new FileReader(path);

		// Connection to the database
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/godorodb";
		String user = "root";
		String password = "********";
		Connection connection = DriverManager.getConnection(url, user, password);

		// Insertion process
		String sql = "insert into Large(clobField) values (?)";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setCharacterStream(1, fr);
		int affected = statement.executeUpdate();
		System.out.println("Affected " + affected);

		// Closing Database
		connection.close();
	}

}
