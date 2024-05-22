package com.godoro.database.time;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class TimeInsertOldTest {
	
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			//Connection to the database
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/godorodb";
			String user = "root";
			String password = "********";
			Connection connection = DriverManager.getConnection(url, user, password);
			
			//Date
			Calendar calendarDate = Calendar.getInstance();
			calendarDate.set(1923, 9, 29);
			
			//java.util.Date date = new java.util.Date(112,10,21);
			//java.sql.Date sqlDate1 = new Date(System.currentTimeMillis());
			//java.sql.Date sqlDate2 = new Date(80,9,12);
			//java.sql.Date sqlDate3 = new Date(date.getTime());
			java.sql.Date sqlDate4 = new Date(calendarDate.getTimeInMillis());
			
			//Time
			Calendar calendarTime = Calendar.getInstance();
			calendarTime.set(Calendar.HOUR_OF_DAY, 12);
			calendarTime.set(Calendar.MINUTE, 30);
			calendarTime.set(Calendar.SECOND, 15);
			
			//java.sql.Time time1 = new java.sql.Time(System.currentTimeMillis());
			//java.sql.Time time2 = new java.sql.Time(12,30,15);
			java.sql.Time time3 = new java.sql.Time(calendarTime.getTimeInMillis());
			
			Calendar calendarStamp = Calendar.getInstance();
			calendarStamp.set(1980,8,12,12,20,15);
			
			//java.sql.Timestamp stamp1 = new java.sql.Timestamp(System.currentTimeMillis());
			//java.sql.Timestamp stamp1 = new java.sql.Timestamp(80,8,12,12,20,15,00);
			java.sql.Timestamp stamp3 = new java.sql.Timestamp(calendarStamp.getTimeInMillis());
			
			//Insertion process
			String sql = "insert into Event(dateField,timeField,stampField) values (?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDate(1, sqlDate4);
			statement.setTime(2, time3);
			statement.setTimestamp(3, stamp3);
			int affected = statement.executeUpdate();
			System.out.println("Affected " + affected);

			//Closing Database
			connection.close();
		}
}
