package com.godoro.database.time;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

public class TimeFindTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Connection to the database
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/godorodb";
		String user = "root";
		String password = "********";
		Connection connection = DriverManager.getConnection(url, user, password);

		// Selecting specific process
		String sql = "select * from Event where EventId=?";
		long eventId = 9;

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, eventId);

		// getting the features of the table
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			Date dateField = resultSet.getDate("dateField");
			Time timeField = resultSet.getTime("timeField");
			Timestamp stampField = resultSet.getTimestamp("stampField");
			System.out.println("Date: " + dateField);
			System.out.println("Time: " + " " + timeField);
			System.out.println("Stamp: " + stampField);

			Calendar calendarDate = Calendar.getInstance();
			calendarDate.setTimeInMillis(dateField.getTime());
			
			Calendar calendarTime = Calendar.getInstance();
			calendarTime.setTimeInMillis(timeField.getTime());
			
			Calendar calendarStamp = Calendar.getInstance();
			calendarStamp.setTimeInMillis(stampField.getTime());

			System.out.println("Date: " + calendarDate);
			System.out.println("Time: " + " " + calendarTime);
			System.out.println("Stamp: " + calendarStamp);

		}
		// Closing Database
		connection.close();
	}
}
