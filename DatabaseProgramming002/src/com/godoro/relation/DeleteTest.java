package com.godoro.relation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		//Connection to the database
				Class.forName("com.mysql.cj.jdbc.Driver");

				String url = "jdbc:mysql://localhost:3306/godorodb";
				String user = "root";
				String password = "********";
				Connection connection = DriverManager.getConnection(url, user, password);

				//Deleting process
				String sql = "delete from Department where departmentId=?";

				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, 4);
				int affected = statement.executeUpdate();
				System.out.println("Affected " + affected);

				//Closing Database
				connection.close();
			}
	}

