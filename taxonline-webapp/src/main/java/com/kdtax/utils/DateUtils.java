package com.kdtax.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String DATE_FORMAT = "MM/dd/yyyy";
	
	
	public static String getMonthYear(Date date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		return sdf.format(date);
		
	}

}
