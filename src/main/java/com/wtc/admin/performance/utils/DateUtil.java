package com.wtc.admin.performance.utils;

import com.wtc.admin.performance.model.ActiveClientNumColumn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
	
	public static final String YYYYMMDD = "yyyyMMdd";
	
	public static String dateToString(Date time, String format) {
		if (time == null) {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(time);
	}
	
	public static Date parse(String str, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			sdf.setLenient(false);
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}

