package com.godoro.database.large;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClobFindTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		String path = "C:\\Users\\James\\Desktop\\Clob.txt";
		
		// Connection to the database
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/godorodb";
		String user = "root";
		String password = "********";
		Connection connection = DriverManager.getConnection(url, user, password);

		long largeId =2;
		
		// Selecting specific process
		String sql = "select * from Large where largeId=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, largeId);

		//getting the features of the table
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			Reader reader = resultSet.getCharacterStream("clobField");
			FileWriter fw = new FileWriter(path);
			char[] buffer = new char [1024];
			int actual;
			while((actual=reader.read(buffer))> 0) {
				fw.write(buffer,0,actual);
			}
			fw.close();
			reader.close();

		} else {
			System.out.println("Product has not been found");
		}
		// Closing Database
		connection.close();
	}
}
