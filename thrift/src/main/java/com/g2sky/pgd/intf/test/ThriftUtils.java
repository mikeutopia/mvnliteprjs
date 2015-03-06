package com.g2sky.pgd.intf.test;

import java.util.Calendar;
import java.util.Date;

public class ThriftUtils {
	public static final long DAY_MILLIS = 24 * 60 * 60 * 1000;

	public static Integer dayToInt(Date day) {
		if (day == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(day);
		return cal.get(Calendar.YEAR) * 10000 + (cal.get(Calendar.MONTH) + 1) * 100 + cal.get(Calendar.DAY_OF_MONTH);
	}

	public static Date intToDay(Integer dayVal) {
		if (dayVal == null) {
			return null;
		}
		int yr = dayVal / 10000;
		int mon = (dayVal % 10000) / 100 - 1;
		int day = dayVal % 100;
		Calendar cal = Calendar.getInstance();
		cal.set(yr, mon, day, 0, 0, 0);
		return cal.getTime();
	}
}
