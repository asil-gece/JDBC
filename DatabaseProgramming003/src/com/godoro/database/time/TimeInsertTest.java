package com.godoro.database.time;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

public class TimeInsertTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Connection to the database
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/godorodb";
		String user = "root";
		String password = "**********";
		Connection connection = DriverManager.getConnection(url, user, password);
		
		/*
		 * //Date Calendar calendarDate = Calendar.getInstance(); calendarDate.set(1923,
		 * 9, 29); Date sqlDate = new Date(calendarDate.getTimeInMillis());
		 * 
		 * //Time Calendar calendarTime = Calendar.getInstance();
		 * calendarTime.set(Calendar.HOUR_OF_DAY, 12); calendarTime.set(Calendar.MINUTE,
		 * 30); calendarTime.set(Calendar.SECOND, 15); Time time = new
		 * Time(calendarTime.getTimeInMillis());
		 * 
		 * //TimeStamp Calendar calendarStamp = Calendar.getInstance();
		 * calendarStamp.set(1980,8,12,12,20,15); Timestamp stamp = new
		 * Timestamp(calendarStamp.getTimeInMillis());
		 */
		
		Date date = SqlTimeUtils.getDate(1923, 9, 29);
		Time time2 = SqlTimeUtils.getTime(12, 30, 15);
		Timestamp stamp2 = SqlTimeUtils.getTimestamp(1980,8,12,12,20,15);
		
		//Insertion process
		String sql = "insert into Event(dateField,timeField,stampField) values (?,?,?)";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDate(1, date);
		statement.setTime(2, time2);
		statement.setTimestamp(3, stamp2);
		int affected = statement.executeUpdate();
		System.out.println("Affected " + affected);

		//Closing Database
		connection.close();
	}
}
