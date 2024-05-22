package com.godoro.database.large;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlobFindTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		String path = "C:\\Users\\James\\Desktop\\Blob.jpg";
		
		// Connection to the database
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/godorodb";
		String user = "root";
		String password = "************";
		Connection connection = DriverManager.getConnection(url, user, password);

		long largeId =1;
		
		// Selecting specific process
		String sql = "select * from Large where largeId=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, largeId);

		//getting the features of the table
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			InputStream is = resultSet.getBinaryStream("blobField");
			FileOutputStream fos = new FileOutputStream(path);
			byte[] buffer = new byte [1024];
			int actual;
			while((actual=is.read(buffer))> 0) {
				fos.write(buffer,0,actual);
			}
			fos.close();
			is.close();

		} else {
			System.out.println("Product has not been found");
		}
		// Closing Database
		connection.close();
	}
}
