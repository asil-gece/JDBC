package com.godoro.database.time;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

public class SqlTimeUtils {
	public static Date getDate(int year, int month, int day) {

		// Date
		Calendar calendarDate = Calendar.getInstance();
		calendarDate.set(year, month, day);
		Date sqlDate = new Date(calendarDate.getTimeInMillis());
		return sqlDate;
	}

	public static Time getTime(int hour, int minute, int second) {

		// Time
		Calendar calendarTime = Calendar.getInstance();
		calendarTime.set(Calendar.HOUR_OF_DAY, hour);
		calendarTime.set(Calendar.MINUTE, minute);
		calendarTime.set(Calendar.SECOND, second);
		Time time = new Time(calendarTime.getTimeInMillis());
		return time;
		
	}

	public static Timestamp getTimestamp(int year, int month, int day,int hour, int minute, int second) {

		Calendar calendarStamp = Calendar.getInstance();
		calendarStamp.set(year,month,day,hour,minute,second);
		Timestamp stamp = new Timestamp(calendarStamp.getTimeInMillis());
		return stamp;
		
		
	}
}
